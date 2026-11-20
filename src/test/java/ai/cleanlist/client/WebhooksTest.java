package ai.cleanlist.client;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.junit.jupiter.api.Test;

class WebhooksTest {

    private static final long NOW = 1762790400L;
    private static final byte[] BODY =
            "{\"id\":\"evt_1\",\"type\":\"reply.received\",\"data\":{}}".getBytes(StandardCharsets.UTF_8);

    private static String sign(String secret, long t, byte[] body) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        mac.update((t + ".").getBytes(StandardCharsets.UTF_8));
        StringBuilder hex = new StringBuilder();
        for (byte b : mac.doFinal(body)) {
            hex.append(String.format("%02x", b));
        }
        return "t=" + t + ",v1=" + hex;
    }

    private static boolean verify(byte[] body, String header, String secret, long now) {
        return Webhooks.verifySignature(body, header, secret, Webhooks.DEFAULT_TOLERANCE_SECONDS, now);
    }

    @Test
    void acceptsAValidFreshSignature() throws Exception {
        String header = sign("whsec", NOW, BODY);
        assertTrue(verify(BODY, header, "whsec", NOW));
        String zeros = new String(new char[64]).replace('\0', '0');
        assertTrue(verify(BODY, "v1=" + zeros + "," + header, "whsec", NOW));
        String current = sign("whsec", System.currentTimeMillis() / 1000, BODY);
        assertTrue(Webhooks.verifySignature(new String(BODY, StandardCharsets.UTF_8), current, "whsec"));
    }

    @Test
    void refusesTamperedStaleAndJunk() throws Exception {
        String header = sign("whsec", NOW, BODY);
        byte[] tampered = (new String(BODY, StandardCharsets.UTF_8) + " ").getBytes(StandardCharsets.UTF_8);
        assertFalse(verify(tampered, header, "whsec", NOW));
        assertFalse(verify(BODY, header, "other", NOW));
        assertFalse(verify(BODY, header, "whsec", NOW + 301));
        String zeros = new String(new char[64]).replace('\0', '0');
        String[] junk = {null, "", "garbage", "t=abc,v1=" + zeros, "t=" + NOW, "t=" + NOW + ",v1=zz",
            "t=99999999999999999999,v1=" + zeros};
        for (String h : junk) {
            assertFalse(verify(BODY, h, "whsec", NOW), String.valueOf(h));
        }
        assertFalse(verify(null, header, "whsec", NOW));
    }
}
