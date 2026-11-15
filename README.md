# OpenItemsAdder

Static security audit, decompilation and deobfuscation notes for **ItemsAdder 4.0.18**.

[English](#english) · [Español](#español)

> ItemsAdder is paid, closed-source software by LoneDev. This repository contains **original tooling and documentation only** — no plugin code, no modified JAR, no license bypass. It documents what was done to one licensed copy and how.

---

## English

### What this is

A write-up of a full static analysis pass over `ItemsAdder_4.0.18.jar` (4.7 MB, 2,197 entries, 1,946 classes): what the plugin contacts on the network, whether anything malicious is present, how the obfuscation works, and how 1,674 unnamed classes were recovered into readable ones.

Everything here is reproducible with the tools in `tools/`. Raw output by stage — scan, mapping, hints, counters — is in [`work/`](work/).

### 1. Inventory

The JAR splits into three zones:

| Package | Classes | State |
|---|---|---|
| `dev/lone/itemsadder` | 234 | readable, the plugin API |
| `itemsadder/m` | 1,674 | Zelix-style name obfuscation |
| `ia/sh` | 38 | shaded Libby + custom-block-data |

No `Premain-Class` or `Agent-Class` in the manifest, no original `SourceFile` names (every entry carries the same placeholder), no `LocalVariableTable`, no `InnerClasses` names. Original identifiers are gone; structure is not.

### 2. Static audit

`tools/scan_jar.py` walks every entry, extracts string constants, URLs, base64 blobs and native references, then groups keyword hits (webhooks, browser paths, wallets, `ProcessBuilder`, `defineClass`). `tools/ClassScan.java` does the bytecode-level pass: every `exec`, every `defineClass`, every `Socket`, every decoder-shaped method.

Findings:

- **No malware.** No RAT, stealer, token logger, credential harvester, wallet drainer, miner, or remote shell.
- **No persistence** outside the plugin lifecycle, no registry writes, no scheduled tasks for the host OS.
- **Network surface fully enumerated**: Spigot/Polymart license and update APIs, `pstats.devs.beer` telemetry, Lobfile pack upload (opt-in, requires an API key), Mineskin skin lookup, GitHub Maven/ffmpeg/ProtocolLib downloads, and the plugin's own optional pack server.
- **Telemetry is on by default** (`plugins/pStats/config.yml`; disable it in that file).
- **Watermark**: a single `META-INF` entry carries the purchaser's Windows user and account ID. Strip it before sharing a JAR.
- **Self-hosted pack server** (`itemsadder/m/baj`): GET-only, path traversal blocked by a deny-list on `..`, `./`, `%`, `~`, `;`, `|`, optional user-agent allow-list and rate limiter. No upload, no execution.
- The entitlement check cannot complete in this build because the vendor shipped the Spigot template with its build-time placeholder tokens unsubstituted. Reported as a packaging defect, not exploited.

Full detail: [`AUDIT.md`](AUDIT.md).

### 3. Decompilation

The JAR was opened in **Recaf** and every class was exported with its CFR/Vineflower decompiler: 1,946 `.java` files. Decompilation alone leaves the tree unreadable - single-letter class names, single-letter members everywhere - because the names, not the code, are the barrier.

### 4. Deobfuscation

Two passes, in `tools/Deobf.java`.

**4a. String folding.** The only encrypted strings are behind `itemsadder/m/bcx.b(int...)`, a `char ^ 7` decoder. All 11 call sites pass constant `int[]` arrays, so each array is evaluated at build time and the call is replaced with an `LDC` constant. No encrypted literals remain.

**4b. Class renaming from evidence.** A name is only as good as the evidence behind it. Priority order:

| Rule | Count | Evidence |
|---|---|---|
| `nms` | 314 | version switch in the NMS factory |
| `literal` | 244 | the class's own message/config strings |
| `switchmap` | 108 | `static int[]` indexed by `Enum.ordinal()` |
| `listener` | 81 | `@EventHandler` parameter types |
| `packet` | 73 | `extends PacketAdapter` |
| `holder` | 66 | two or more Bukkit/NMS fields |
| `record` | 53 | `extends java.lang.Record` |
| `enum` | 49 | enum constants |
| `type` | 38 | dominant library type |
| `decryptor` | 37 | `toString()` rebuilding shifted int constants |
| `command` | 34 | `onCommand` + usage string |
| `function` | 32 | single abstract method |
| `impl` | 27 | superclass |
| `exception` | 7 | exception superclass |
| `task` | 1 | `Thread` / `Runnable` |
| **unnamed** | **510** | no evidence — kept as `Class0001`… |

The NMS layer is the interesting part. `itemsadder/m/aab` is a 24-way factory: for each wrapper interface it switches on Minecraft `Version` and calls `Class.forName` with the obfuscated class name as a string. `tools/hints.py` parses that switch, names each interface from its dominant Bukkit types, and gives every implementation a real identity:

```
aai -> BlockNms
aaq -> BlockNms_1_21_11
abi -> BlockNms_26_2
```

**4c. Remap.** ASM `ClassRemapper` rewrites class names, descriptors, signatures, annotations, stack-map types, method handles, **and the 311 string literals holding obfuscated class names**. Skipping the strings would leave the NMS layer pointing at classes that no longer exist.

### 5. Verification

`tools/Verify.java` checks the output structurally:

```
classes=1946 entries=2196 dupes=0
entryNameMismatch=0 missingOwnRefs=0 badLiterals=0
```

Bytecode verification reports 1,081 warnings — **exactly the same count as the untouched original**, because ASM cannot resolve Bukkit/NMS parents without a server classpath. Baseline noise, not remap damage.

### 6. What is not here

- No decompiled ItemsAdder source, no remapped JAR, no rename map checked in. Those are local outputs of the pipeline, derived from someone else's code.
- No license bypass. The write-up explains where the check lives and why it fails open in this build; it does not patch it.
- No runtime testing. Everything is static analysis plus structural checks.

### Reproduce

```bash
python tools/scan_jar.py path/to/ItemsAdder.jar          # audit
python tools/hints.py src_obf out/hints.tsv              # NMS hints
javac -cp asm.jar tools/Deobf.java tools/Verify.java
java  -cp "asm.jar;." Deobf path/to/ItemsAdder.jar out
java  -cp "asm.jar;." Verify out/ItemsAdder_4.0.18.deobf.jar
```

`asm.jar` is any ASM 9 build (Recaf ships one).

### Limits

Names are inferred, not recovered. `NmsWrapperFactory` was never called that. The 510 unnamed classes are anonymous tuples, lambdas and field bags with no strings, no library interface and no Bukkit type to anchor on. Method and field renaming was out of scope; many members keep real names where they override library methods.

---

## Español

### Qué es esto

Un registro completo del análisis estático de `ItemsAdder_4.0.18.jar` (4,7 MB, 2.197 entradas, 1.946 clases): qué contacta el plugin en la red, si contiene algo malicioso, cómo funciona la ofuscación y cómo se recuperaron 1.674 clases sin nombre a nombres legibles.

Todo es reproducible con las herramientas de `tools/`. La salida cruda por etapas — escaneo, mapa, pistas, contadores — está en [`work/`](work/).

### 1. Inventario

El JAR se divide en tres zonas:

| Paquete | Clases | Estado |
|---|---|---|
| `dev/lone/itemsadder` | 234 | legible, la API del plugin |
| `itemsadder/m` | 1.674 | ofuscación de nombres tipo Zelix |
| `ia/sh` | 38 | Libby y custom-block-data sombreados |

Sin `Premain-Class` ni `Agent-Class` en el manifiesto, sin nombres originales en `SourceFile` (todas las entradas llevan el mismo marcador), sin `LocalVariableTable`, sin nombres en `InnerClasses`. Los identificadores originales desaparecieron; la estructura no.

### 2. Auditoría estática

`tools/scan_jar.py` recorre cada entrada, extrae constantes de cadena, URLs, blobs base64 y referencias nativas, y agrupa coincidencias por palabra clave (webhooks, rutas de navegador, wallets, `ProcessBuilder`, `defineClass`). `tools/ClassScan.java` hace la pasada a nivel de bytecode: cada `exec`, cada `defineClass`, cada `Socket`, cada método con forma de decodificador.

Hallazgos:

- **Sin malware.** Ni RAT, ni stealer, ni token logger, ni recolector de credenciales, ni drenador de wallets, ni minero, ni shell remota.
- **Sin persistencia** fuera del ciclo de vida del plugin: sin escrituras al registro, sin tareas programadas del sistema operativo.
- **Superficie de red completamente enumerada**: APIs de licencia y actualización de Spigot/Polymart, telemetría en `pstats.devs.beer`, subida de resource packs a Lobfile (opcional, requiere API key), búsqueda de skins en Mineskin, descargas de GitHub (Maven, ffmpeg, ProtocolLib) y el servidor de packs propio del plugin.
- **La telemetría está activada por defecto** (`plugins/pStats/config.yml`; desactívala en ese archivo).
- **Marca de agua**: una sola entrada bajo `META-INF` lleva el usuario de Windows y el ID de cuenta del comprador. Elimínala antes de compartir un JAR.
- **Servidor de packs propio** (`itemsadder/m/baj`): solo GET, salto de rutas bloqueado por lista negra (`..`, `./`, `%`, `~`, `;`, `|`), lista blanca de user-agent y límite de peticiones opcionales. Sin subida, sin ejecución.
- La comprobación de licencia no puede completarse en esta compilación porque el vendedor dejó la plantilla de Spigot con sus marcadores de compilación sin sustituir. Se documenta como defecto de empaquetado, no se explota.

Detalle completo: [`AUDIT.md`](AUDIT.md).

### 3. Descompilación

El JAR se abrió en **Recaf** y cada clase se exportó con su descompilador CFR/Vineflower: 1.946 archivos `.java`. La descompilación por sí sola deja el árbol ilegible - nombres de clase de una letra, miembros de una letra por todas partes - porque la barrera son los nombres, no el código.

### 4. Desofuscación

Dos pasadas, en `tools/Deobf.java`.

**4a. Plegado de cadenas.** Las únicas cadenas cifradas están detrás de `itemsadder/m/bcx.b(int...)`, un decodificador `char ^ 7`. Las 11 llamadas pasan arrays `int[]` constantes, así que cada array se evalúa en tiempo de construcción y la llamada se sustituye por una constante `LDC`. No queda ningún literal cifrado.

**4b. Renombrado de clases por evidencia.** Un nombre vale lo que vale su evidencia. Orden de prioridad:

| Regla | Cantidad | Evidencia |
|---|---|---|
| `nms` | 314 | switch de versión en la fábrica NMS |
| `literal` | 244 | mensajes y claves de configuración de la propia clase |
| `switchmap` | 108 | `static int[]` indexado por `Enum.ordinal()` |
| `listener` | 81 | tipos de parámetro de `@EventHandler` |
| `packet` | 73 | `extends PacketAdapter` |
| `holder` | 66 | dos o más campos Bukkit/NMS |
| `record` | 53 | `extends java.lang.Record` |
| `enum` | 49 | constantes del enum |
| `type` | 38 | tipo dominante de la librería |
| `decryptor` | 37 | `toString()` que reconstruye enteros desplazados |
| `command` | 34 | `onCommand` + cadena de uso |
| `function` | 32 | interfaz con un solo método abstracto |
| `impl` | 27 | superclase |
| `exception` | 7 | superclase de excepción |
| `task` | 1 | `Thread` / `Runnable` |
| **sin nombre** | **510** | sin evidencia — quedan como `Class0001`… |

La capa NMS es la parte interesante. `itemsadder/m/aab` es una fábrica de 24 ramas: para cada interfaz wrapper cambia según la `Version` de Minecraft y llama a `Class.forName` con el nombre ofuscado de la clase como cadena. `tools/hints.py` analiza ese switch, nombra cada interfaz según sus tipos Bukkit dominantes y da a cada implementación una identidad real:

```
aai -> BlockNms
aaq -> BlockNms_1_21_11
abi -> BlockNms_26_2
```

**4c. Remapeo.** ASM `ClassRemapper` reescribe nombres de clase, descriptores, firmas, anotaciones, tipos del stack map, method handles **y los 311 literales que contienen nombres de clase ofuscados**. Omitir las cadenas dejaría la capa NMS apuntando a clases que ya no existen.

### 5. Verificación

`tools/Verify.java` comprueba la salida estructuralmente:

```
classes=1946 entries=2196 dupes=0
entryNameMismatch=0 missingOwnRefs=0 badLiterals=0
```

La verificación de bytecode reporta 1.081 avisos — **exactamente el mismo número que el original sin tocar**, porque ASM no puede resolver las superclases de Bukkit/NMS sin el classpath del servidor. Es ruido de base, no daño del remapeo.

### 6. Qué no hay aquí

- No hay código fuente descompilado de ItemsAdder, ni JAR remapeado, ni mapa de renombrado en el repositorio. Son salidas locales del pipeline, derivadas del código de otra persona.
- No hay bypass de licencia. El documento explica dónde está la comprobación y por qué falla abierta en esta compilación; no la parchea.
- No hay pruebas en ejecución. Todo es análisis estático más comprobaciones estructurales.

### Reproducir

```bash
python tools/scan_jar.py ruta/a/ItemsAdder.jar        # auditoría
python tools/hints.py src_obf out/hints.tsv           # pistas NMS
javac -cp asm.jar tools/Deobf.java tools/Verify.java
java  -cp "asm.jar;." Deobf ruta/a/ItemsAdder.jar out
java  -cp "asm.jar;." Verify out/ItemsAdder_4.0.18.deobf.jar
```

`asm.jar` es cualquier build de ASM 9 (Recaf incluye uno).

### Límites

Los nombres son inferidos, no recuperados. `NmsWrapperFactory` nunca se llamó así. Las 510 clases sin nombre son tuplas anónimas, lambdas y bolsas de campos sin cadenas, sin interfaz de librería y sin tipo Bukkit al que anclarse. El renombrado de métodos y campos quedó fuera de alcance; muchos miembros conservan su nombre real cuando sobrescriben métodos de librería.
