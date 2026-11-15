# Deobfuscation: 1,674-class rename mapping

The 1,674 classes in `itemsadder/m/` are name-obfuscated and have no `LocalVariableTable`, no original `SourceFile` name, and no `InnerClasses` names. Original identifiers are not recoverable. What is recoverable is **structure**: what each class is, from how it is used.

Every one of the 1,674 gets a name. 1,523 are backed by evidence; the remaining 151 have no anchor at all and carry a role prefix plus a number (`Opaque001` … `Opaque151`). The per-class description of what each one does is in [`CLASSES.md`](CLASSES.md).

## Pipeline

1. **Fold XOR strings.** `itemsadder/m/bcx.b(int...)` is a `char ^ 7` decoder. 11 call sites carry constant `int[]` literals; each is evaluated at build time and replaced with an `LDC`. No encrypted strings remain in the factory.
2. **Name from evidence**, in priority order.
3. **Apply** with ASM `ClassRemapper`. Class names, descriptors, signatures, annotations, `StackMapTable` types, method handles, and the string literals holding obfuscated class names (used by `Class.forName` in the NMS factory) are all remapped.
4. **Verify** each output class: entry name matches internal name, every `itemsadder/` reference resolves, every reflected name resolves, no duplicate entries, bytecode verifier parity with the original.

## Naming rules and counts

| Kind | Count | Evidence used |
|---|---|---|
| `nms` | 314 | NMS wrapper factory switch: base interface + Minecraft version |
| `type` | 313 | dominant type in fields and signatures, library over Bukkit |
| `switchmap` | 108 | static `int[]` indexed by `SomeEnum.ordinal()` |
| `literal` | 103 | the class's own message/config strings |
| `listener` | 81 | `@EventHandler` parameter types; shared bases get `…ListenerBase` |
| `packet` | 73 | `extends PacketAdapter`, plus the `PacketType` constant when present |
| `impl` | 67 | named superclass or the single named interface it implements |
| `holder` | 62 | two or more Bukkit/NMS fields |
| `builder` | 58 | several one-argument methods returning `this`; named after the type it produces |
| `record` | 53 | `extends java.lang.Record` |
| `enum` | 49 | enum constants |
| `dto` | 45 | fields only, no methods; named after field shape (`IntStrData`) |
| `interface` | 45 | non-functional interface: contract over a dominant type |
| `decryptor` | 37 | `toString()` rebuilding a string from shifted int constants |
| `command` | 34 | `onCommand` + usage label |
| `function` | 32 | single abstract method |
| `singleton` | 27 | holds a reference to its own type |
| `registry` | 14 | self reference plus a `Map`/`List` |
| `exception` | 7 | superclass ends in `Exception` |
| `task` | 1 | `Thread` / `Runnable` |
| **no anchor** | **151** | none — `Opaque001` … `Opaque151` |

Examples:

```
aab  -> NmsWrapperFactory          (311 Class.forName targets)
aaq  -> BlockNms_1_21_11           (implements BlockNms, MC 1.21.11)
tx   -> EntityDeathListener        (@EventHandler EntityDeathEvent)
asf  -> PlayerQuitListenerBase     (13 subclasses share it)
bcf  -> Consumer_2                 (functional interface)
bx   -> EntityTypeSwitchMap        (static int[] over EntityType.ordinal())
da   -> IainternalPlayer           (own config key literal)
aeg  -> Opaque001                  (no anchor: 0 fields, 1 method)
```

## NMS layer

`itemsadder/m/aab` is a 24-way factory: for each wrapper interface (`aai`, `abl`, …) it switches on `Version` and calls `Class.forName` with the obfuscated class name as a string. `tools/hints.py` parses that switch to give each target its real identity:

```
aai  -> BlockNms
aaq  -> BlockNms_1_21_11
abi  -> BlockNms_26_2
```

The base name comes from the interface's dominant Bukkit types (`Block`, `Player`, `Sound`, …), so `BlockNms_1_21_11` reads as "block wrapper, MC 1.21.11".

## Catalogue

`tools/Describe.java` reads the renamed JAR and emits one fact row per class — superclass, interfaces, field and method counts, static count, `@EventHandler` types, Bukkit and ItemsAdder types, external call targets, enum constants, field types, fluent setter count. `tools/render_catalog.py` turns those rows into [`CLASSES.md`](CLASSES.md): 21 sections, one row per class, one sentence per row describing what the class is for.

The description is generated, not hand-written: it states the role the evidence supports and nothing more. `Opaque` classes get their real field and method counts and the types they touch, so even an unnamed class is identifiable by shape.

## Verification

```
classes=1946 entries=2195 dupes=0
entryNameMismatch=0 missingOwnRefs=0 badLiterals=0
```

`bytecodeIssues=1081` is identical on the original JAR: ASM's `CheckClassAdapter` cannot resolve Bukkit/NMS parents without the server on the classpath and throws on `INVOKEINTERFACE`. It is a verifier limitation, not a remap defect — the number matches the unmodified input exactly.

## Limits

- Names are **inferred**, not original. `NmsWrapperFactory` was never called that.
- 151 classes have no evidence at all: anonymous tuples, lambdas, and field bags with no strings, no library interfaces, and no Bukkit types. They keep the `Opaque` role and a number.
- 1,057 names carry a `_N` suffix because they share a category (`PacketListener_57`, `ItemStackBridge_42`). The category is honest; the number is not an identity. The "what it does" column of the catalogue is what separates them.
- Only **classes** are renamed. Methods and fields keep their obfuscated names (many keep real names where they override library methods).
- Nothing was executed. This is static analysis plus structural checks.

## Files

| Path | What |
|---|---|
| [`work/03-deobfuscation/mapping.tsv`](work/03-deobfuscation/mapping.tsv) | 1,674 rows: old, new, kind |
| [`work/03-deobfuscation/mapping-with-evidence.tsv`](work/03-deobfuscation/mapping-with-evidence.tsv) | same rows plus the evidence column |
| [`work/03-deobfuscation/classes.tsv`](work/03-deobfuscation/classes.tsv) | 1,674 rows of structural facts used by the catalogue |
| [`work/03-deobfuscation/nms-hints.tsv`](work/03-deobfuscation/nms-hints.tsv) | NMS factory targets: obfuscated name → wrapper + version |
| [`work/04-decompiled/ItemsAdder_4.0.18.deobf.jar`](work/04-decompiled/ItemsAdder_4.0.18.deobf.jar) | renamed JAR (watermark entry removed) |
| [`work/04-decompiled/renamed/`](work/04-decompiled/renamed) | 1,946 decompiled classes with the new names |
| [`work/04-decompiled/original/`](work/04-decompiled/original) | 1,946 decompiled classes, obfuscated names, for diffing |
| [`tools/Deobf.java`](tools/Deobf.java) | the mapper |
| [`tools/Describe.java`](tools/Describe.java) | structural fact extractor |
| [`tools/render_catalog.py`](tools/render_catalog.py) | catalogue renderer |
| [`tools/hints.py`](tools/hints.py) | NMS factory parser |
| [`tools/Verify.java`](tools/Verify.java) | structural validator |

## Reproduce

```
python tools/hints.py ..\src_obf out\hints.tsv
javac -cp asm.jar tools/Deobf.java tools/Describe.java tools/Verify.java
java  -cp "asm.jar;." Deobf    ItemsAdder_4.0.18.jar out
java  -cp "asm.jar;." Describe out\ItemsAdder_4.0.18.deobf.jar out\mapping.tsv out\classes.tsv
java  -cp "asm.jar;." Verify   out\ItemsAdder_4.0.18.deobf.jar
python tools/render_catalog.py
```

`Deobf` reads `<out>/hints.tsv` if present. Without it, the 314 NMS names fall back to the generic rules.
