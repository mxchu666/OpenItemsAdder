# ItemsAdder 4.0.18 — static security audit

Target: `ItemsAdder_4.0.18.jar` (4,704,302 bytes, 2,197 entries, 1,946 classes)
Scope: static analysis of the shipped artifact plus decompiled source. No dynamic execution against a live server.
Audit date: 2026-11-14

## Verdict

No malware, RAT, stealer, token logger, credential harvester, wallet drainer, miner, or remote-shell component was found.

What the plugin does that touches the outside world is ordinary for a paid Spigot plugin of this kind: license validation, anonymous usage telemetry, update checks, library downloads, an optional self-hosted resource-pack HTTP server, and an optional file-upload integration. Each is listed below with its trigger conditions and how to turn it off.

## Artifact shape

| Item | Value |
|---|---|
| Main class | `dev.lone.itemsadder.Main` |
| Version | 4.0.18 |
| Obfuscator | Zelix-style name obfuscation (`itemsadder/m`, 1,674 classes) |
| String encryption | none global; one XOR-7 `int[]` decoder in `itemsadder/m/bcx` |
| Watermark | one `META-INF` entry with a vendor-generated name → purchaser's Windows user name and account ID (redacted) |
| Manifest | no `Premain-Class`, no `Agent-Class`, no agent attachment |

The manifest has no `Agent-Class`/`Premain-Class`, so the JAR cannot attach to a JVM as an agent. There is no `JarEntry` self-extraction to disk outside the plugin data folder.

## Outbound endpoints

All literals found in the constant pool. Nothing else.

- `api.spigotmc.org` — license check, resource metadata
- `api.polymart.org` — license / update
- `pstats.devs.beer` — anonymous telemetry
- `lobfile.com` — optional resource-pack hosting
- `api.mineskin.org` — player skin lookup
- `api.github.com`, `github.com/dmulloy2/ProtocolLib` — ProtocolLib version check / dev build
- `github.com/ItemsAdder/ffmpeg-assets` — ffmpeg binaries for audio conversion
- `mc-assets-downloader.lonedev.workers.dev` — vanilla asset download
- `itemsadder.devs.beer`, `a.devs.beer` — docs / wiki links opened in chat
- Maven mirrors: `repo1.maven.org`, `oss.sonatype.org`, `jitpack.io`, `jcenter.bintray.com`, `maven.aliyun.com`, `maven-central.storage-download.googleapis.com`, `repo.alessiodp.com`

No Discord webhook, no Telegram bot API, no paste site, no unknown host.

## Components reviewed

### 1. License validation — `Main.loadConfig0()`, `Main.onEnable`, `itemsadder/m/bcx`

Three branches: Spigot premium API, Polymart, BuiltByBit. Failure path prints a license message and, for beta builds, can disable the plugin via reflection on `PluginManager`.

Finding: in this build the vendor's Spigot user, resource and nonce placeholders are unsubstituted, so the request cannot succeed; the returned status is treated as unknown and the code proceeds. This is a defect in the vendor's packaging, not a backdoor. Reported here as an observation only.

### 2. Telemetry — `dev.lone.itemsadder.g`, `dev.lone.itemsadder.n`, `itemsadder/m/t`

bStats-style service at `pstats.devs.beer`. Server UUID generated locally and stored in `plugins/pStats/config.yml`. Sends: server version, plugin count, player counts, feature usage counters.

Default: **enabled**. Opt out by disabling it in `plugins/pStats/config.yml`. The plugin reads that file before starting the reporter.

### 3. Self-hosted resource-pack server — `itemsadder/m/baj`, `bag`, `bah`

Opt-in HTTP server bound by config. Serves files from the pack directory.

- Method allow-list: `GET` only; anything else → 405.
- Traversal: deny-list covering dot-segments, percent-encoding, tilde, semicolon and pipe before path resolution → `SecurityException` → 401. Percent encoding is blocked, so encoded traversal does not pass.
- Optional user-agent allow-list (browser and Minecraft prefixes) and Minecraft header requirement.
- Optional per-IP/UUID rate limiter with block duration.

No upload, no execution, no directory listing.

### 4. Lobfile upload — `itemsadder/m/baf`, `itemsadder/m/ah`

Uploads the built resource pack to `lobfile.com` when the operator configures an API key in `secret.yml`. The shipped `secret.yml` carries a placeholder key shorter than the upload path's minimum, so the upload aborts out of the box. Optional.

### 5. Library loading — `dev/lone/itemsadder/b`, `ia/sh/libby/*`

Libby downloads Maven artifacts at runtime into the plugin data folder and loads them in an isolated classloader. Standard for this plugin family. Downloads are HTTPS from the repositories listed above; no integrity check beyond TLS.

### 6. In-memory class loading — `itemsadder/m/wf`, `itemsadder/m/wi`

`MemoryClassLoader` defines classes from `byte[]` supplied at runtime. Used by the scripting subsystem (`wi` compiles/caches script classes). It does not read class bytes from the network. No `defineClass` call site receives bytes from an HTTP response.

### 7. Shader compilation — `dev/lone/itemsadder/resourcepack/bv`

Reflective call into a bundled native shader compiler used during resource-pack generation. Inputs are the pack's own `.vsh`/`.fsh` files.

### 8. ffmpeg — `itemsadder/m/h`

Downloads the platform zip from the ItemsAdder GitHub release and runs ffmpeg with an `-i` input argument for audio conversion during pack build. No other process execution exists in the JAR (verified: all `ProcessBuilder` call sites are in this class).

### 9. Journal / metrics hooks — `dev/lone/itemsadder/h`, `j`, `l`, `m`

bStats custom chart builders. No I/O beyond the telemetry sender.

## Things that are absent

- No `java.net.Socket` to a hardcoded host other than the pack server's own listener.
- No reads of `%APPDATA%`, browser profile directories, `login data`, `Local State`, `wallet.dat`, Discord/Local Storage, or SSH keys.
- No `System.getenv` harvesting, no clipboard access.
- No reflective `Runtime.exec` outside ffmpeg.
- No persistence: no scheduled task, no registry write, no startup entry, no service install.
- No crypto, no mining, no file encryption.
- No `Class.forName` on attacker-controlled strings beyond script class names generated in-process.

## Residual risk (operational, not malicious)

1. Telemetry is on by default and reports server identity statistics to a third party.
2. A watermark entry under `META-INF` embeds the purchaser's Windows user and Spigot user ID in every copy of the JAR. Redistributing the JAR leaks that identifier.
3. Runtime library downloads (ProtocolLib dev build, Maven artifacts, ffmpeg) are trusted by TLS and GitHub/Maven account security, not by signature.
4. The self-host pack server is plain HTTP; the pack is public content by design.

## Reproduction

```
python tools/scan_jar.py <path-to-jar>
```

The scanner walks every class, extracts string constants and method references, and flags webhooks, credential paths, wallet paths, process execution, class definition, and socket use. Output is grouped by category.

Raw decompilation was produced with Recaf (CFR/Vineflower). The full source tree, renamed and original, is committed under `work/04-decompiled/` — it is LoneDev's code, copied for analysis, and the original licence still governs reuse.
