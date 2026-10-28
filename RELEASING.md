# Releasing `ai.cleanlist:cleanlist-java` to Maven Central

Artifacts are published to **Maven Central** through the [Sonatype Central
Portal](https://central.sonatype.com). Once published they're consumable by both
Maven and Gradle users — there is no separate "Gradle registry".

The `pom.xml` is already wired for this: it produces `-sources.jar` and
`-javadoc.jar`, GPG-signs everything (the `sign-artifacts` profile), and uploads via the
`central-publishing-maven-plugin` with `autoPublish=false` (uploads a **reviewable draft**
you release from the Portal UI).

## One-time setup

1. **Central Portal account** — sign in at <https://central.sonatype.com> (GitHub login works).
2. **Verify the `ai.cleanlist` namespace** — Portal → *Namespaces* → add `ai.cleanlist`.
   You'll be given a TXT record to add to the `cleanlist.ai` DNS zone; verification is
   automatic once it propagates. This is required before any `ai.cleanlist.*` artifact
   can be published.
3. **Generate a user token** — Portal → *Account* → *Generate User Token*. Yields a
   username/password pair.
4. **GPG signing key** — Central requires signed artifacts:
   ```bash
   gpg --batch --gen-key   # name it, e.g., "Cleanlist <sal@cleanlist.ai>"
   gpg --list-secret-keys --keyid-format=long        # note the KEYID
   gpg --keyserver hkps://keys.openpgp.org --send-keys <KEYID>
   ```

## Configure credentials (`~/.m2/settings.xml`)

Never commit this — it lives in your home directory:

```xml
<settings>
  <servers>
    <server>
      <id>central</id>                 <!-- matches publishingServerId in pom.xml -->
      <username>CENTRAL_TOKEN_USERNAME</username>
      <password>CENTRAL_TOKEN_PASSWORD</password>
    </server>
  </servers>
</settings>
```

If your GPG key has a passphrase, also add a profile setting `<gpg.passphrase>…</gpg.passphrase>`
(the pom already passes `--pinentry-mode loopback` for non-interactive signing).

## Publish

```bash
# JDK 17+ recommended
mvn -Psign-artifacts -DskipTests -Dmaven.javadoc.failOnError=false clean deploy
```

This signs, uploads and publishes in one go (`autoPublish=true` in the pom).

## Cutting a new version

Releases are automatic. Every push to `main` runs `.github/workflows/release.yml`,
which picks the next version from Conventional Commits since the last `v*` tag
(`feat!:`/`BREAKING CHANGE:` → major, `feat:` → minor, `fix:`/`perf:` → patch,
anything else → no release), bumps it everywhere, commits `chore(release): vX.Y.Z`,
tags it, creates a GitHub Release and publishes it to Maven Central.

It needs these repo secrets: `CENTRAL_TOKEN_USERNAME`, `CENTRAL_TOKEN_PASSWORD`,
`GPG_PRIVATE_KEY` (armored) and `GPG_PASSPHRASE` (empty if the key has none).

> Maven Central is **immutable**: a version can never be overwritten or deleted once
> published.
