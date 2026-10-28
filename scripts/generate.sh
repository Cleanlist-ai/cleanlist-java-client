#!/usr/bin/env bash
#
# Regenerate the Cleanlist Java SDK from the v2 OpenAPI schema.
#
# Uses openapi-generator-cli (java / okhttp-gson, pinned in openapitools.json).
# Re-run whenever openapi/cleanse-api-v2.oas.json changes.
#
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT"

RAW_SPEC="openapi/cleanse-api-v2.oas.json"
GEN_SPEC="openapi/cleanse-api-v2.clean.json"
BUILD="$ROOT/.build/java"
PKG_VERSION="${PKG_VERSION:-4.0.0}"
PYTHON="${PYTHON:-python3}"

REPO_URL="https://github.com/Cleanlist-ai/cleanlist-java-client"

echo "==> Preparing spec (clean operationIds -> readable method names)"
"$PYTHON" scripts/prepare_spec.py "$RAW_SPEC" "$GEN_SPEC"

echo "==> Generating java (okhttp-gson) client"
rm -rf "$BUILD"
# Metadata is passed via a JSON config file (values contain spaces/parens that the
# npx wrapper cannot safely forward through --additional-properties on the CLI).
npx --yes @openapitools/openapi-generator-cli generate \
  -i "$GEN_SPEC" \
  -g java \
  -o "$BUILD" \
  -c scripts/java-generator-config.json

echo "==> Assembling project (Maven layout at repo root)"
rm -rf "$ROOT/src" "$ROOT/api" "$ROOT/docs" "$ROOT/gradle"
cp -R "$BUILD/src" "$ROOT/src"
[ -d "$BUILD/api" ] && cp -R "$BUILD/api" "$ROOT/api" || true
[ -d "$BUILD/docs" ] && cp -R "$BUILD/docs" "$ROOT/docs" || true
cp -R "$BUILD/gradle" "$ROOT/gradle"
# pom.xml is hand-maintained (Central publishing + gpg signing): never overwrite it.
cp "$BUILD/build.gradle" "$BUILD/settings.gradle" \
   "$BUILD/gradle.properties" "$BUILD/gradlew" "$BUILD/gradlew.bat" "$ROOT/"
cp "$BUILD/.openapi-generator-ignore" "$ROOT/.openapi-generator-ignore" 2>/dev/null || true
chmod +x "$ROOT/gradlew"

echo "==> Applying hand-authored overlay (Cleanlist convenience facade)"
cp "$ROOT/overlay/Cleanlist.java" "$ROOT/src/main/java/ai/cleanlist/client/Cleanlist.java"

echo "==> Done. Build with: mvn -q -DskipTests package   (or ./gradlew build)"
