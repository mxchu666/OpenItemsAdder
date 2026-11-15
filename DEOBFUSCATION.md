# Deobfuscation: 1,674-class rename mapping

The 1,674 classes in `itemsadder/m/` are name-obfuscated and have no `LocalVariableTable`, no original `SourceFile` name, and no `InnerClasses` names. Original identifiers are not recoverable. What is recoverable is **structure**: what each class is, from how it is used.

This pass produces a complete mapping — every one of the 1,674 gets a name — with 1,164 backed by evidence and 510 placeholders.

## Pipeline

1. **Fold XOR strings.** `itemsadder/m/bcx.b(int...)` is a `char ^ 7` decoder. 11 call sites carry constant `int[]` literals; each is evaluated at build time and replaced with an `LDC`. No encrypted strings remain in the factory.
2. **Name from evidence**, in priority order.
3. **Apply** with ASM `ClassRemapper`. Class names, descriptors, signatures, annotations, `StackMapTable` types, method handles, and string literals of the form `itemsadder.m.X` (used by `Class.forName` in the NMS factory) are all remapped.
4. **Verify** each output class: entry name matches internal name, every `itemsadder/` reference resolves, every reflected name resolves, no duplicate entries, bytecode verifier parity with the original.

## Naming rules and counts

| Kind | Count | Evidence used |
|---|---|---|
| `nms` | 314 | NMS wrapper factory switch: base interface + Minecraft version |
| `literal` | 244 | the class's own message/config strings |
| `switchmap` | 108 | static `int[]` indexed by `SomeEnum.ordinal()` |
| `listener` | 81 | `@EventHandler` method parameter types |
| `packet` | 73 | `extends PacketAdapter` |
| `holder` | 66 | two or more Bukkit/NMS fields |
| `record` | 53 | `extends java.lang.Record` |
| `enum` | 49 | enum constants |
| `type` | 38 | dominant ItemsAdder/library type in fields and signatures |
| `decryptor` | 37 | `toString()` rebuilding a string from shifted int constants |
| `command` | 34 | `onCommand` + usage string |
| `function` | 32 | single abstract method |
| `impl` | 27 | superclass name |
| `exception` | 7 | superclass ends in `Exception` |
| `task` | 1 | `Thread` / `Runnable` |
| **fallback** | **510** | none — named `Class0001` … `Class0510` |

Examples:

```
aab  -> NmsWrapperFactory          (311 Class.forName targets)
aaq  -> BlockNms_1_21_11           (implements BlockNms)
tx   -> EntityDeathListener        (@EventHandler EntityDeathEvent)
vm   -> PrepareItemCraftListener   (@EventHandler PrepareItemCraftEvent)
bcf  -> Consumer_2                 (functional interface)
bx   -> EntityTypeSwitchMap        (static int[] over EntityType.ordinal())
da   -> IainternalPlayer           (literal "iainternal:player")
```

## NMS layer

`itemsadder/m/aab` is a 24-way factory: for each wrapper interface (`aai`, `abl`, …) it switches on `Version` and calls `Class.forName("itemsadder.m.X")`. `tools/hints.py` parses that switch to give each target its real identity:

```
aai  -> BlockNms
aaq  -> BlockNms_1_21_11
abi  -> BlockNms_26_2
```

The base name comes from the interface's dominant Bukkit types (`Block`, `Player`, `Sound`, …), so `BlockNms_1_21_11` reads as "block wrapper, MC 1.21.11".

## Verification

```
classes=1946 entries=2196 dupes=0
entryNameMismatch=0 missingOwnRefs=0 badLiterals=0
```

`bytecodeIssues=1081` is identical on the original JAR: ASM's `CheckClassAdapter` cannot resolve Bukkit/NMS parents without the server on the classpath and throws on `INVOKEINTERFACE`. It is a verifier limitation, not a remap defect — the number matches the unmodified input exactly.

## Limits

- Names are **inferred**, not original. `NmsWrapperFactory` was never called that.
- 510 classes have no evidence at all: they are anonymous tuples, lambdas, and field bags with no strings, no library interfaces, and no Bukkit types. They stay `ClassNNNN`.
- Only **classes** are renamed. Methods and fields keep their obfuscated names (many keep real names where they override library methods).
- Nothing was executed. This is static analysis plus structural checks.

## Files

| Path | What |
|---|---|
| `out/mapping.tsv` | 1,674 rows: old, new, kind, evidence |
| `out/ItemsAdder_4.0.18.deobf.jar` | renamed JAR (watermark entry removed) |
| `src/` | 1,946 decompiled classes with the new names |
| `Deobf.java` | the mapper |
| `hints.py` | NMS factory parser |
| `Verify.java` | structural validator |

## Reproduce

```
python hints.py ..\src_obf out\hints.tsv
javac -cp asm.jar Deobf.java Verify.java
java  -cp "asm.jar;." Deobf ItemsAdder_4.0.18.jar out
java  -cp "asm.jar;." Verify out\ItemsAdder_4.0.18.deobf.jar
```

`Deobf` reads `<out>/hints.tsv` if present. Without it, the 314 NMS names fall back to the generic rules.
