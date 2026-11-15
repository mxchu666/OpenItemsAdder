# Estadísticas de desofuscación — ItemsAdder 4.0.18

Entrada: 1.946 clases, 1674 de ellas en `itemsadder/m/` (ofuscadas).
Salida: 1674 nombres asignados, 1.946 clases descompiladas.

## Distribución de reglas

| Tipo | Cantidad | Evidencia |
|---|---|---|
| nms | 314 | switch de versión de la fábrica NMS |
| type | 313 | tipo dominante (librería o Bukkit) |
| fallback | 151 | ninguna — `OpaqueNNN` |
| switchmap | 108 | `static int[]` sobre `Enum.ordinal()` |
| literal | 103 | mensajes y claves de configuración propios |
| listener | 81 | tipos de parámetro de `@EventHandler` |
| packet | 73 | `extends PacketAdapter` |
| impl | 67 | superclase o interfaz ya nombrada |
| holder | 62 | dos o más campos Bukkit/NMS |
| builder | 58 | varios setters que devuelven `this` |
| record | 53 | `extends java.lang.Record` |
| enum | 49 | constantes del enum |
| dto | 45 | sólo campos, sin métodos |
| interface | 45 | interfaz no funcional: contrato de N métodos |
| decryptor | 37 | `toString()` que reconstruye enteros desplazados |
| command | 34 | `onCommand` + etiqueta de uso |
| function | 32 | interfaz con un solo método abstracto |
| singleton | 27 | referencia a sí misma (instancia única) |
| registry | 14 | referencia a sí misma + colección |
| exception | 7 | superclase de excepción |
| task | 1 | `Thread` / `Runnable` |

Con nombre respaldado por evidencia: 1523 / 1674 (91.0 %).
Sin ancla: 151 (`Opaque001` … `Opaque151`).

## Plegado de cadenas

11 llamadas a `itemsadder/m/bcx.b(int...)`, todas con argumentos `int[]` constantes.
11 plegadas, 0 literales cifrados restantes.

## Verificación

```
classes=1946  entries=2195  dupes=0
entryNameMismatch=0
missingOwnRefs=0
badLiterals=0
bytecodeIssues=1081
```

`bytecodeIssues` es el mismo número en la entrada sin tocar: ASM no puede resolver las
superclases de Bukkit/NMS sin el classpath del servidor y falla en `INVOKEINTERFACE`.
Es ruido de base, no daño del remapeo.

## Límites

- Los nombres son inferidos, no recuperados.
- Las clases `Opaque` no tienen ancla: tuplas anónimas, lambdas y bolsas de campos.
- Sólo se renombraron clases; métodos y campos conservan el nombre ofuscado salvo
  donde sobrescriben métodos de librería.
- Análisis estático; no se ejecutó nada.

El catálogo clase por clase, con qué hace cada una, está en [`../../CLASSES.md`](../../CLASSES.md).
