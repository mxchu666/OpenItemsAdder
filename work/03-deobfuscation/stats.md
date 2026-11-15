# Deobfuscation stats — ItemsAdder 4.0.18

Input: 1,946 classes, 1,674 of them in `itemsadder/m/` (obfuscated).
Output: 1,674 mapped names, 1,946 decompiled classes.

## Rule distribution

| Kind | Count | Evidence |
|---|---|---|
| fallback | 510 | none — `Class0001` … `Class0510` |
| nms | 314 | NMS factory version switch |
| literal | 244 | own message/config strings |
| switchmap | 108 | `static int[]` over `Enum.ordinal()` |
| listener | 81 | `@EventHandler` parameter types |
| packet | 73 | `extends PacketAdapter` |
| holder | 66 | two or more Bukkit/NMS fields |
| record | 53 | `extends java.lang.Record` |
| enum | 49 | enum constants |
| type | 38 | dominant library type |
| decryptor | 37 | `toString()` rebuilding shifted int constants |
| command | 34 | `onCommand` + usage string |
| function | 32 | single abstract method |
| impl | 27 | superclass |
| exception | 7 | exception superclass |
| task | 1 | `Thread` / `Runnable` |

Named from evidence: 1,164 / 1,674 (69.5%).

## String folding

11 call sites to `itemsadder/m/bcx.b(int...)`, all with constant `int[]` arguments.
11 inlined, 0 encrypted literals left.

## Verification

```
classes=1946  entries=2196  dupes=0
entryNameMismatch=0
missingOwnRefs=0
badLiterals=0
bytecodeIssues=1081
```

`bytecodeIssues` is the same count on the untouched input: ASM's `CheckClassAdapter` cannot resolve Bukkit/NMS parents without a server classpath and throws on `INVOKEINTERFACE`. Baseline, not remap damage.

## Known limits

- Names are inferred, not recovered.
- 510 classes have no anchor: anonymous tuples, lambdas, field bags.
- Only classes were renamed; methods and fields keep their obfuscated names except where they override library methods.
- Static analysis only; nothing was executed.
