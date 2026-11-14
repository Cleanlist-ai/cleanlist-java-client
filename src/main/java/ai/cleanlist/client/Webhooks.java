/*
 * Verifies the Cleanlist-Signature header on webhook deliveries.
 *
 * Hand-authored (not generated) and re-applied on every regeneration by
 * scripts/generate.sh.
 */
package ai.cleanlist.client;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * The header is {@code t=<unix seconds>,v1=<hex HMAC-SHA256 of "<t>.<raw body>">}, keyed with the
 * secret {@code POST /api/v2/webhooks} returned once.
 * <pre>{@code
 * boolean ok = Webhooks.verifySignature(rawBody, request.getHeader("Cleanlist-Signature"), secret);
 * }</pre>
 */
public final class Webhooks {

    public static final String SIGNATURE_HEADER = "Cleanlist-Signature";
    /** Deliveries signed longer ago than this are refused, so a captured one can't be replayed later. */
    public static final long DEFAULT_TOLERANCE_SECONDS = 300;

    private static final Pattern HEX_SHA256 = Pattern.compile("[0-9a-fA-F]{64}");
    private static final Pattern DIGITS = Pattern.compile("[0-9]{1,18}");

    private Webhooks() {}

    /** {@code payload} is the raw request body exactly as received; re-serialized JSON won't match. */
    public static boolean verifySignature(String payload, String signatureHeader, String secret) {
        return verifySignature(
                payload == null ? null : payload.getBytes(StandardCharsets.UTF_8), signatureHeader, secret);
    }

    public static boolean verifySignature(byte[] payload, String signatureHeader, String secret) {
        return verifySignature(
                payload, signatureHeader, secret, DEFAULT_TOLERANCE_SECONDS, System.currentTimeMillis() / 1000);
    }

    public static boolean verifySignature(
            byte[] payload, String signatureHeader, String secret, long toleranceSeconds, long nowSeconds) {
        if (payload == null || signatureHeader == null || secret == null || secret.isEmpty()) {
            return false;
        }
        String timestamp = null;
        List<String> signatures = new ArrayList<>();
        for (String part : signatureHeader.split(",")) {
            int eq = part.indexOf('=');
            if (eq < 0) {
                continue;
            }
            String key = part.substring(0, eq).trim();
            String value = part.substring(eq + 1).trim();
            if ("t".equals(key)) {
                timestamp = value;
            } else if ("v1".equals(key) && HEX_SHA256.matcher(value).matches()) {
                signatures.add(value.toLowerCase(Locale.ROOT));
            }
        }
        if (timestamp == null || !DIGITS.matcher(timestamp).matches() || signatures.isEmpty()) {
            return false;
        }
        if (Math.abs(nowSeconds - Long.parseLong(timestamp)) > toleranceSeconds) {
            return false;
        }

        byte[] expected;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            mac.update((timestamp + ".").getBytes(StandardCharsets.UTF_8));
            expected = toHex(mac.doFinal(payload)).getBytes(StandardCharsets.US_ASCII);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new IllegalStateException("HmacSHA256 is unavailable", e);
        }
        boolean match = false;
        for (String candidate : signatures) {
            // MessageDigest.isEqual compares in constant time.
            match |= MessageDigest.isEqual(expected, candidate.getBytes(StandardCharsets.US_ASCII));
        }
        return match;
    }

    private static String toHex(byte[] bytes) {
        StringBuilder out = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            out.append(Character.forDigit((b >> 4) & 0xF, 16)).append(Character.forDigit(b & 0xF, 16));
        }
        return out.toString();
    }
}
