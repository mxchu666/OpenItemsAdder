# Bytecode surface summary

Output of `tools/ClassScan.java`. Method signatures only: string payloads are not published.

| category | count |
|---|---|
| NET | 136 |
| STR | 52 |
| DEC | 9 |
| DEF | 4 |
| PROC | 3 |
| EXEC | 0 |

## Process execution and class definition sites

```
DEF dev/lone/itemsadder/resourcepack/bv.At()Ljava/lang/reflect/Method;
DEF ia/sh/libby/classloader/IsolatedClassLoader.defineClass(Ljava/lang/String;Ljava/io/InputStream;)Ljava/lang/Class;
DEF itemsadder/m/wf.findClass(Ljava/lang/String;)Ljava/lang/Class;
DEF itemsadder/m/wf.loadClass(Ljava/lang/String;Z)Ljava/lang/Class;
PROC itemsadder/m/h.a(Ljava/io/File;Ljava/io/File;Litemsadder/m/i;)Ljava/io/File;
PROC itemsadder/m/h.d(Ljava/io/File;)D
PROC itemsadder/m/h.e(Ljava/io/File;)V
```
