# Catálogo de clases — ItemsAdder 4.0.18

Las 1.674 clases de `itemsadder/m/` estaban ofuscadas: nombres de una o dos letras, sin `LocalVariableTable`, sin nombres originales en `SourceFile`, sin `InnerClasses`. Los identificadores originales **no se pueden recuperar**. Lo que sí se recupera es la estructura: qué hace cada clase, deducido del bytecode.

Este catálogo cubre las 1.674. **1523** tienen nombre respaldado por evidencia (`nms`, `listener`, `packet`, `builder`, `record`, `enum`, …); las **151** restantes no tienen ninguna pista y conservan el rol `Opaque` con un número.

La columna «Antes» es el nombre ofuscado original. La columna «Qué hace» se genera a partir de la superclase, las interfaces, los tipos usados, las anotaciones y los miembros; no es una descripción escrita a mano clase por clase.

Método completo: [`DEOBFUSCATION.md`](DEOBFUSCATION.md). Mapa de renombrado: [`work/03-deobfuscation/mapping.tsv`](work/03-deobfuscation/mapping.tsv).

## Índice

- [Wrappers NMS](#wrappers-nms) — 314
- [Listeners de Bukkit](#listeners-de-bukkit) — 81
- [Adaptadores de paquetes](#adaptadores-de-paquetes) — 73
- [Comandos](#comandos) — 34
- [Contratos e interfaces](#contratos-e-interfaces) — 45
- [Implementaciones](#implementaciones) — 67
- [Builders](#builders) — 58
- [Contenedores de datos Bukkit](#contenedores-de-datos-bukkit) — 62
- [DTO](#dto) — 45
- [Records](#records) — 53
- [Enumeraciones](#enumeraciones) — 49
- [Tablas de switch](#tablas-de-switch) — 108
- [Registros](#registros) — 14
- [Singletons y accesores](#singletons-y-accesores) — 27
- [Utilidades por tipo dominante](#utilidades-por-tipo-dominante) — 313
- [Identificadas por su propio texto](#identificadas-por-su-propio-texto) — 103
- [Descifradores de cadenas](#descifradores-de-cadenas) — 37
- [Interfaces funcionales](#interfaces-funcionales) — 32
- [Excepciones](#excepciones) — 7
- [Tareas](#tareas) — 1
- [Sin ancla semántica](#sin-ancla-semantica) — 151

## Wrappers NMS

Una clase por versión de Minecraft y por interfaz base. Seleccionadas en tiempo de ejecución por la fábrica NMS.

| Clase | Antes | Qué hace |
|---|---|---|
| `BlockNms` | `aai` | Wrapper NMS de `BlockNms` para Minecraft . Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6` | `aak` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_10` | `ahv` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_11` | `air` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_12` | `aoe` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_13` | `aoz` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_14` | `aqb` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_15` | `aqr` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_16` | `arq` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_17` | `anc` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_18` | `asi` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_19` | `auj` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_2` | `abm` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_20` | `auy` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_21` | `avo` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_22` | `awh` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_23` | `axl` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_3` | `aco` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_4` | `add` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_5` | `adt` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_6` | `aej` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_7` | `afm` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_8` | `agd` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_20_6_9` | `ahf` | Wrapper NMS de `BlockNms` para Minecraft 1.20.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1` | `aam` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10` | `aao` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_10` | `ahx` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_11` | `ait` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_12` | `aog` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_13` | `apd` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_14` | `aqd` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_15` | `aqt` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_16` | `ars` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_17` | `ang` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_18` | `asq` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_19` | `aul` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_2` | `abq` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_20` | `ava` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_21` | `avq` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_22` | `awl` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_23` | `axn` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_24` | `akm` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_3` | `acq` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_4` | `adf` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_5` | `adv` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_6` | `aen` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_7` | `afo` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_8` | `agh` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_10_9` | `ahh` | Wrapper NMS de `BlockNms` para Minecraft 1.21.10. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11` | `aaq` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_10` | `ahy` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_11` | `aiu` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_12` | `aoh` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_13` | `apf` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_14` | `aqe` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_15` | `aqu` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_16` | `art` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_17` | `ani` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_18` | `asu` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_19` | `aum` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_2` | `abs` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_20` | `avb` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_21` | `avr` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_22` | `awn` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_23` | `axo` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_24` | `aks` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_3` | `acr` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_4` | `adg` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_5` | `adw` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_6` | `aep` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_7` | `afp` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_8` | `agj` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_11_9` | `ahi` | Wrapper NMS de `BlockNms` para Minecraft 1.21.11. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_10` | `ahw` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_11` | `ais` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_12` | `aof` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_13` | `apb` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_14` | `aqc` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_15` | `aqs` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_16` | `arr` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_17` | `ane` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_18` | `asm` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_19` | `auk` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_2` | `abo` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_20` | `auz` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_21` | `avp` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_22` | `awj` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_23` | `axm` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_24` | `akg` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_3` | `acp` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_4` | `ade` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_5` | `adu` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_6` | `ael` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_7` | `afn` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_8` | `agf` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_1_9` | `ahg` | Wrapper NMS de `BlockNms` para Minecraft 1.21.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3` | `aas` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_10` | `ahz` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_11` | `aiv` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_12` | `aoi` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_13` | `aph` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_14` | `aqf` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_15` | `aqv` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_16` | `aru` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_17` | `ank` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_18` | `asy` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_19` | `aun` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_2` | `abu` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_20` | `avc` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_21` | `avs` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_22` | `awp` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_23` | `axp` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_24` | `aky` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_3` | `acs` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_4` | `adh` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_5` | `adx` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_6` | `aer` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_7` | `afq` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_8` | `agl` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_3_9` | `ahj` | Wrapper NMS de `BlockNms` para Minecraft 1.21.3. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4` | `aau` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_10` | `aia` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_11` | `aiw` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_12` | `aoj` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_13` | `apj` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_14` | `aqg` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_15` | `aqw` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_16` | `arv` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_17` | `anm` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_18` | `atc` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_19` | `auo` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_2` | `abw` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_20` | `avd` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_21` | `avt` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_22` | `awr` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_23` | `axq` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_24` | `ale` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_3` | `act` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_4` | `adi` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_5` | `ady` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_6` | `aet` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_7` | `afr` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_8` | `agn` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_4_9` | `ahk` | Wrapper NMS de `BlockNms` para Minecraft 1.21.4. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5` | `aaw` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_10` | `aib` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_11` | `aix` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_12` | `aok` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_13` | `apl` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_14` | `aqh` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_15` | `aqx` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_16` | `arw` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_17` | `ano` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_18` | `atg` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_19` | `aup` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_2` | `aby` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_20` | `ave` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_21` | `avu` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_22` | `awt` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_23` | `axr` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_24` | `alk` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_3` | `acu` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_4` | `adj` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_5` | `adz` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_6` | `aev` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_7` | `afs` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_8` | `agp` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_5_9` | `ahl` | Wrapper NMS de `BlockNms` para Minecraft 1.21.5. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6` | `aay` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_10` | `aic` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_11` | `aiy` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_12` | `aol` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_13` | `apn` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_14` | `aqi` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_15` | `aqy` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_16` | `arx` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_17` | `anq` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_18` | `atk` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_19` | `auq` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_2` | `aca` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_20` | `avf` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_21` | `avv` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_22` | `awv` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_23` | `axs` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_24` | `alq` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_3` | `acv` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_4` | `adk` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_5` | `aea` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_6` | `aex` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_7` | `aft` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_8` | `agr` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_6_9` | `ahm` | Wrapper NMS de `BlockNms` para Minecraft 1.21.6. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7` | `aba` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_10` | `aid` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_11` | `aiz` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_12` | `aom` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_13` | `app` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_14` | `aqj` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_15` | `aqz` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_16` | `ary` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_17` | `ans` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_18` | `ato` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_19` | `aur` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_2` | `acc` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_20` | `avg` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_21` | `avw` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_22` | `awx` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_23` | `axt` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_24` | `alw` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_3` | `acw` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_4` | `adl` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_5` | `aeb` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_6` | `aez` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_7` | `afu` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_8` | `agt` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_7_9` | `ahn` | Wrapper NMS de `BlockNms` para Minecraft 1.21.7. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8` | `abc` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_10` | `aie` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_11` | `aja` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_12` | `aon` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_13` | `apr` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_14` | `aqk` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_15` | `ara` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_16` | `arz` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_17` | `anu` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_18` | `ats` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_19` | `aus` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_2` | `ace` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_20` | `avh` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_21` | `avx` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_22` | `awz` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_23` | `axu` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_24` | `amc` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_3` | `acx` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_4` | `adm` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_5` | `aec` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_6` | `afb` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_7` | `afv` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_8` | `agv` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_1_21_8_9` | `aho` | Wrapper NMS de `BlockNms` para Minecraft 1.21.8. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1` | `abe` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_10` | `aif` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_11` | `ajb` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_12` | `aoo` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_13` | `apt` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_14` | `aql` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_15` | `arb` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_16` | `asa` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_17` | `anw` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_18` | `atw` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_19` | `aut` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_2` | `acg` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_20` | `avi` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_21` | `avy` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_22` | `axb` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_23` | `axv` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_24` | `ami` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_3` | `acy` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_4` | `adn` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_5` | `aed` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_6` | `afd` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_7` | `afw` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_8` | `agx` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_1_9` | `ahp` | Wrapper NMS de `BlockNms` para Minecraft 26.1.1. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2` | `abg` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_10` | `aig` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_11` | `ajc` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_12` | `aop` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_13` | `apv` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_14` | `aqm` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_15` | `arc` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_16` | `asb` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_17` | `any` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_18` | `aua` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_19` | `auu` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_2` | `aci` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_20` | `avj` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_21` | `avz` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_22` | `axd` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_23` | `axw` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_24` | `amo` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_3` | `acz` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_4` | `ado` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_5` | `aee` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_6` | `aff` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_7` | `afx` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_8` | `agz` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_1_2_9` | `ahq` | Wrapper NMS de `BlockNms` para Minecraft 26.1.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2` | `abi` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_10` | `aih` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_11` | `ajd` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_12` | `aoq` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_13` | `apx` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_14` | `aqn` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_15` | `ard` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_16` | `asc` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_17` | `aoa` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_18` | `aue` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_19` | `auv` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_2` | `ack` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_20` | `avk` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_21` | `awa` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_22` | `axf` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_23` | `axx` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_24` | `amu` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_3` | `ada` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_4` | `adp` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_5` | `aef` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_6` | `afh` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_7` | `afy` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_8` | `ahb` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `BlockNms_26_2_9` | `ahr` | Wrapper NMS de `BlockNms` para Minecraft 26.2. Implementación concreta que la fábrica elige según la versión del servidor. |
| `NmsWrapperFactory` | `aab` | Wrapper NMS de `NmsWrapperFactory` para Minecraft . Implementación concreta que la fábrica elige según la versión del servidor. |
| `PlayerNms` | `asd` | Wrapper NMS de `PlayerNms` para Minecraft . Implementación concreta que la fábrica elige según la versión del servidor. |

## Listeners de Bukkit

Métodos anotados con `@EventHandler`: reaccionan a eventos del servidor.

| Clase | Antes | Qué hace |
|---|---|---|
| `BlockBreakListener` | `ma` | Escucha `BlockBreakEvent`, `ItemSpawnEvent`, `ProjectileHitEvent`. 7 métodos. |
| `BlockBreakListener_2` | `mf` | Escucha `BlockBreakEvent`, `StructureGrowEvent`. 4 métodos. |
| `BlockDestroyListener` | `ky` | Escucha eventos de Bukkit. 1 métodos. |
| `BlockDestroyListener_2` | `mi` | Escucha eventos de Bukkit. 2 métodos. |
| `BlockIgniteListener` | `mc` | Escucha `BlockIgniteEvent`, `BlockPhysicsEvent`, `BlockPlaceEvent`. 47 métodos. |
| `BlockPhysicsListener` | `mb` | Escucha `BlockPhysicsEvent`, `BlockSpreadEvent`, `BlockBurnEvent`. 6 métodos. |
| `BlockPhysicsListener_2` | `mg` | Escucha `BlockPhysicsEvent`, `NotePlayEvent`, `PlayerInteractEvent`. 26 métodos. |
| `BlockPistonExtendListener` | `ks` | Escucha `BlockPistonExtendEvent`, `EntityChangeBlockEvent`, `PlayerBucketFillEvent`. 13 métodos. |
| `BlockPlaceListener` | `kx` | Escucha `BlockPlaceEvent`, `BlockBreakEvent`, `BlockFromToEvent`. 7 métodos. |
| `BlockPlaceListener_2` | `lh` | Escucha `BlockPlaceEvent`, `BlockBreakEvent`, `PlayerInteractEvent`. 20 métodos. |
| `ChunkLoadListener` | `br` | Escucha `ChunkLoadEvent`, `ChunkUnloadEvent`, `PluginDisableEvent`. 54 métodos. |
| `CrafterCraftListener` | `vi` | Escucha `CrafterCraftEvent`. 1 métodos. |
| `CreatureSpawnListener` | `dd` | Escucha `CreatureSpawnEvent`, `WorldLoadEvent`, `WorldUnloadEvent`. 10 métodos. |
| `EnchantItemListener` | `lr` | Escucha `EnchantItemEvent`, `InventoryClickEvent`, `PrepareAnvilEvent`. 3 métodos. |
| `EntitiesLoadListener` | `ep` | Escucha `EntitiesLoadEvent`. 1 métodos. |
| `EntitiesLoadListener_2` | `kv` | Escucha `EntitiesLoadEvent`, `EntityDamageByEntityEvent`, `PlayerAnimationEvent`. 28 métodos. |
| `EntityDamageByEntityListener` | `pg` | Escucha `EntityDamageByEntityEvent`. 3 métodos. |
| `EntityDamageListenerBase` | `ana` | Clase base compartida por varias implementaciones. Escucha `EntityDamageEvent`, `PlayerChangedWorldEvent`, `PlayerTeleportEvent`. 21 métodos. |
| `EntityDeathListener` | `tx` | Escucha `EntityDeathEvent`, `BlockBreakEvent`, `PlayerFishEvent`. 9 métodos. |
| `EntityDismountListener` | `eo` | Escucha `EntityDismountEvent`, `EntityDamageByEntityEvent`, `EntityDamageEvent`. 38 métodos. |
| `EntityToggleGlideListener` | `pi` | Escucha `EntityToggleGlideEvent`, `PlayerInteractEvent`, `PlayerItemDamageEvent`. 18 métodos. |
| `FurnaceBurnListener` | `km` | Escucha `FurnaceBurnEvent`. 2 métodos. |
| `FurnaceStartSmeltListener` | `vg` | Escucha `FurnaceStartSmeltEvent`, `FurnaceSmeltEvent`. 14 métodos. |
| `GenericGameListener` | `lj` | Escucha `GenericGameEvent`, `EntityDamageEvent`, `PlayerAnimationEvent`. 23 métodos. |
| `InventoryClickListener` | `aj` | Escucha `InventoryClickEvent`, `InventoryCloseEvent`. 10 métodos. |
| `InventoryClickListener_2` | `biq` | Escucha `InventoryClickEvent`, `InventoryDragEvent`, `InventoryOpenEvent`. 6 métodos. |
| `InventoryClickListener_3` | `pc` | Escucha `InventoryClickEvent`, `PlayerSwapHandItemsEvent`, `PlayerQuitEvent`. 6 métodos. |
| `InventoryClickListener_4` | `vv` | Escucha `InventoryClickEvent`, `InventoryDragEvent`. 2 métodos. |
| `InventoryClickListener_5` | `vw` | Escucha `InventoryClickEvent`. 1 métodos. |
| `InventoryClickListener_6` | `vy` | Escucha `InventoryClickEvent`. 6 métodos. |
| `InventoryClickListener_7` | `zg` | Escucha `InventoryClickEvent`, `TradeSelectEvent`. 3 métodos. |
| `InventoryMoveItemListener` | `ku` | Escucha `InventoryMoveItemEvent`. 1 métodos. |
| `InventoryOpenListener` | `ph` | Escucha `InventoryOpenEvent`, `PlayerJoinEvent`, `PlayerChangedWorldEvent`. 11 métodos. |
| `PlayerCommandPreprocessListener` | `zh` | Escucha `PlayerCommandPreprocessEvent`. 3 métodos. |
| `PlayerDeathListener` | `kq` | Escucha `PlayerDeathEvent`, `PlayerRespawnEvent`. 3 métodos. |
| `PlayerElytraBoostListener` | `pt` | Escucha eventos de Bukkit. 1 métodos. |
| `PlayerInteractAtEntityListener` | `kn` | Escucha `PlayerInteractAtEntityEvent`, `PlayerInteractEvent`, `EntityDismountEvent`. 19 métodos. |
| `PlayerInteractAtEntityListener_2` | `kp` | Escucha `PlayerInteractAtEntityEvent`. 15 métodos. |
| `PlayerInteractAtEntityListener_3` | `kz` | Escucha `PlayerInteractAtEntityEvent`, `PlayerInteractEvent`, `InventoryCloseEvent`. 11 métodos. |
| `PlayerInteractListener` | `co` | Escucha `PlayerInteractEvent`, `PlayerInteractEntityEvent`, `EntityDamageByEntityEvent`. 39 métodos. |
| `PlayerInteractListener_2` | `kk` | Escucha `PlayerInteractEvent`, `PlayerQuitEvent`. 3 métodos. |
| `PlayerInteractListener_3` | `kt` | Escucha `PlayerInteractEvent`, `BlockBreakEvent`. 8 métodos. |
| `PlayerInteractListener_4` | `mh` | Escucha `PlayerInteractEvent`, `BlockPhysicsEvent`, `BlockPlaceEvent`. 11 métodos. |
| `PlayerInteractListener_5` | `na` | Escucha `PlayerInteractEvent`, `PlayerAnimationEvent`, `PlayerEditBookEvent`. 37 métodos. |
| `PlayerInteractListener_6` | `pe` | Escucha `PlayerInteractEvent`. 6 métodos. |
| `PlayerInteractListener_7` | `pu` | Escucha `PlayerInteractEvent`, `ProjectileHitEvent`, `ExplosionPrimeEvent`. 15 métodos. |
| `PlayerInteractListener_8` | `yu` | Escucha `PlayerInteractEvent`. 2 métodos. |
| `PlayerItemDamageListener` | `pp` | Escucha `PlayerItemDamageEvent`, `InventoryClickEvent`, `PlayerSwapHandItemsEvent`. 51 métodos. |
| `PlayerJoinListener` | `aad` | Escucha `PlayerJoinEvent`, `PlayerQuitEvent`, `PlayerItemHeldEvent`. 15 métodos. |
| `PlayerJoinListener_10` | `xe` | Escucha `PlayerJoinEvent`, `AsyncPlayerChatEvent`, `PlayerCommandPreprocessEvent`. 15 métodos. |
| `PlayerJoinListener_2` | `ap` | Escucha `PlayerJoinEvent`. 5 métodos. |
| `PlayerJoinListener_3` | `j` | Escucha `PlayerJoinEvent`, `PlayerQuitEvent`, `EntityMountEvent`. 13 métodos. |
| `PlayerJoinListener_4` | `jd` | Escucha `PlayerJoinEvent`, `PlayerQuitEvent`, `PlayerGameModeChangeEvent`. 25 métodos. |
| `PlayerJoinListener_5` | `lw` | Escucha `PlayerJoinEvent`, `PlayerQuitEvent`, `BlockDamageEvent`. 23 métodos. |
| `PlayerJoinListener_6` | `pq` | Escucha `PlayerJoinEvent`, `PlayerQuitEvent`, `PlayerRespawnEvent`. 17 métodos. |
| `PlayerJoinListener_7` | `r` | Escucha `PlayerJoinEvent`, `PlayerQuitEvent`, `BlockBreakEvent`. 30 métodos. |
| `PlayerJoinListener_8` | `va` | Escucha `PlayerJoinEvent`. 1 métodos. |
| `PlayerJoinListener_9` | `w` | Escucha `PlayerJoinEvent`, `PlayerQuitEvent`, `PlayerInteractEvent`. 33 métodos. |
| `PlayerMoveListener` | `fc` | Escucha `PlayerMoveEvent`, `PlayerTeleportEvent`, `PlayerRespawnEvent`. 54 métodos. |
| `PlayerPickupItemListener` | `zd` | Escucha `PlayerPickupItemEvent`, `ProjectileHitEvent`, `EntityShootBowEvent`. 4 métodos. |
| `PlayerQuitListener` | `aa` | Escucha `PlayerQuitEvent`, `WorldSaveEvent`, `PluginDisableEvent`. 12 métodos. |
| `PlayerQuitListener_2` | `bat` | Escucha `PlayerQuitEvent`. 1 métodos. |
| `PlayerQuitListener_3` | `ko` | Escucha `PlayerQuitEvent`, `ProjectileHitEvent`, `EntityShootBowEvent`. 10 métodos. |
| `PlayerQuitListener_4` | `uu` | Escucha `PlayerQuitEvent`. 5 métodos. |
| `PlayerQuitListener_5` | `yw` | Escucha `PlayerQuitEvent`. 3 métodos. |
| `PlayerQuitListenerBase` | `asf` | Clase base compartida por varias implementaciones. Escucha `PlayerQuitEvent`. 19 métodos. |
| `PlayerToggleSneakListener` | `ce` | Escucha `PlayerToggleSneakEvent`, `PlayerMoveEvent`, `PlayerJoinEvent`. 35 métodos. |
| `PluginDisableListener` | `la` | Escucha `PluginDisableEvent`, `PlayerInteractAtEntityEvent`, `EntityDismountEvent`. 26 métodos. |
| `PluginEnableListener` | `bha` | Escucha `PluginEnableEvent`. 21 métodos. |
| `PrepareAnvilListener` | `vc` | Escucha `PrepareAnvilEvent`, `InventoryClickEvent`. 18 métodos. |
| `PrepareAnvilListener_2` | `vu` | Escucha `PrepareAnvilEvent`. 1 métodos. |
| `PrepareGrindstoneListener` | `vz` | Escucha eventos de Bukkit. 1 métodos. |
| `PrepareGrindstoneListener_2` | `wa` | Escucha `PrepareGrindstoneEvent`. 1 métodos. |
| `PrepareItemCraftListener` | `vm` | Escucha `PrepareItemCraftEvent`, `InventoryClickEvent`, `InventoryMoveItemEvent`. 25 métodos. |
| `PrepareItemEnchantListener` | `lo` | Escucha `PrepareItemEnchantEvent`, `EnchantItemEvent`, `PrepareAnvilEvent`. 4 métodos. |
| `PrepareSmithingListener` | `we` | Escucha `PrepareSmithingEvent`. 16 métodos. |
| `ProjectileHitListener` | `pv` | Escucha `ProjectileHitEvent`. 7 métodos. |
| `ProjectileLaunchListener` | `pw` | Escucha `ProjectileLaunchEvent`, `ProjectileHitEvent`. 19 métodos. |
| `ServerCommandListener` | `baa` | Escucha `ServerCommandEvent`, `PlayerCommandPreprocessEvent`. 3 métodos. |
| `WorldLoadListener` | `tm` | Escucha `WorldLoadEvent`, `WorldUnloadEvent`, `ChunkPopulateEvent`. 3 métodos. |
| `WorldSaveListener` | `mk` | Escucha `WorldSaveEvent`, `WorldUnloadEvent`, `WorldLoadEvent`. 11 métodos. |

## Adaptadores de paquetes

Subclases de `PacketAdapter` (ProtocolLib): interceptan o modifican paquetes de red.

| Clase | Antes | Qué hace |
|---|---|---|
| `BlockChangedAckPacketListener` | `lx` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `DisguisedChatComponentListener` | `xf` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `DisguisedChatComponentListener_2` | `xi` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `EntityEquipmentPacketListener` | `eq` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `EntityMetadataPacketListener` | `aae` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `HowFuckListener` | `asj` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `HowFuckListener_2` | `asn` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `MountPacketListener` | `es` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `OnIAVehicleListener` | `lb` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 3 métodos, 0 campos. |
| `PacketListener` | `ak` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_10` | `anr` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_11` | `ant` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_12` | `anv` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_13` | `anx` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_14` | `anz` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_15` | `aob` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_16` | `ask` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_17` | `aso` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_18` | `asr` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_19` | `ass` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_2` | `al` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_20` | `asv` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_21` | `asw` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_22` | `asz` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_23` | `ata` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_24` | `atd` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_25` | `ate` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_26` | `ath` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_27` | `ati` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_28` | `atl` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_29` | `atm` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_3` | `and` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_30` | `atp` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_31` | `atq` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_32` | `att` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_33` | `atu` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_34` | `atx` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_35` | `aty` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_36` | `aub` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_37` | `auc` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_38` | `auf` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_39` | `aug` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_4` | `anf` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_40` | `cp` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_41` | `cq` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_42` | `cr` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_43` | `cs` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_44` | `ct` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_45` | `en` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_46` | `fd` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_47` | `je` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_48` | `k` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_49` | `lc` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_5` | `anh` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_50` | `lk` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_51` | `ll` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_52` | `px` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_53` | `py` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_54` | `pz` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 1 campos. |
| `PacketListener_55` | `ut` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_56` | `zf` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `PacketListener_57` | `zq` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_6` | `anj` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_7` | `anl` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_8` | `ann` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PacketListener_9` | `anp` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `PickItemPacketListener` | `md` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 3 métodos, 0 campos. |
| `PlayerChatComponentListener` | `xh` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `RespawnPacketListener` | `eu` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 0 campos. |
| `SteerVehiclePacketListener` | `et` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 2 métodos, 0 campos. |
| `SystemChatComponentListener` | `xg` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `SystemChatPacketListener` | `jf` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 1 métodos, 1 campos. |
| `UseEntityPacketListener` | `er` | Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. 7 métodos, 0 campos. |

## Comandos

Implementan `onCommand`: lógica de un subcomando del plugin.

| Clase | Antes | Qué hace |
|---|---|---|
| `CropsCommand` | `xo` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IablockCommand` | `xq` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IacleancacheCommand` | `xr` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 2 métodos. |
| `IacolorCommand` | `xs` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 2 métodos. |
| `IaconfigCommand` | `xt` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 16 métodos. |
| `IacustommodeldataCommand` | `xu` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IadebugCommand` | `xv` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 4 métodos. |
| `IadisguiseCommand` | `xw` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 4 métodos. |
| `IadropCommand` | `xx` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 3 métodos. |
| `IadurabilityCommand` | `xy` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IaemoteCommand` | `xz` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 2 métodos. |
| `IaentityCommand` | `ya` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 14 métodos. |
| `IagetCommand` | `yb` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IagiveCommand` | `yc` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IahitboxCommand` | `ye` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IahudCommand` | `yd` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IaimageCommand` | `yf` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IainfoCommand` | `yg` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IaitemCommand` | `yh` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 6 métodos. |
| `IaliquidCommand` | `yk` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IaplayerstatCommand` | `yn` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 2 métodos. |
| `IaplaysoundCommand` | `yl` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IaplaytotemanimationCommand` | `ym` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 2 métodos. |
| `IarecipeCommand` | `yo` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IareloadCommand` | `yp` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 5 métodos. |
| `IaremoveCommand` | `yq` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 2 métodos. |
| `IarenameCommand` | `yr` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 2 métodos. |
| `IarepairCommand` | `ys` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `Iasha1Command` | `yt` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 2 métodos. |
| `IatagCommand` | `yv` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IaundisguiseCommand` | `yx` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 1 métodos. |
| `IazipCommand` | `yy` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 14 métodos. |
| `PluginCommand` | `xp` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 2 métodos. |
| `PluginCommand_2` | `za` | Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. 8 métodos. |

## Contratos e interfaces

Interfaces que definen una API interna o un wrapper.

| Clase | Antes | Qué hace |
|---|---|---|
| `BlockWrapper` | `abl` | Contrato interno sobre `LocationBridgeBuilder_2`: 16 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `BlockWrapper_2` | `afk` | Contrato interno sobre `Location`: 7 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `BlockWrapper_3` | `ahe` | Contrato interno sobre `Material`: 8 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `BlockWrapper_4` | `qz` | Contrato interno sobre `Location`: 5 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `ChunkWrapper` | `axh` | Contrato interno sobre `World`: 12 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `EntityTypeWrapper` | `ake` | Contrato interno sobre `EntityTypeBridge`: 17 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `EntityWrapper` | `agb` | Contrato interno sobre `EntityBridge_5`: 42 métodos, 1 campos. Lo implementan las clases `*Impl` correspondientes. |
| `EntityWrapper_2` | `uf` | Contrato interno sobre `Block`: 2 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `EventWrapper` | `be` | Contrato interno sobre `LivingEntityBuilder`: 8 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `ItemStackWrapper` | `aii` | Contrato interno sobre `Player`: 22 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `LivingEntityWrapper` | `acm` | Contrato interno sobre `objetos internos`: 4 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `LivingEntityWrapper_2` | `zu` | Contrato interno sobre `objetos internos`: 2 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `LocationWrapper` | `arn` | Contrato interno sobre `NothingEnum`: 3 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `LocationWrapper_2` | `awc` | Contrato interno sobre `SetBlockDataFunction`: 3 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `LocationWrapper_3` | `bfd` | Contrato interno sobre `objetos internos`: 3 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `NamespacedKeyWrapper` | `uy` | Contrato interno sobre `NamespacedKeyItemStackHolder`: 7 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PacketEventWrapper` | `avl` | Contrato interno sobre `Player`: 2 métodos, 1 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PlayerWrapper` | `adc` | Contrato interno sobre `objetos internos`: 12 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PlayerWrapper_2` | `ahu` | Contrato interno sobre `GameMode`: 5 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PlayerWrapper_3` | `aoc` | Contrato interno sobre `objetos internos`: 3 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PlayerWrapper_4` | `aor` | Contrato interno sobre `RecordOfValue`: 51 métodos, 3 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PlayerWrapper_5` | `aqo` | Contrato interno sobre `ItemStack`: 16 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PlayerWrapper_6` | `jb` | Contrato interno sobre `PlayerBridge_8`: 2 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PlayerWrapper_7` | `jc` | Contrato interno sobre `PlayerBridge_8`: 2 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract` | `ai` | Contrato interno sobre `objetos internos`: 3 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_10` | `bji` | Contrato interno sobre `objetos internos`: 2 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_11` | `bjm` | Contrato interno sobre `PluginContract_14`: 23 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_12` | `bjy` | Contrato interno sobre `FluentBuilder_3`: 20 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_13` | `bkn` | Contrato interno sobre `objetos internos`: 0 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_14` | `bko` | Contrato interno sobre `PluginContract_11`: 9 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_15` | `bku` | Contrato interno sobre `objetos internos`: 3 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_16` | `blg` | Contrato interno sobre `Opaque105`: 3 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_17` | `kj` | Contrato interno sobre `objetos internos`: 0 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_18` | `lp` | Contrato interno sobre `objetos internos`: 0 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_19` | `mz` | Contrato interno sobre `objetos internos`: 0 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_2` | `bap` | Contrato interno sobre `objetos internos`: 3 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_20` | `qx` | Contrato interno sobre `objetos internos`: 8 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_21` | `tp` | Contrato interno sobre `objetos internos`: 5 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_3` | `baq` | Contrato interno sobre `objetos internos`: 3 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_4` | `bcg` | Contrato interno sobre `objetos internos`: 0 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_5` | `bdk` | Contrato interno sobre `objetos internos`: 3 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_6` | `bdl` | Contrato interno sobre `objetos internos`: 0 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_7` | `bdm` | Contrato interno sobre `objetos internos`: 0 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_8` | `bdo` | Contrato interno sobre `objetos internos`: 0 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |
| `PluginContract_9` | `bjc` | Contrato interno sobre `objetos internos`: 0 métodos, 0 campos. Lo implementan las clases `*Impl` correspondientes. |

## Implementaciones

Clases que implementan o extienden otra clase ya nombrada.

| Clase | Antes | Qué hace |
|---|---|---|
| `BufferedEnumImpl` | `bli` | Implementación de `BufferedEnum`. 20 métodos. |
| `BufferedEnumImpl_2` | `blj` | Implementación de `BufferedEnum`. 20 métodos. |
| `BuilderImpl` | `gg` | Implementación de `Builder_6`. 7 métodos. |
| `BuilderImpl_2` | `gj` | Implementación de `Builder_7`. 7 métodos. |
| `BuilderImpl_3` | `he` | Implementación de `Builder_8`. 5 métodos. |
| `BuilderImpl_4` | `hk` | Implementación de `Builder_9`. 5 métodos. |
| `BuilderImpl_5` | `hn` | Implementación de `Builder_10`. 5 métodos. |
| `BuilderImpl_6` | `hw` | Implementación de `Builder_11`. 5 métodos. |
| `BuilderImpl_7` | `hz` | Implementación de `Builder_12`. 5 métodos. |
| `BuilderImpl_8` | `ic` | Implementación de `Builder_13`. 5 métodos. |
| `ChunkStreamSomehowImpl` | `mn` | Implementación de `ChunkStreamSomehow`. 9 métodos. |
| `DoubleEnumImpl` | `bla` | Implementación de `DoubleEnum`. 1 métodos. |
| `DoubleEnumImpl_2` | `blb` | Implementación de `DoubleEnum`. 1 métodos. |
| `DoubleEnumImpl_3` | `blc` | Implementación de `DoubleEnum`. 1 métodos. |
| `DoubleEnumImpl_4` | `bld` | Implementación de `DoubleEnum`. 1 métodos. |
| `EntityBridgeBuilderImpl` | `at` | Implementación de `EntityBridgeBuilder`. 5 métodos. |
| `EntityBridgeImpl` | `as` | Implementación de `EntityBridge`. 0 métodos. |
| `EntityTypeBridgeBuilderImpl` | `hh` | Implementación de `EntityTypeBridgeBuilder_2`. 7 métodos. |
| `EntityTypeBridgeBuilderImpl_2` | `if` | Implementación de `EntityTypeBridgeBuilder_3`. 5 métodos. |
| `EntityTypeRefDataImpl` | `ge` | Implementación de `EntityTypeRefData`. 1 métodos. |
| `EntityTypeRefDataImpl_2` | `gh` | Implementación de `EntityTypeRefData`. 1 métodos. |
| `EventBridgeBuilderImpl` | `bd` | Implementación de `EventBridgeBuilder`. 7 métodos. |
| `EventBridgeBuilderImpl_2` | `bh` | Implementación de `EventBridgeBuilder_2`. 7 métodos. |
| `EventBridgeBuilderImpl_3` | `bk` | Implementación de `EventBridgeBuilder_3`. 7 métodos. |
| `HitboxImpl` | `ef` | Implementación de `Hitbox`. 1 métodos. |
| `IntBoolDataBuilderImpl` | `gl` | Implementación de `IntBoolDataBuilder`. 5 métodos. |
| `IntBoolDataBuilderImpl_10` | `hq` | Implementación de `IntBoolDataBuilderImpl_9`. 5 métodos. |
| `IntBoolDataBuilderImpl_11` | `hs` | Implementación de `IntBoolDataBuilder`. 5 métodos. |
| `IntBoolDataBuilderImpl_12` | `ht` | Implementación de `IntBoolDataBuilderImpl_11`. 5 métodos. |
| `IntBoolDataBuilderImpl_2` | `gm` | Implementación de `IntBoolDataBuilderImpl`. 5 métodos. |
| `IntBoolDataBuilderImpl_3` | `gq` | Implementación de `IntBoolDataBuilder`. 5 métodos. |
| `IntBoolDataBuilderImpl_4` | `gr` | Implementación de `IntBoolDataBuilderImpl_3`. 5 métodos. |
| `IntBoolDataBuilderImpl_5` | `gt` | Implementación de `IntBoolDataBuilder`. 6 métodos. |
| `IntBoolDataBuilderImpl_6` | `gu` | Implementación de `IntBoolDataBuilderImpl_5`. 5 métodos. |
| `IntBoolDataBuilderImpl_7` | `gw` | Implementación de `IntBoolDataBuilder`. 5 métodos. |
| `IntBoolDataBuilderImpl_8` | `gx` | Implementación de `IntBoolDataBuilderImpl_7`. 5 métodos. |
| `IntBoolDataBuilderImpl_9` | `hp` | Implementación de `IntBoolDataBuilder`. 6 métodos. |
| `IntBoolDataImpl` | `gk` | Implementación de `IntBoolData`. 1 métodos. |
| `IntBoolDataImpl_10` | `hu` | Implementación de `IntBoolData`. 1 métodos. |
| `IntBoolDataImpl_11` | `hx` | Implementación de `IntBoolData`. 1 métodos. |
| `IntBoolDataImpl_12` | `ia` | Implementación de `IntBoolData`. 1 métodos. |
| `IntBoolDataImpl_2` | `gp` | Implementación de `IntBoolData`. 1 métodos. |
| `IntBoolDataImpl_3` | `gs` | Implementación de `IntBoolData`. 1 métodos. |
| `IntBoolDataImpl_4` | `gv` | Implementación de `IntBoolData`. 1 métodos. |
| `IntBoolDataImpl_5` | `ha` | Implementación de `IntBoolData`. 1 métodos. |
| `IntBoolDataImpl_6` | `hi` | Implementación de `IntBoolData`. 1 métodos. |
| `IntBoolDataImpl_7` | `hl` | Implementación de `IntBoolData`. 1 métodos. |
| `IntBoolDataImpl_8` | `ho` | Implementación de `IntBoolData`. 1 métodos. |
| `IntBoolDataImpl_9` | `hr` | Implementación de `IntBoolData`. 1 métodos. |
| `ItemStackBridgeImpl` | `ub` | Implementación de `ItemStackBridge_33`. 1 métodos. |
| `LocationBridgeBuilderImpl` | `ui` | Implementación de `LocationBridgeBuilder_4`. 3 métodos. |
| `LocationBridgeImpl` | `ul` | Implementación de `LocationBridge_14`. 3 métodos. |
| `PacketTypeHelperImpl` | `arm` | Implementación de `PacketTypeHelper_2`. 2 métodos. |
| `ParentImpl` | `azq` | Implementación de `Parent_2`. 1 métodos. |
| `PlayerBridgeBuilderImpl` | `cc` | Implementación de `PlayerBridgeBuilder`. 5 métodos. |
| `PlayerBridgeImpl` | `ik` | Implementación de `PlayerBridge_8`. 12 métodos. |
| `PlayerBridgeImpl_2` | `im` | Implementación de `PlayerBridge_8`. 5 métodos. |
| `PlayerBridgeImpl_3` | `in` | Implementación de `PlayerBridge_8`. 5 métodos. |
| `PluginContractImpl` | `bix` | Implementación de `Object`. 38 métodos. |
| `PluginContractImpl_2` | `bja` | Implementación de `Object`. 9 métodos. |
| `PluginContractImpl_3` | `bjd` | Implementación de `Object`. 23 métodos. |
| `PluginContractImpl_4` | `bje` | Implementación de `Object`. 20 métodos. |
| `PluginContractImpl_5` | `bka` | Implementación de `Object`. 14 métodos. |
| `PluginContractImpl_6` | `bkk` | Implementación de `Opaque105`. 22 métodos. |
| `PluginContractImpl_7` | `qy` | Implementación de `Object`. 8 métodos. |
| `PluginContractImpl_8` | `to` | Implementación de `Object`. 2 métodos. |
| `VectorBridgeImpl` | `bbq` | Implementación de `VectorBridge_2`. 8 métodos. |

## Builders

Objetos con setters fluidos que devuelven `this` y construyen otro objeto.

| Clase | Antes | Qué hace |
|---|---|---|
| `BoundingBoxBuilder` | `ck` | Builder fluido de `Vector`: 2 setters que devuelven `this`, 6 campos. |
| `Builder` | `axy` | Builder fluido de `PluginContractBuilder_2`: 9 setters que devuelven `this`, 10 campos. |
| `Builder_10` | `hm` | Builder fluido de `IntBoolDataImpl_7`: 3 setters que devuelven `this`, 3 campos. |
| `Builder_11` | `hv` | Builder fluido de `IntBoolDataImpl_10`: 2 setters que devuelven `this`, 2 campos. |
| `Builder_12` | `hy` | Builder fluido de `IntBoolDataImpl_11`: 2 setters que devuelven `this`, 2 campos. |
| `Builder_13` | `ib` | Builder fluido de `IntBoolDataImpl_12`: 3 setters que devuelven `this`, 3 campos. |
| `Builder_14` | `ou` | Builder fluido de `Opaque124`: 3 setters que devuelven `this`, 5 campos. |
| `Builder_15` | `rt` | Builder fluido de `ReplaceEnum_2`: 2 setters que devuelven `this`, 2 campos. |
| `Builder_2` | `aya` | Builder fluido de `PluginContract_14`: 3 setters que devuelven `this`, 4 campos. |
| `Builder_3` | `ayc` | Builder fluido de `Builder_2`: 6 setters que devuelven `this`, 6 campos. |
| `Builder_4` | `ayd` | Builder fluido de `Builder_2`: 3 setters que devuelven `this`, 4 campos. |
| `Builder_5` | `fn` | Builder fluido de `RecordOfValueBuilder_2`: 3 setters que devuelven `this`, 3 campos. |
| `Builder_6` | `gf` | Builder fluido de `EntityTypeRefDataImpl`: 3 setters que devuelven `this`, 3 campos. |
| `Builder_7` | `gi` | Builder fluido de `EntityTypeRefDataImpl_2`: 3 setters que devuelven `this`, 3 campos. |
| `Builder_8` | `hd` | Builder fluido de `EntityTypeBridge`: 2 setters que devuelven `this`, 2 campos. |
| `Builder_9` | `hj` | Builder fluido de `IntBoolDataImpl_6`: 2 setters que devuelven `this`, 2 campos. |
| `EntityBridgeBuilder` | `ar` | Builder fluido de `Opaque124`: 5 setters que devuelven `this`, 5 campos. |
| `EntityBuilder` | `x` | Builder fluido de `Player`: 2 setters que devuelven `this`, 13 campos. |
| `EntityTypeBarStyleHolderBuilder` | `dq` | Builder fluido de `Hitbox`: 25 setters que devuelven `this`, 28 campos. |
| `EntityTypeBridgeBuilder` | `hc` | Builder fluido de `Predicate_2`: 2 setters que devuelven `this`, 2 campos. |
| `EntityTypeBridgeBuilder_2` | `hg` | Builder fluido de `EntityTypeBridge_2`: 4 setters que devuelven `this`, 4 campos. |
| `EntityTypeBridgeBuilder_3` | `ie` | Builder fluido de `EntityTypeBridge_3`: 3 setters que devuelven `this`, 3 campos. |
| `EntityTypeRefDataBuilder` | `gb` | Builder fluido de `Predicate_2`: 2 setters que devuelven `this`, 2 campos. |
| `EventBridgeBuilder` | `bc` | Builder fluido de `EntityBridgeImpl`: 4 setters que devuelven `this`, 4 campos. |
| `EventBridgeBuilder_2` | `bg` | Builder fluido de `StringClassBoolData`: 2 setters que devuelven `this`, 2 campos. |
| `EventBridgeBuilder_3` | `bj` | Builder fluido de `EventBridge_3`: 3 setters que devuelven `this`, 3 campos. |
| `FluentBuilder` | `bbz` | Builder fluido de `Opaque019`: 3 setters que devuelven `this`, 4 campos. |
| `FluentBuilder_2` | `beu` | Builder fluido de `objeto`: 2 setters que devuelven `this`, 0 campos. |
| `FluentBuilder_3` | `biy` | Builder fluido de `PluginContract_12`: 6 setters que devuelven `this`, 5 campos. |
| `FluentBuilder_4` | `bjp` | Builder fluido de `objeto`: 14 setters que devuelven `this`, 5 campos. |
| `FluentBuilder_5` | `bjq` | Builder fluido de `objeto`: 5 setters que devuelven `this`, 7 campos. |
| `FluentBuilder_6` | `ev` | Builder fluido de `objeto`: 7 setters que devuelven `this`, 7 campos. |
| `FluentBuilderBuilder` | `biw` | Builder fluido de `PluginContract_14`: 2 setters que devuelven `this`, 6 campos. |
| `FluentBuilderBuilder_2` | `biz` | Builder fluido de `PluginContract_14`: 3 setters que devuelven `this`, 13 campos. |
| `InstanceHolderBuilder` | `ben` | Builder fluido de `InstanceHolder_6`: 7 setters que devuelven `this`, 6 campos. |
| `IntBoolDataBuilder` | `fz` | Builder fluido de `objeto`: 2 setters que devuelven `this`, 2 campos. |
| `ItemStackBuilder` | `bir` | Builder fluido de `ItemStackBridge_4`: 6 setters que devuelven `this`, 4 campos. |
| `ItemStackBuilder_2` | `bis` | Builder fluido de `Material`: 21 setters que devuelven `this`, 1 campos. |
| `ItemStackBuilder_3` | `pa` | Builder fluido de `SuccessEnum_2`: 2 setters que devuelven `this`, 2 campos. |
| `ItemStackBuilder_4` | `qm` | Builder fluido de `PluginFileConfigurationHolder`: 6 setters que devuelven `this`, 58 campos. |
| `LivingEntityBuilder` | `dn` | Builder fluido de `EntityTypeBarStyleHolder`: 2 setters que devuelven `this`, 62 campos. |
| `LocationBridgeBuilder` | `bz` | Builder fluido de `ItemStackBuilder_4`: 22 setters que devuelven `this`, 30 campos. |
| `LocationBridgeBuilder_2` | `ql` | Builder fluido de `PluginFileConfigurationHolder`: 2 setters que devuelven `this`, 21 campos. |
| `LocationBridgeBuilder_3` | `sf` | Builder fluido de `PlayerBridge_21`: 7 setters que devuelven `this`, 7 campos. |
| `LocationBridgeBuilder_4` | `uh` | Builder fluido de `LocationBridge_14`: 7 setters que devuelven `this`, 12 campos. |
| `PlayerBridgeBuilder` | `cb` | Builder fluido de `PlayerBridge_21`: 5 setters que devuelven `this`, 5 campos. |
| `PlayerBuilder` | `bas` | Builder fluido de `objeto`: 2 setters que devuelven `this`, 3 campos. |
| `PluginContractBuilder` | `ayg` | Builder fluido de `PluginContract_14`: 4 setters que devuelven `this`, 3 campos. |
| `PluginContractBuilder_2` | `ayi` | Builder fluido de `PluginContract_14`: 4 setters que devuelven `this`, 3 campos. |
| `PluginContractBuilder_3` | `ayk` | Builder fluido de `PluginContract_14`: 3 setters que devuelven `this`, 3 campos. |
| `PluginContractBuilder_4` | `ayl` | Builder fluido de `PluginContract_14`: 3 setters que devuelven `this`, 4 campos. |
| `RecordOfStringBuilder` | `th` | Builder fluido de `RecordOfStringBuilder_2`: 6 setters que devuelven `this`, 8 campos. |
| `RecordOfStringBuilder_2` | `tj` | Builder fluido de `RecordOfString_10`: 9 setters que devuelven `this`, 11 campos. |
| `RecordOfValueBuilder` | `df` | Builder fluido de `EntityTypeBarStyleHolder`: 10 setters que devuelven `this`, 10 campos. |
| `RecordOfValueBuilder_2` | `fq` | Builder fluido de `RecordOfValue_19`: 3 setters que devuelven `this`, 8 campos. |
| `RecordOfValueBuilder_3` | `ri` | Builder fluido de `RecordOfValue_23`: 8 setters que devuelven `this`, 8 campos. |
| `ReplaceEnumBuilder` | `dl` | Builder fluido de `RecordOfValue_15`: 2 setters que devuelven `this`, 2 campos. |
| `VectorBuilder` | `bax` | Builder fluido de `Block`: 7 setters que devuelven `this`, 3 campos. |

## Contenedores de datos Bukkit

Agrupan dos o más tipos de Bukkit/NMS.

| Clase | Antes | Qué hace |
|---|---|---|
| `BarColorBarStyleHolder` | `rj` | Contenedor de datos: guarda `BarStyle`. |
| `BlockDataNoteBlockHolder` | `ls` | Contenedor de datos: guarda `Material`, `NoteBlock`. |
| `EntityArmorStandHolder` | `lf` | Contenedor de datos: guarda `ArmorStand`, `Location`, `Vector`. |
| `EntityInsentientWorldHolder` | `akj` | Contenedor de datos: guarda `Mob`, `IBlockData`, `World`. |
| `EntityInsentientWorldHolder_2` | `akp` | Contenedor de datos: guarda `Mob`, `IBlockData`, `World`. |
| `EntityInsentientWorldHolder_3` | `akv` | Contenedor de datos: guarda `Mob`, `IBlockData`, `World`. |
| `EntityInsentientWorldHolder_4` | `alb` | Contenedor de datos: guarda `Mob`, `IBlockData`, `World`. |
| `EntityInsentientWorldHolder_5` | `alh` | Contenedor de datos: guarda `Mob`, `IBlockData`, `World`. |
| `EntityInsentientWorldHolder_6` | `aln` | Contenedor de datos: guarda `Mob`, `IBlockData`, `World`. |
| `EntityInsentientWorldHolder_7` | `alt` | Contenedor de datos: guarda `Mob`, `IBlockData`, `World`. |
| `EntityInsentientWorldHolder_8` | `alz` | Contenedor de datos: guarda `Mob`, `IBlockData`, `World`. |
| `EntityInsentientWorldHolder_9` | `amf` | Contenedor de datos: guarda `Mob`, `IBlockData`, `World`. |
| `EntityTypeBarStyleHolder` | `dp` | Contenedor de datos: guarda `LivingEntity`, `BarStyle`, `BarColor`. |
| `HandlerListItemStackHolder` | `zi` | Contenedor de datos: guarda `LivingEntity`, `ItemStack`, `Entity`, `EquipmentSlot`. |
| `ItemDisplayLocationHolder` | `cj` | Contenedor de datos: guarda `Location`, `World`, `Chunk`. |
| `ItemDisplayTridentHolder` | `qb` | Contenedor de datos: guarda `Trident`, `LivingEntity`, `Player`. |
| `ItemStackPlayerHolder` | `zj` | Contenedor de datos: guarda `Player`, `HandlerList`. |
| `LivingEntityArmorStandHolder` | `ek` | Contenedor de datos: guarda `ArmorStand`, `Location`. |
| `LivingEntityLocationHolder` | `ds` | Contenedor de datos: guarda `Location`, `World`. |
| `LocationBoundingBoxHolder` | `cg` | Contenedor de datos: guarda `Player`, `Interaction`, `BoundingBox`. |
| `LocationEquipmentSlotHolder` | `adq` | Contenedor de datos: guarda `EquipmentSlot`, `ItemStack`, `Player`. |
| `MaterialBarColorHolder` | `ae` | Contenedor de datos: guarda `Plugin`, `BarColor`, `BarStyle`. |
| `MaterialBlockDataHolder` | `rz` | Contenedor de datos: guarda `BlockData`, `MultipleFacing`, `Block`. |
| `MobLevelHolder` | `aml` | Contenedor de datos: guarda `BlockState`, `Level`. |
| `MobLevelHolder_2` | `amr` | Contenedor de datos: guarda `BlockState`, `Level`. |
| `MobLevelHolder_3` | `amx` | Contenedor de datos: guarda `BlockState`, `Level`. |
| `NamespacedKeyEntityTypeHolder` | `jl` | Contenedor de datos: guarda `EntityType`, `Entity`, `ItemStack`, `Player`. |
| `NamespacedKeyItemDisplayHolder` | `js` | Contenedor de datos: guarda `EntityType`, `Entity`, `ItemStack`, `Transformation`. |
| `NamespacedKeyItemStackHolder` | `uw` | Contenedor de datos: guarda `ItemStack`, `Recipe`, `CraftingBookCategory`. |
| `NamespacedKeyPluginHolder` | `ty` | Contenedor de datos: guarda `Plugin`, `Block`, `Material`, `LivingEntity`. |
| `NamespacedKeyVectorHolder` | `kh` | Contenedor de datos: guarda `Vector`, `ItemStack`, `Entity`. |
| `PlayerBlockHolder` | `ci` | Contenedor de datos: guarda `Location`, `Block`, `Chunk`. |
| `PlayerBlockHolder_2` | `lg` | Contenedor de datos: guarda `Block`, `HandlerList`. |
| `PlayerBlockHolder_3` | `lu` | Contenedor de datos: guarda `Block`, `Vector`, `Location`. |
| `PlayerBossBarHolder` | `ld` | Contenedor de datos: guarda `BarColor`, `BarStyle`, `BossBar`. |
| `PlayerBukkitTaskHolder` | `cz` | Contenedor de datos: guarda `BukkitRunnable`, `BukkitTask`. |
| `PlayerEntityHolder` | `qd` | Contenedor de datos: guarda `Entity`, `HandlerList`. |
| `PlayerEntityHolder_2` | `qg` | Contenedor de datos: guarda `Entity`, `EquipmentSlot`, `HandlerList`. |
| `PlayerInventoryPlayerHolder` | `bbu` | Contenedor de datos: guarda `ItemStack`. |
| `PlayerItemStackHolder` | `ps` | Contenedor de datos: guarda `EquipmentSlot`, `ItemStack`. |
| `PlayerLivingEntityHolder` | `qf` | Contenedor de datos: guarda `LivingEntity`, `HandlerList`. |
| `PlayerLocationHolder` | `anb` | Contenedor de datos: guarda `Location`, `Entity`. |
| `PlayerLocationHolder_2` | `bfo` | Contenedor de datos: guarda `Location`, `FluidCollisionMode`, `RayTraceResult`. |
| `PluginBukkitTaskHolder` | `cm` | Contenedor de datos: guarda `Block`, `Player`, `BukkitTask`. |
| `PluginFileConfigurationHolder` | `bbf` | Contenedor de datos: guarda `PotionType`, `NamespacedKey`, `EquipmentSlot`. |
| `PluginFileConfigurationHolder_2` | `bcb` | Contenedor de datos: guarda `YamlConfiguration`, `FileConfiguration`. |
| `RandomSourceEntityCreatureHolder` | `akk` | Contenedor de datos: guarda `EntityCreature`. |
| `RandomSourceEntityCreatureHolder_2` | `akq` | Contenedor de datos: guarda `EntityCreature`. |
| `RandomSourceEntityCreatureHolder_3` | `akw` | Contenedor de datos: guarda `EntityCreature`. |
| `RandomSourceEntityCreatureHolder_4` | `alc` | Contenedor de datos: guarda `EntityCreature`. |
| `RandomSourceEntityCreatureHolder_5` | `ali` | Contenedor de datos: guarda `EntityCreature`. |
| `RandomSourceEntityCreatureHolder_6` | `alo` | Contenedor de datos: guarda `EntityCreature`. |
| `RandomSourceEntityCreatureHolder_7` | `alu` | Contenedor de datos: guarda `EntityCreature`. |
| `RandomSourceEntityCreatureHolder_8` | `ama` | Contenedor de datos: guarda `EntityCreature`. |
| `RandomSourceEntityCreatureHolder_9` | `amg` | Contenedor de datos: guarda `EntityCreature`. |
| `RandomSourcePathfinderMobHolder` | `amm` | Contenedor de datos: guarda `PathfinderMob`. |
| `RandomSourcePathfinderMobHolder_2` | `ams` | Contenedor de datos: guarda `PathfinderMob`. |
| `RandomSourcePathfinderMobHolder_3` | `amy` | Contenedor de datos: guarda `PathfinderMob`. |
| `RecipeChoiceItemStackHolder` | `vd` | Contenedor de datos: guarda `ItemStack`. |
| `RecipeChoiceItemStackHolder_2` | `vj` | Contenedor de datos: guarda `Material`, `ItemStack`. |
| `RecipeChoiceItemStackHolder_3` | `wb` | Contenedor de datos: guarda `ItemStack`. |
| `WorldBlockHolder` | `ln` | Contenedor de datos: guarda `Block`. |

## DTO

Sólo campos, sin lógica: transporte de datos entre capas.

| Clase | Antes | Qué hace |
|---|---|---|
| `BoolData` | `nd` | DTO de 1 campos (`Z`), sin lógica propia. |
| `BoolData_2` | `qi` | DTO de 2 campos (`Z`, `Z`), sin lógica propia. |
| `BoolData_3` | `wd` | DTO de 7 campos (`Z`, `Z`, `Z`), sin lógica propia. |
| `BoolDoubleData` | `qh` | DTO de 3 campos (`Z`, `Z`, `D`), sin lógica propia. |
| `BoolLongBlockData` | `lz` | DTO de 5 campos (`Z`, `Long`, `Block`), sin lógica propia. |
| `BoolStringData` | `db` | DTO de 3 campos (`Z`, `Z`, `String`), sin lógica propia. |
| `ClassRefData` | `my` | DTO de 2 campos (`Class`, `Executor`), sin lógica propia. |
| `ComponentBoolData` | `qq` | DTO de 2 campos (`Component`, `Z`), sin lógica propia. |
| `DoubleData` | `qo` | DTO de 5 campos (`Double`, `Double`, `Double`), sin lógica propia. |
| `EntityTypeRefData` | `ga` | DTO de 2 campos (`EntityType`, `Predicate_2`), sin lógica propia. |
| `FloatData` | `aip` | DTO de 1 campos (`F`), sin lógica propia. |
| `FloatData_2` | `sl` | DTO de 3 campos (`Float`, `Float`, `Float`), sin lógica propia. |
| `InstrumentByteStringData` | `aaj` | DTO de 6 campos (`Instrument`, `B`, `String`), sin lógica propia. |
| `IntBoolData` | `fy` | DTO de 2 campos (`I`, `Z`), sin lógica propia. |
| `IntBoolRefData` | `vl` | DTO de 3 campos (`I`, `Z`, `ItemStackBuilder_4`), sin lógica propia. |
| `IntData` | `avm` | DTO de 2 campos (`I`, `I`), sin lógica propia. |
| `IntData_2` | `bdw` | DTO de 2 campos (`I`, `I`), sin lógica propia. |
| `IntData_3` | `dv` | DTO de 2 campos (`I`, `I`), sin lógica propia. |
| `IntData_4` | `sc` | DTO de 1 campos (`I`), sin lógica propia. |
| `IntFloatRefData` | `iv` | DTO de 4 campos (`I`, `F`, `I`), sin lógica propia. |
| `IntListRefData` | `wr` | DTO de 3 campos (`I`, `List`, `StringClassBoolData`), sin lógica propia. |
| `IntLongData` | `bai` | DTO de 2 campos (`I`, `J`), sin lógica propia. |
| `InventoryIntItemStackData` | `am` | DTO de 4 campos (`Inventory`, `I`, `ItemStack`), sin lógica propia. |
| `ItemStackIntData` | `mm` | DTO de 3 campos (`ItemStack`, `ItemStack`, `I`), sin lógica propia. |
| `LinkedListData` | `pd` | DTO de 1 campos (`LinkedList`), sin lógica propia. |
| `ListFloatData` | `aij` | DTO de 2 campos (`List`, `F`), sin lógica propia. |
| `ListStringData` | `zz` | DTO de 7 campos (`List`, `String`, `String`), sin lógica propia. |
| `MapData` | `wq` | DTO de 1 campos (`Map`), sin lógica propia. |
| `RefBoolIntData` | `bw` | DTO de 3 campos (`BlockBridge_5`, `Z`, `I`), sin lógica propia. |
| `RefData` | `oy` | DTO de 1 campos (`VectorBridge_2`), sin lógica propia. |
| `RefData_2` | `yi` | DTO de 1 campos (`IaitemCommand`), sin lógica propia. |
| `RefIntegerData` | `ed` | DTO de 6 campos (`SoundCategoryBridge_2`, `VectorBridgeImpl`, `VectorBridgeImpl`), sin lógica propia. |
| `RefMapJSONObjectData` | `ayq` | DTO de 4 campos (`Minecraft`, `Map`, `JSONObject`), sin lógica propia. |
| `SetData` | `aio` | DTO de 1 campos (`Set`), sin lógica propia. |
| `StringBoolBooleanData` | `aei` | DTO de 3 campos (`String`, `Z`, `Boolean`), sin lógica propia. |
| `StringClassBoolData` | `wk` | DTO de 3 campos (`String`, `Class`, `Z`), sin lógica propia. |
| `StringData` | `ain` | DTO de 1 campos (`String`), sin lógica propia. |
| `StringData_2` | `jm` | DTO de 1 campos (`String`), sin lógica propia. |
| `StringData_3` | `jy` | DTO de 1 campos (`String`), sin lógica propia. |
| `StringData_4` | `ka` | DTO de 1 campos (`String`), sin lógica propia. |
| `StringData_5` | `kb` | DTO de 1 campos (`String`), sin lógica propia. |
| `StringData_6` | `kc` | DTO de 1 campos (`String`), sin lógica propia. |
| `StringData_7` | `ke` | DTO de 3 campos (`String`, `String`, `String`), sin lógica propia. |
| `StringIntegerBooleanData` | `re` | DTO de 5 campos (`String`, `Integer`, `Integer`), sin lógica propia. |
| `StringItemStackData` | `jz` | DTO de 2 campos (`String`, `ItemStack`), sin lógica propia. |

## Records

`java.lang.Record`: tuplas inmutables generadas por el compilador.

| Clase | Antes | Qué hace |
|---|---|---|
| `RecordOfChannelHandlerContext` | `bao` | `record` de 2 componentes (`ChannelHandlerContext`, `HttpHeaders`). |
| `RecordOfEntityType` | `gd` | `record` de 2 componentes (`EntityType`, `Predicate_2`). |
| `RecordOfFullHttpRequest` | `ban` | `record` de 2 componentes (`FullHttpRequest`, `URI`). |
| `RecordOfItemStack` | `by` | `record` de 5 componentes (`ItemStack`, `ItemStack`, `Float`). |
| `RecordOfList` | `bn` | `record` de 1 componentes (`List`). |
| `RecordOfList_2` | `ru` | `record` de 2 componentes (`List`, `F`). |
| `RecordOfNamespacedKey` | `rm` | `record` de 7 componentes (`NamespacedKey`, `String`, `String`). |
| `RecordOfNamespacedKey_2` | `ro` | `record` de 4 componentes (`NamespacedKey`, `String`, `String`). |
| `RecordOfObject` | `awf` | `record` de 2 componentes (). |
| `RecordOfPattern` | `wn` | `record` de 2 componentes (`Pattern`, `Function`). |
| `RecordOfPlayer` | `cf` | `record` de 10 componentes (`Player`, `LocationBoundingBoxHolder`, `PlayerBlockHolder`). |
| `RecordOfPotionEffectType` | `aik` | `record` de 6 componentes (`PotionEffectType`, `I`, `I`). |
| `RecordOfString` | `adr` | `record` de 3 componentes (`String`, `BufferedImage`, `Z`). |
| `RecordOfString_10` | `ti` | `record` de 11 componentes (`String`, `File`, `Float`). |
| `RecordOfString_2` | `afl` | `record` de 3 componentes (`String`, `String`, `I`). |
| `RecordOfString_3` | `bdi` | `record` de 3 componentes (`String`, `I`, `I`). |
| `RecordOfString_4` | `bo` | `record` de 2 componentes (`String`, `B`). |
| `RecordOfString_5` | `dr` | `record` de 3 componentes (`String`, `D`, `I`). |
| `RecordOfString_6` | `du` | `record` de 5 componentes (`String`, `SoundCategory`, `F`). |
| `RecordOfString_7` | `fb` | `record` de 5 componentes (`String`, `String`, `I`). |
| `RecordOfString_8` | `rw` | `record` de 3 componentes (`String`, `Z`, `Z`). |
| `RecordOfString_9` | `tg` | `record` de 8 componentes (`String`, `String`, `String`). |
| `RecordOfUUID` | `bt` | `record` de 3 componentes (`UUID`, `I`, `I`). |
| `RecordOfUUID_2` | `fg` | `record` de 13 componentes (`UUID`, `UUID`, `I`). |
| `RecordOfUUID_3` | `fi` | `record` de 5 componentes (`UUID`, `UUID`, `I`). |
| `RecordOfValue` | `aot` | `record` de 2 componentes (`I`, `UUID`). |
| `RecordOfValue_10` | `ch` | `record` de 4 componentes (`D`, `D`, `D`). |
| `RecordOfValue_11` | `cw` | `record` de 2 componentes (`D`, `String`). |
| `RecordOfValue_12` | `de` | `record` de 10 componentes (`EntityTypeBarStyleHolder`, `F`, `I`). |
| `RecordOfValue_13` | `dg` | `record` de 2 componentes (`Opaque110`, `Opaque110`). |
| `RecordOfValue_14` | `di` | `record` de 2 componentes (`I`, `I`). |
| `RecordOfValue_15` | `dj` | `record` de 2 componentes (`ReplaceEnum`, `List`). |
| `RecordOfValue_16` | `fe` | `record` de 3 componentes (`J`, `B`, `RecordOfValue_16`). |
| `RecordOfValue_17` | `fh` | `record` de 3 componentes (`RecordOfUUID_2`, `InstanceHolder_9`, `LocationBridge_12`). |
| `RecordOfValue_18` | `fp` | `record` de 3 componentes (`I`, `I`, `I`). |
| `RecordOfValue_19` | `fr` | `record` de 4 componentes (`S`, `I`, `B`). |
| `RecordOfValue_2` | `aou` | `record` de 7 componentes (`RecordOfValue`, `D`, `D`). |
| `RecordOfValue_20` | `jp` | `record` de 3 componentes (`LivingEntityBuilder`, `ItemStackBuilder_4`, `PlayerBridge_16`). |
| `RecordOfValue_21` | `p` | `record` de 2 componentes (`RegexEnum`, `String`). |
| `RecordOfValue_22` | `pj` | `record` de 4 componentes (`Z`, `Z`, `Z`). |
| `RecordOfValue_23` | `rh` | `record` de 8 componentes (`I`, `F`, `Z`). |
| `RecordOfValue_24` | `rn` | `record` de 3 componentes (`Z`, `Z`, `I`). |
| `RecordOfValue_25` | `rx` | `record` de 3 componentes (`I`, `I`, `F`). |
| `RecordOfValue_26` | `ta` | `record` de 3 componentes (`ItemStackBuilder_4`, `Z`, `Material`). |
| `RecordOfValue_3` | `aov` | `record` de 7 componentes (`Z`, `Z`, `Z`). |
| `RecordOfValue_4` | `av` | `record` de 1 componentes (`SuccessEnum`). |
| `RecordOfValue_5` | `bp` | `record` de 5 componentes (`I`, `I`, `I`). |
| `RecordOfValue_6` | `bq` | `record` de 5 componentes (`I`, `I`, `I`). |
| `RecordOfValue_7` | `bs` | `record` de 3 componentes (`RecordOfUUID`, `I`, `RecordOfList`). |
| `RecordOfValue_8` | `bu` | `record` de 3 componentes (`I`, `I`, `RecordOfList`). |
| `RecordOfValue_9` | `bv` | `record` de 5 componentes (`I`, `I`, `I`). |
| `RecordOfVector` | `cl` | `record` de 5 componentes (`Vector`, `Vector`, `D`). |
| `RecordOfVector2d` | `ads` | `record` de 2 componentes (`Vector2d`, `Vector2d`). |

## Enumeraciones

Constantes fijas usadas como claves o modos.

| Clase | Antes | Qué hace |
|---|---|---|
| `AirEnum` | `aah` | Enumeración de 8 constantes: `AIR`, `STRUCTURE_VOID`, `PORTAL`, `WOOL`. |
| `AllEnum` | `yz` | Enumeración de 3 constantes: `ALL`, `NONE`, `SELF`. |
| `AnyEnum` | `bdg` | Enumeración de 6 constantes: `ANY`, `UNKNOWN`, `DAY`, `NOON`. |
| `ArmorStandEnum` | `ju` | Enumeración de 3 constantes: `ARMOR_STAND`, `SMALL_ARMOR_STAND`, `ITEM_FRAME`. |
| `BlockBreakEnum` | `jj` | Enumeración de 8 constantes: `BLOCK_BREAK`, `ATTACK`, `KILL`, `INTERACT_ENTITY`. |
| `BlockEnum` | `rg` | Enumeración de 3 constantes: `BLOCK`, `ITEM`, `VANILLA`. |
| `BlocksEnum` | `mr` | Enumeración de 3 constantes: `BLOCKS`, `CROPS_SEEDS`, `BIOMES`. |
| `BreakEnum` | `cd` | Enumeración de 6 constantes: `BREAK`, `INTERACT`, `TRAMPLE`, `WATER`. |
| `BufferedEnum` | `blh` | Enumeración de 2 constantes: `BUFFERED`, `STREAMED`. |
| `CeilingEnum` | `jv` | Enumeración de 3 constantes: `CEILING`, `FLOOR`, `WALL`. |
| `ClearEnum` | `dm` | Enumeración de 4 constantes: `CLEAR`, `RAIN`, `THUNDER`, `SNOW`. |
| `CraftingEnum` | `ase` | Enumeración de 7 constantes: `CRAFTING`, `SMELTING`, `BLASTING`, `SMOKING`. |
| `DoubleEnum` | `bkz` | Enumeración de 8 constantes: `DOUBLE`, `FLOAT`, `INT64`, `UINT64`. |
| `EndEnum` | `uk` | Enumeración de 8 constantes: `End`, `Byte`, `Short`, `Int`. |
| `EntityAndBlockEnum` | `bfp` | Enumeración de 3 constantes: `ENTITY_AND_BLOCK`, `ENTITY`, `BLOCK`. |
| `EqualEnum` | `iw` | Enumeración de 5 constantes: `EQUAL`, `LESS`, `MORE`, `MORE_EQUAL`. |
| `HeadEnum` | `qt` | Enumeración de 6 constantes: `HEAD`, `CHEST`, `LEGS`, `FEET`. |
| `HiddenEnum` | `rl` | Enumeración de 5 constantes: `HIDDEN`, `VANILLA`, `TITLE`, `HUD`. |
| `HostileEnum` | `ni` | Enumeración de 3 constantes: `HOSTILE`, `PLAYERS`, `PASSIVE`. |
| `InstalledIsNewerEnum` | `bdd` | Enumeración de 4 constantes: `INSTALLED_IS_NEWER`, `INSTALLED_IS_LOWER`, `INSTALLED_IS_SAME`, `UNKNOWN`. |
| `IntEnum` | `ble` | Enumeración de 8 constantes: `INT`, `LONG`, `FLOAT`, `DOUBLE`. |
| `InteractEnum` | `ax` | Enumeración de 5 constantes: `INTERACT`, `ATTACK`, `ATTACKED`, `DAMAGED`. |
| `ItemEnum` | `wm` | Enumeración de 4 constantes: `ITEM`, `CUSTOM_ENTITY`, `BOTH`, `UNKNOWN`. |
| `LobfileEnum` | `ag` | Enumeración de 7 constantes: `LOBFILE`, `AUTO_EXTERNAL_LEGACY`, `EXTERNAL`, `SIMPLE_SELF_HOST`. |
| `MainHandEnum` | `yj` | Enumeración de 7 constantes: `MAIN_HAND`, `OFF_HAND`, `HEAD`, `CHEST`. |
| `MonsterEnum` | `agc` | Enumeración de 8 constantes: `MONSTER`, `CREATURE`, `AMBIENT`, `AXOLOTLS`. |
| `MsgEnum` | `lv` | Enumeración de 5 constantes: `MSG`, `CANCEL`, `CREATIVE_ALLOW`, `WRONG_BUT_DO_NOTHING`. |
| `NoneEnum` | `sb` | Enumeración de 5 constantes: `NONE`, `ALL`, `LOG`, `FURNACE`. |
| `NormalEnum` | `dz` | Enumeración de 7 constantes: `NORMAL`, `HEAD`, `HAT_PIVOT`, `LEFT_HAND_PIVOT`. |
| `NothingEnum` | `arp` | Enumeración de 3 constantes: `NOTHING`, `MATCHED_BLOCK`, `ANOTHER_BLOCK`. |
| `OtherEnum` | `dw` | Enumeración de 8 constantes: `OTHER`, `IDLE`, `IDLE_ANGRY`, `WALK`. |
| `PickingUpEnum` | `qc` | Enumeración de 3 constantes: `PICKING_UP`, `LOYAL_PICKING_UP`, `NONE`. |
| `PlacedEnum` | `li` | Enumeración de 4 constantes: `PLACED`, `NOT_PLACED`, `NOT_PLACED_INTERACTABLE`, `VANILLA_ITEM_NOT_PLACED`. |
| `PlayEnum` | `dc` | Enumeración de 3 constantes: `PLAY`, `UNKNOWN_EMOTE`, `CANCELLED`. |
| `PublicEnum` | `zy` | Enumeración de 4 constantes: `PUBLIC`, `PROTECTED`, `PRIVATE`, `PACKAGE_PRIVATE`. |
| `RealEnum` | `sd` | Enumeración de 7 constantes: `REAL`, `REAL_NOTE`, `REAL_TRANSPARENT`, `TILE`. |
| `RegexEnum` | `q` | Enumeración de 3 constantes: `REGEX`, `WILDCARD`, `EXACT`. |
| `RelativeEnum` | `oo` | Enumeración de 2 constantes: `RELATIVE`, `CLICKED`. |
| `ReplaceEnum` | `dk` | Enumeración de 2 constantes: `REPLACE`, `SPAWN_NEAR`. |
| `ReplaceEnum_2` | `rs` | Enumeración de 2 constantes: `REPLACE`, `MERGE`. |
| `RightEnum` | `io` | Enumeración de 2 constantes: `RIGHT`, `LEFT`. |
| `SavedEnum` | `mt` | Enumeración de 2 constantes: `SAVED`, `SAVED_CHUNK`. |
| `ServerJarEnum` | `zx` | Enumeración de 3 constantes: `SERVER_JAR`, `ANOTHER_JAR`, `NOT_FOUND`. |
| `SmoothEnum` | `dy` | Enumeración de 2 constantes: `SMOOTH`, `PRECISE`. |
| `StopIfLastSuccessEnum` | `ji` | Enumeración de 8 constantes: `STOP_IF_LAST_SUCCESS`, `STOP_IF_LAST_FAIL`, `SKIP_IF_LAST_SUCCESS`, `SKIP_IF_LAST_FAIL`. |
| `SuccessEnum` | `aw` | Enumeración de 2 constantes: `SUCCESS`, `FAILED`. |
| `SuccessEnum_2` | `pb` | Enumeración de 2 constantes: `SUCCESS`, `FAILED`. |
| `SurfaceEnum` | `wx` | Enumeración de 2 constantes: `SURFACE`, `CEILING`. |
| `WaitingEnum` | `bfn` | Enumeración de 3 constantes: `WAITING`, `RUNNING_NO_TASKS`, `RUNNING_GOT_TASKS`. |

## Tablas de switch

Arrays `int[]` sintéticos que mapean `Enum.ordinal()` a índices de `switch`.

| Clase | Antes | Qué hace |
|---|---|---|
| `ArmorTypeSwitchMap` | `jk` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `aseSwitchMap` | `asl` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `aseSwitchMap_10` | `atv` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `aseSwitchMap_11` | `atz` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `aseSwitchMap_12` | `aud` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `aseSwitchMap_13` | `auh` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `aseSwitchMap_2` | `asp` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `aseSwitchMap_3` | `ast` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `aseSwitchMap_4` | `asx` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `aseSwitchMap_5` | `atb` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `aseSwitchMap_6` | `atf` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `aseSwitchMap_7` | `atj` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `aseSwitchMap_8` | `atn` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `aseSwitchMap_9` | `atr` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `BlockFaceSwitchMap` | `bcd` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `BlockFaceSwitchMap_2` | `cv` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `BlockFaceSwitchMap_3` | `jo` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `BlockFaceSwitchMap_4` | `jt` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `BlockFaceSwitchMap_5` | `ob` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `BlockFaceSwitchMap_6` | `sn` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ClickEventSwitchMap` | `bbc` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EntityTypeSwitchMap` | `aga` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EntityTypeSwitchMap_2` | `tu` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EnumCreatureTypeSwitchMap` | `age` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EnumCreatureTypeSwitchMap_10` | `agw` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EnumCreatureTypeSwitchMap_2` | `agg` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EnumCreatureTypeSwitchMap_3` | `agi` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EnumCreatureTypeSwitchMap_4` | `agk` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EnumCreatureTypeSwitchMap_5` | `agm` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EnumCreatureTypeSwitchMap_6` | `ago` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EnumCreatureTypeSwitchMap_7` | `agq` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EnumCreatureTypeSwitchMap_8` | `ags` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EnumCreatureTypeSwitchMap_9` | `agu` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EnumWrappersSwitchMap` | `axj` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EnumWrappersSwitchMap_2` | `lm` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EnumWrappersSwitchMap_3` | `ly` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EquipmentSlotSwitchMap` | `aqq` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `EquipmentSlotSwitchMap_2` | `pr` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `GameModeSwitchMap` | `aht` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `HeightMapSwitchMap` | `aal` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `HeightMapSwitchMap_10` | `abd` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `HeightMapSwitchMap_11` | `abf` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `HeightMapSwitchMap_12` | `abh` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `HeightMapSwitchMap_13` | `abj` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `HeightMapSwitchMap_2` | `aan` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `HeightMapSwitchMap_3` | `aap` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `HeightMapSwitchMap_4` | `aar` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `HeightMapSwitchMap_5` | `aat` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `HeightMapSwitchMap_6` | `aav` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `HeightMapSwitchMap_7` | `aax` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `HeightMapSwitchMap_8` | `aaz` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `HeightMapSwitchMap_9` | `abb` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `iwSwitchMap` | `iu` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `iwSwitchMap_2` | `iy` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `jiSwitchMap` | `az` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `jjSwitchMap` | `mw` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `MaterialSwitchMap` | `aag` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `MaterialSwitchMap_2` | `azl` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `MaterialSwitchMap_3` | `azo` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `MaterialSwitchMap_4` | `bbt` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `MaterialSwitchMap_5` | `lt` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `MaterialSwitchMap_6` | `me` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `MaterialSwitchMap_7` | `ua` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `MaterialSwitchMap_8` | `vf` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `MaterialSwitchMap_9` | `vh` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `MobCategorySwitchMap` | `agy` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `MobCategorySwitchMap_2` | `aha` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `MobCategorySwitchMap_3` | `ahc` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `mtSwitchMap` | `ml` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `PacketPlayInBlockDigSwitchMap` | `apa` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `PacketPlayInBlockDigSwitchMap_10` | `aps` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `PacketPlayInBlockDigSwitchMap_2` | `apc` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `PacketPlayInBlockDigSwitchMap_3` | `ape` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `PacketPlayInBlockDigSwitchMap_4` | `apg` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `PacketPlayInBlockDigSwitchMap_5` | `api` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `PacketPlayInBlockDigSwitchMap_6` | `apk` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `PacketPlayInBlockDigSwitchMap_7` | `apm` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `PacketPlayInBlockDigSwitchMap_8` | `apo` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `PacketPlayInBlockDigSwitchMap_9` | `apq` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `PlayerFishEventSwitchMap` | `pn` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `qtSwitchMap` | `qk` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `rgSwitchMap` | `sa` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `rlSwitchMap` | `nb` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `rlSwitchMap_2` | `sw` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `sdSwitchMap` | `af` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `sdSwitchMap_2` | `azi` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `sdSwitchMap_3` | `qn` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `sdSwitchMap_4` | `su` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ServerboundPlayerActionPacketSwitchMap` | `apu` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ServerboundPlayerActionPacketSwitchMap_2` | `apw` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ServerboundPlayerActionPacketSwitchMap_3` | `apy` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `TextDecorationSwitchMap` | `bav` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `TextDecorationSwitchMap_2` | `bby` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap` | `abn` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap_10` | `acf` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap_11` | `ach` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap_12` | `acj` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap_13` | `acl` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap_14` | `un` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap_2` | `abp` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap_3` | `abr` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap_4` | `abt` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap_5` | `abv` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap_6` | `abx` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap_7` | `abz` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap_8` | `acb` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `ukSwitchMap_9` | `acd` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |
| `VersionSwitchMap` | `aac` | Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador. |

## Registros

Índices en memoria (Map/List) con acceso por clave.

| Clase | Antes | Qué hace |
|---|---|---|
| `BlockRegistry` | `aaf` | Registro en memoria: indexa objetos por clave. 15 métodos, 4 campos. |
| `InstanceRegistry` | `axz` | Registro en memoria: indexa objetos por clave. 13 métodos, 2 campos. |
| `InstanceRegistry_10` | `dx` | Registro en memoria: indexa objetos por clave. 23 métodos, 17 campos. |
| `InstanceRegistry_2` | `ayb` | Registro en memoria: indexa objetos por clave. 13 métodos, 2 campos. |
| `InstanceRegistry_3` | `aye` | Registro en memoria: indexa objetos por clave. 13 métodos, 2 campos. |
| `InstanceRegistry_4` | `ayf` | Registro en memoria: indexa objetos por clave. 13 métodos, 2 campos. |
| `InstanceRegistry_5` | `ayh` | Registro en memoria: indexa objetos por clave. 13 métodos, 2 campos. |
| `InstanceRegistry_6` | `ayj` | Registro en memoria: indexa objetos por clave. 13 métodos, 2 campos. |
| `InstanceRegistry_7` | `aym` | Registro en memoria: indexa objetos por clave. 13 métodos, 2 campos. |
| `InstanceRegistry_8` | `ayn` | Registro en memoria: indexa objetos por clave. 13 métodos, 2 campos. |
| `InstanceRegistry_9` | `azg` | Registro en memoria: indexa objetos por clave. 30 métodos, 16 campos. |
| `ItemStackRegistry` | `d` | Registro en memoria: indexa objetos por clave. 121 métodos, 113 campos. |
| `LivingEntityRegistry` | `da` | Registro en memoria: indexa objetos por clave. 115 métodos, 39 campos. |
| `PacketListenerRegistry` | `aow` | Registro en memoria: indexa objetos por clave. 26 métodos, 4 campos. |

## Singletons y accesores

Mantienen una instancia propia y la exponen.

| Clase | Antes | Qué hace |
|---|---|---|
| `BiomeHolder` | `afj` | Accesor de instancia única: guarda y expone su propio estado. 5 métodos. |
| `BlockHolder` | `abk` | Accesor de instancia única: guarda y expone su propio estado. 10 métodos. |
| `BlockHolder_2` | `ahd` | Accesor de instancia única: guarda y expone su propio estado. 3 métodos. |
| `BukkitTaskHolder` | `h` | Accesor de instancia única: guarda y expone su propio estado. 17 métodos. |
| `EntityHolder` | `afz` | Accesor de instancia única: guarda y expone su propio estado. 17 métodos. |
| `EntityHolder_2` | `auxx` | Accesor de instancia única: guarda y expone su propio estado. 2 métodos. |
| `EnumWrappersHolder` | `axi` | Accesor de instancia única: guarda y expone su propio estado. 6 métodos. |
| `InstanceHolder` | `akf` | Accesor de instancia única: guarda y expone su propio estado. 2 métodos. |
| `InstanceHolder_2` | `aqa` | Accesor de instancia única: guarda y expone su propio estado. 2 métodos. |
| `InstanceHolder_3` | `avn` | Accesor de instancia única: guarda y expone su propio estado. 1 métodos. |
| `InstanceHolder_4` | `awg` | Accesor de instancia única: guarda y expone su propio estado. 3 métodos. |
| `InstanceHolder_5` | `bed` | Accesor de instancia única: guarda y expone su propio estado. 0 métodos. |
| `InstanceHolder_6` | `bem` | Accesor de instancia única: guarda y expone su propio estado. 6 métodos. |
| `InstanceHolder_7` | `bfk` | Accesor de instancia única: guarda y expone su propio estado. 0 métodos. |
| `InstanceHolder_8` | `ew` | Accesor de instancia única: guarda y expone su propio estado. 2 métodos. |
| `InstanceHolder_9` | `ft` | Accesor de instancia única: guarda y expone su propio estado. 7 métodos. |
| `LocationHolder` | `aro` | Accesor de instancia única: guarda y expone su propio estado. 6 métodos. |
| `LocationHolder_2` | `ej` | Accesor de instancia única: guarda y expone su propio estado. 32 métodos. |
| `LocationHolder_3` | `rf` | Accesor de instancia única: guarda y expone su propio estado. 11 métodos. |
| `PacketAdapterHolder` | `us` | Accesor de instancia única: guarda y expone su propio estado. 5 métodos. |
| `PacketContainerHolder` | `adb` | Accesor de instancia única: guarda y expone su propio estado. 10 métodos. |
| `PlayerHolder` | `ahs` | Accesor de instancia única: guarda y expone su propio estado. 8 métodos. |
| `PlayerHolder_2` | `aiq` | Accesor de instancia única: guarda y expone su propio estado. 5 métodos. |
| `PlayerHolder_3` | `aod` | Accesor de instancia única: guarda y expone su propio estado. 2 métodos. |
| `PlayerHolder_4` | `aqp` | Accesor de instancia única: guarda y expone su propio estado. 19 métodos. |
| `PlayerHolder_5` | `asg` | Accesor de instancia única: guarda y expone su propio estado. 14 métodos. |
| `PlayerHolder_6` | `em` | Accesor de instancia única: guarda y expone su propio estado. 5 métodos. |

## Utilidades por tipo dominante

Sin interfaz de librería: se nombran por el tipo que más usan.

| Clase | Antes | Qué hace |
|---|---|---|
| `BaseComponentHelper` | `bau` | Utilidades sobre `objetos internos`: 19 métodos (19 estáticos). Sin interfaz de librería que la identifique. |
| `BaseComponentHelper_2` | `bbb` | Utilidades sobre `objetos internos`: 21 métodos (21 estáticos). Sin interfaz de librería que la identifique. |
| `BlockBridge` | `baw` | Utilidades sobre `BoundingBox`: 5 métodos (5 estáticos). Sin interfaz de librería que la identifique. |
| `BlockBridge_10` | `ny` | Utilidades sobre `ItemStackBuilder_4`: 8 métodos (2 estáticos). Sin interfaz de librería que la identifique. |
| `BlockBridge_11` | `ow` | Utilidades sobre `MaterialBridge_5`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `BlockBridge_12` | `qw` | Utilidades sobre `PluginFileConfigurationHolder`: 7 métodos (2 estáticos). Sin interfaz de librería que la identifique. |
| `BlockBridge_13` | `ra` | Utilidades sobre `PluginFileConfigurationHolder`: 7 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `BlockBridge_2` | `bay` | Utilidades sobre `Location`: 16 métodos (16 estáticos). Sin interfaz de librería que la identifique. |
| `BlockBridge_3` | `bez` | Utilidades sobre `Player`: 0 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `BlockBridge_4` | `bfa` | Utilidades sobre `BlockState`: 0 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `BlockBridge_5` | `bm` | Utilidades sobre `RecordOfString_4`: 16 métodos (5 estáticos). Sin interfaz de librería que la identifique. |
| `BlockBridge_6` | `jr` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `BlockBridge_7` | `kd` | Utilidades sobre `ItemStackBuilder_4`: 3 métodos (2 estáticos). Sin interfaz de librería que la identifique. |
| `BlockBridge_8` | `mp` | Utilidades sobre `Builder_3`: 74 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `BlockBridge_9` | `ms` | Utilidades sobre `Builder_3`: 102 métodos (8 estáticos). Sin interfaz de librería que la identifique. |
| `BlockDataBridge` | `ig` | Utilidades sobre `BlockState`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `BlockPositionHelper` | `arh` | Utilidades sobre `World`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `BlockStateBridge` | `gn` | Utilidades sobre `objetos internos`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `BlockStateBridge_2` | `go` | Utilidades sobre `objetos internos`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `BossBarBridge` | `baf` | Utilidades sobre `ad`: 4 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `BossBarBridge_2` | `bbr` | Utilidades sobre `objetos internos`: 17 métodos (17 estáticos). Sin interfaz de librería que la identifique. |
| `BukkitRunnableBridge` | `e` | Utilidades sobre `ItemStackRegistry`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `BukkitTaskBridge` | `bcp` | Utilidades sobre `BukkitScheduler`: 27 métodos (27 estáticos). Sin interfaz de librería que la identifique. |
| `BukkitTaskBridge_2` | `bet` | Utilidades sobre `BukkitRunnable`: 10 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ChunkBridge` | `axk` | Utilidades sobre `objetos internos`: 1 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `ChunkBridge_2` | `mq` | Utilidades sobre `PluginContractBuilder`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ChunkBridge_3` | `xa` | Utilidades sobre `WorldBridge_8`: 11 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `ColorBridge` | `bcy` | Utilidades sobre `Player`: 69 métodos (69 estáticos). Sin interfaz de librería que la identifique. |
| `ColorBridge_2` | `rd` | Utilidades sobre `PluginFileConfigurationHolder`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandListenerWrapperBridge` | `aek` | Utilidades sobre `IChatBaseComponent`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandListenerWrapperBridge_10` | `afc` | Utilidades sobre `IChatBaseComponent`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandListenerWrapperBridge_2` | `aem` | Utilidades sobre `IChatBaseComponent`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandListenerWrapperBridge_3` | `aeo` | Utilidades sobre `IChatBaseComponent`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandListenerWrapperBridge_4` | `aeq` | Utilidades sobre `IChatBaseComponent`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandListenerWrapperBridge_5` | `aes` | Utilidades sobre `IChatBaseComponent`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandListenerWrapperBridge_6` | `aeu` | Utilidades sobre `IChatBaseComponent`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandListenerWrapperBridge_7` | `aew` | Utilidades sobre `IChatBaseComponent`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandListenerWrapperBridge_8` | `aey` | Utilidades sobre `IChatBaseComponent`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandListenerWrapperBridge_9` | `afa` | Utilidades sobre `IChatBaseComponent`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandSenderBridge` | `azu` | Utilidades sobre `av`: 31 métodos (8 estáticos). Sin interfaz de librería que la identifique. |
| `CommandSenderBridge_2` | `azv` | Utilidades sobre `av`: 15 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandSenderBridge_3` | `azw` | Utilidades sobre `av`: 6 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandSenderBridge_4` | `azx` | Utilidades sobre `av`: 8 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandSenderBridge_5` | `bce` | Utilidades sobre `Consumer_2`: 24 métodos (24 estáticos). Sin interfaz de librería que la identifique. |
| `CommandSenderBridge_6` | `zb` | Utilidades sobre `objetos internos`: 6 métodos (5 estáticos). Sin interfaz de librería que la identifique. |
| `CommandSenderBridge_7` | `zc` | Utilidades sobre `objetos internos`: 4 métodos (2 estáticos). Sin interfaz de librería que la identifique. |
| `CommandSourceStackBridge` | `afe` | Utilidades sobre `Component`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandSourceStackBridge_2` | `afg` | Utilidades sobre `Component`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `CommandSourceStackBridge_3` | `afi` | Utilidades sobre `Component`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ConfigurationSectionBridge` | `bbg` | Utilidades sobre `PluginFileConfigurationHolder`: 98 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `ConfigurationSectionBridge_2` | `mv` | Utilidades sobre `ItemStackBuilder_4`: 12 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `ConfigurationSectionBridge_3` | `sp` | Utilidades sobre `ItemStackBuilder_4`: 9 métodos (9 estáticos). Sin interfaz de librería que la identifique. |
| `ConfigurationSectionBridge_4` | `sv` | Utilidades sobre `ItemStackRegistry`: 17 métodos (12 estáticos). Sin interfaz de librería que la identifique. |
| `ConfigurationSectionBridge_5` | `td` | Utilidades sobre `ItemStackRegistry`: 3 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `EffectBridge` | `oa` | Utilidades sobre `ItemStackBuilder_4`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityBridge` | `aq` | Utilidades sobre `EntityBridgeBuilder`: 7 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityBridge_2` | `bfb` | Utilidades sobre `DamageCause`: 0 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityBridge_3` | `le` | Utilidades sobre `objetos internos`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityBridge_4` | `uj` | Utilidades sobre `EndEnum`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityBridge_5` | `um` | Utilidades sobre `EndEnum`: 6 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityCreatureBridge` | `aki` | Utilidades sobre `BlockNms_1_21_1_24`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityCreatureBridge_2` | `ako` | Utilidades sobre `BlockNms_1_21_10_24`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityCreatureBridge_3` | `aku` | Utilidades sobre `BlockNms_1_21_11_24`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityCreatureBridge_4` | `ala` | Utilidades sobre `BlockNms_1_21_3_24`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityCreatureBridge_5` | `alg` | Utilidades sobre `BlockNms_1_21_4_24`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityCreatureBridge_6` | `alm` | Utilidades sobre `BlockNms_1_21_5_24`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityCreatureBridge_7` | `als` | Utilidades sobre `BlockNms_1_21_6_24`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityCreatureBridge_8` | `aly` | Utilidades sobre `BlockNms_1_21_7_24`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityCreatureBridge_9` | `ame` | Utilidades sobre `BlockNms_1_21_8_24`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge` | `akh` | Utilidades sobre `BlockNms_1_21_1_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_10` | `alj` | Utilidades sobre `BlockNms_1_21_4_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_11` | `all` | Utilidades sobre `BlockNms_1_21_5_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_12` | `alp` | Utilidades sobre `BlockNms_1_21_5_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_13` | `alr` | Utilidades sobre `BlockNms_1_21_6_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_14` | `alv` | Utilidades sobre `BlockNms_1_21_6_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_15` | `alx` | Utilidades sobre `BlockNms_1_21_7_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_16` | `amb` | Utilidades sobre `BlockNms_1_21_7_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_17` | `amd` | Utilidades sobre `BlockNms_1_21_8_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_18` | `amh` | Utilidades sobre `BlockNms_1_21_8_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_2` | `akl` | Utilidades sobre `BlockNms_1_21_1_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_3` | `akn` | Utilidades sobre `BlockNms_1_21_10_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_4` | `akr` | Utilidades sobre `BlockNms_1_21_10_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_5` | `akt` | Utilidades sobre `BlockNms_1_21_11_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_6` | `akx` | Utilidades sobre `BlockNms_1_21_11_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_7` | `akz` | Utilidades sobre `BlockNms_1_21_3_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_8` | `ald` | Utilidades sobre `BlockNms_1_21_3_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityInsentientBridge_9` | `alf` | Utilidades sobre `BlockNms_1_21_4_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityTypeBridge` | `hb` | Utilidades sobre `Predicate_2`: 2 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `EntityTypeBridge_2` | `hf` | Utilidades sobre `EntityTypeBridgeBuilder_2`: 1 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `EntityTypeBridge_3` | `id` | Utilidades sobre `EntityTypeBridgeBuilder_3`: 3 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `EntityTypeBridge_4` | `jq` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityTypeBridge_5` | `tt` | Utilidades sobre `PluginFileConfigurationHolder`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EntityTypeBridge_6` | `up` | Utilidades sobre `objetos internos`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EnumWrappersHelper` | `ari` | Utilidades sobre `World`: 8 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EventBridge` | `ba` | Utilidades sobre `LivingEntityBuilder`: 10 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `EventBridge_10` | `nx` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EventBridge_11` | `om` | Utilidades sobre `StringClassBoolData`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EventBridge_12` | `oq` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EventBridge_2` | `bf` | Utilidades sobre `LivingEntityBuilder`: 3 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `EventBridge_3` | `bi` | Utilidades sobre `EventBridgeBuilder_3`: 4 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `EventBridge_4` | `ng` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EventBridge_5` | `nj` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EventBridge_6` | `nk` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EventBridge_7` | `nl` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EventBridge_8` | `ns` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `EventBridge_9` | `nw` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `FeatureBridge` | `axc` | Utilidades sobre `FeaturePlaceContext`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `FeatureBridge_2` | `axe` | Utilidades sobre `FeaturePlaceContext`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `FeatureBridge_3` | `axg` | Utilidades sobre `FeaturePlaceContext`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `HandlerListBridge` | `bin` | Utilidades sobre `objetos internos`: 4 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `HandlerListBridge_2` | `fu` | Utilidades sobre `objetos internos`: 2 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `HumanEntityBridge` | `bfc` | Utilidades sobre `ItemStack`: 0 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemBridge` | `ue` | Utilidades sobre `Player`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemsAdderLoadDataEventHelper` | `t` | Utilidades sobre `g`: 12 métodos (8 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge` | `baz` | Utilidades sobre `Generation`: 5 métodos (5 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_10` | `ne` | Utilidades sobre `ItemStackBuilder_4`: 3 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_11` | `nf` | Utilidades sobre `ItemStackBuilder_4`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_12` | `nh` | Utilidades sobre `ItemStackBuilder_4`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_13` | `nm` | Utilidades sobre `ItemStackBuilder_4`: 4 métodos (2 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_14` | `nn` | Utilidades sobre `ItemStackBuilder_4`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_15` | `no` | Utilidades sobre `ItemStackBuilder_4`: 6 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_16` | `np` | Utilidades sobre `ItemStackBuilder_4`: 8 métodos (2 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_17` | `nr` | Utilidades sobre `ItemStackBuilder_4`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_18` | `nt` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_19` | `nv` | Utilidades sobre `ItemStackBuilder_4`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_2` | `bbs` | Utilidades sobre `ItemStackBuilder_4`: 96 métodos (96 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_20` | `nz` | Utilidades sobre `NamespacedKeyItemDisplayHolder`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_21` | `og` | Utilidades sobre `ItemStackBuilder_4`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_22` | `oi` | Utilidades sobre `BlockBridge_11`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_23` | `oj` | Utilidades sobre `NamespacedKeyItemDisplayHolder`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_24` | `ok` | Utilidades sobre `RefData`: 3 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_25` | `ol` | Utilidades sobre `ItemStackBuilder_4`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_26` | `on` | Utilidades sobre `LocationBridgeBuilder_2`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_27` | `or` | Utilidades sobre `ItemStackBuilder_4`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_28` | `os` | Utilidades sobre `ItemStackBuilder_4`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_29` | `pf` | Utilidades sobre `ItemStackRegistry`: 5 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_3` | `bbv` | Utilidades sobre `Material`: 8 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_30` | `po` | Utilidades sobre `ItemStackRegistry`: 7 métodos (5 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_31` | `qv` | Utilidades sobre `objetos internos`: 10 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_32` | `ry` | Utilidades sobre `ItemStackBuilder_4`: 13 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_33` | `tz` | Utilidades sobre `Material`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_34` | `vb` | Utilidades sobre `PluginFileConfigurationHolder`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_35` | `vk` | Utilidades sobre `PluginFileConfigurationHolder`: 19 métodos (2 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_36` | `vo` | Utilidades sobre `objetos internos`: 0 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_37` | `vp` | Utilidades sobre `objetos internos`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_38` | `vq` | Utilidades sobre `ItemStackBuilder_4`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_39` | `vr` | Utilidades sobre `objetos internos`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_4` | `bio` | Utilidades sobre `InventoryType`: 40 métodos (10 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_40` | `vx` | Utilidades sobre `Plugin`: 3 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_41` | `wc` | Utilidades sobre `PluginFileConfigurationHolder`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_42` | `zo` | Utilidades sobre `ItemStackRegistry`: 3 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_5` | `bit` | Utilidades sobre `ItemStackBridge_4`: 32 métodos (7 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_6` | `kf` | Utilidades sobre `ItemStackBuilder_4`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_7` | `kg` | Utilidades sobre `ItemStackBuilder_4`: 10 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_8` | `l` | Utilidades sobre `objetos internos`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ItemStackBridge_9` | `m` | Utilidades sobre `objetos internos`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ListenerBridge` | `bev` | Utilidades sobre `DFunction`: 14 métodos (14 estáticos). Sin interfaz de librería que la identifique. |
| `ListenerBridge_2` | `bex` | Utilidades sobre `DFunction`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `LivingEntityBridge` | `acn` | Utilidades sobre `LivingEntityWrapper`: 1 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `LivingEntityBridge_2` | `amj` | Utilidades sobre `BlockNms_26_1_1_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `LivingEntityBridge_3` | `amp` | Utilidades sobre `BlockNms_26_1_2_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `LivingEntityBridge_4` | `amv` | Utilidades sobre `BlockNms_26_2_24`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `LivingEntityBridge_5` | `ay` | Utilidades sobre `EntityTypeBarStyleHolder`: 10 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `LivingEntityBridge_6` | `bbh` | Utilidades sobre `EntityType`: 9 métodos (9 estáticos). Sin interfaz de librería que la identifique. |
| `LivingEntityBridge_7` | `gy` | Utilidades sobre `Loader`: 27 métodos (25 estáticos). Sin interfaz de librería que la identifique. |
| `LivingEntityBridge_8` | `zt` | Utilidades sobre `objetos internos`: 1 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge` | `bbk` | Utilidades sobre `FluentBuilder_6`: 20 métodos (19 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge_10` | `eg` | Utilidades sobre `objetos internos`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge_11` | `ei` | Utilidades sobre `Opaque111`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge_12` | `fj` | Utilidades sobre `ENTITYBlockViewer`: 3 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge_13` | `se` | Utilidades sobre `LocationBridgeBuilder_2`: 8 métodos (5 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge_14` | `ug` | Utilidades sobre `ItemStackBridge_32`: 25 métodos (6 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge_2` | `bcc` | Utilidades sobre `VectorBridge_3`: 42 métodos (42 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge_3` | `bcv` | Utilidades sobre `SoundCategory`: 6 métodos (6 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge_4` | `bdf` | Utilidades sobre `ItemStack`: 23 métodos (22 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge_5` | `bfe` | Utilidades sobre `objetos internos`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge_6` | `bff` | Utilidades sobre `objetos internos`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge_7` | `bx` | Utilidades sobre `BreakEnum`: 21 métodos (9 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge_8` | `eb` | Utilidades sobre `objetos internos`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `LocationBridge_9` | `ee` | Utilidades sobre `InstanceRegistry_10`: 5 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `MainHelper` | `bcx` | Utilidades sobre `Plugin`: 6 métodos (6 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge` | `azh` | Utilidades sobre `RealEnum`: 15 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_10` | `rc` | Utilidades sobre `RecordOfNamespacedKey`: 18 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_11` | `rp` | Utilidades sobre `objetos internos`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_12` | `rq` | Utilidades sobre `objetos internos`: 6 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_13` | `si` | Utilidades sobre `ConfigurationSectionBridge`: 5 métodos (5 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_14` | `sm` | Utilidades sobre `LocationBridgeBuilder_2`: 6 métodos (6 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_15` | `sz` | Utilidades sobre `ConfigurationSectionBridge`: 4 métodos (4 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_16` | `tv` | Utilidades sobre `PluginFileConfigurationHolder`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_17` | `uo` | Utilidades sobre `objetos internos`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_18` | `ve` | Utilidades sobre `PluginFileConfigurationHolder`: 9 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_19` | `vs` | Utilidades sobre `ItemStack`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_2` | `azn` | Utilidades sobre `PluginContract_20`: 13 métodos (7 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_20` | `wt` | Utilidades sobre `LocationBridgeBuilder_2`: 8 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_3` | `fa` | Utilidades sobre `RecordOfValue`: 20 métodos (8 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_4` | `n` | Utilidades sobre `ItemStack`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_5` | `ox` | Utilidades sobre `BlockBridge_13`: 3 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_6` | `qj` | Utilidades sobre `ItemStackBuilder_4`: 8 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_7` | `qr` | Utilidades sobre `ItemStackBuilder_4`: 3 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_8` | `qs` | Utilidades sobre `ItemStackBuilder_4`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `MaterialBridge_9` | `rb` | Utilidades sobre `PluginFileConfigurationHolder`: 7 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `MinecraftKeyHelper` | `arf` | Utilidades sobre `Player`: 6 métodos (6 estáticos). Sin interfaz de librería que la identifique. |
| `NamespacedKeyBridge` | `bcj` | Utilidades sobre `PersistentDataHolder`: 10 métodos (10 estáticos). Sin interfaz de librería que la identifique. |
| `NamespacedKeyBridge_2` | `iz` | Utilidades sobre `PlayerBridge_8`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `NamespacedKeyBridge_3` | `ss` | Utilidades sobre `ConfigurationSectionBridge`: 11 métodos (11 estáticos). Sin interfaz de librería que la identifique. |
| `NFileHelper` | `ab` | Utilidades sobre `objetos internos`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PacketAdapterHelper` | `zp` | Utilidades sobre `PlayerBridge_32`: 3 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PacketContainerHelper` | `are` | Utilidades sobre `Player`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PacketContainerHelper_2` | `aui` | Utilidades sobre `VectorBridge`: 5 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `PacketContainerHelper_3` | `xn` | Utilidades sobre `Permissible`: 4 métodos (4 estáticos). Sin interfaz de librería que la identifique. |
| `PacketEventHelper` | `ark` | Utilidades sobre `World`: 9 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PacketTypeHelper` | `arj` | Utilidades sobre `World`: 6 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PacketTypeHelper_2` | `arl` | Utilidades sobre `ItemStack`: 6 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `ParticleBridge` | `oc` | Utilidades sobre `ItemStackBuilder_4`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PathfinderMobBridge` | `amk` | Utilidades sobre `BlockNms_26_1_1_24`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PathfinderMobBridge_2` | `amq` | Utilidades sobre `BlockNms_26_1_2_24`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PathfinderMobBridge_3` | `amw` | Utilidades sobre `BlockNms_26_2_24`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PermissibleBridge` | `fw` | Utilidades sobre `PluginFileConfigurationHolder`: 32 métodos (9 estáticos). Sin interfaz de librería que la identifique. |
| `PermissibleBridge_2` | `xk` | Utilidades sobre `Opaque020`: 13 métodos (13 estáticos). Sin interfaz de librería que la identifique. |
| `PermissibleBridge_3` | `xl` | Utilidades sobre `Opaque020`: 6 métodos (6 estáticos). Sin interfaz de librería que la identifique. |
| `PermissibleBridge_4` | `xm` | Utilidades sobre `Opaque020`: 11 métodos (11 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge` | `ac` | Utilidades sobre `av`: 13 métodos (7 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_10` | `ir` | Utilidades sobre `PlayerBridge_8`: 3 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_11` | `is` | Utilidades sobre `PlayerBridge_8`: 3 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_12` | `it` | Utilidades sobre `EqualEnum`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_13` | `ix` | Utilidades sobre `PotionEffectTypeBridge`: 3 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_14` | `ja` | Utilidades sobre `PlayerBridge_8`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_15` | `jg` | Utilidades sobre `WorldBridge_4`: 10 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_16` | `jn` | Utilidades sobre `ItemStackBuilder_4`: 19 métodos (15 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_17` | `jw` | Utilidades sobre `ItemStackBuilder_4`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_18` | `lq` | Utilidades sobre `objetos internos`: 3 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_19` | `mx` | Utilidades sobre `ItemStackBuilder_4`: 6 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_2` | `bad` | Utilidades sobre `av`: 7 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_20` | `nu` | Utilidades sobre `MaterialBridge_5`: 4 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_21` | `o` | Utilidades sobre `objetos internos`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_22` | `oe` | Utilidades sobre `ItemStackBuilder_4`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_23` | `op` | Utilidades sobre `ItemStackBuilder_4`: 4 métodos (2 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_24` | `qe` | Utilidades sobre `HandlerList`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_25` | `rk` | Utilidades sobre `ItemStackBuilder_4`: 13 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_26` | `xj` | Utilidades sobre `PermissibleBridge`: 8 métodos (4 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_27` | `y` | Utilidades sobre `ItemStackRegistry`: 9 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_28` | `z` | Utilidades sobre `ItemStackRegistry`: 6 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_29` | `zk` | Utilidades sobre `ItemStackRegistry`: 23 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_3` | `bae` | Utilidades sobre `ad`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_30` | `zl` | Utilidades sobre `PlayerBridge_29`: 24 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_31` | `zn` | Utilidades sobre `ItemStackBridge_42`: 22 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_32` | `zr` | Utilidades sobre `objetos internos`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_33` | `zv` | Utilidades sobre `objetos internos`: 3 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_4` | `bcw` | Utilidades sobre `objetos internos`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_5` | `bl` | Utilidades sobre `ItemDisplay`: 3 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_6` | `ca` | Utilidades sobre `PlayerBridgeBuilder`: 4 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_7` | `do` | Utilidades sobre `LivingEntityBuilder`: 9 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_8` | `ij` | Utilidades sobre `PlayerBridge_15`: 15 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerBridge_9` | `ip` | Utilidades sobre `PlayerBridge_8`: 3 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PlayerFishEventBridge` | `pm` | Utilidades sobre `ItemStackRegistry`: 2 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge` | `azy` | Utilidades sobre `av`: 0 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_10` | `fv` | Utilidades sobre `ItemStackRegistry`: 20 métodos (2 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_11` | `ih` | Utilidades sobre `ItemStackRegistry`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_12` | `kl` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_13` | `kr` | Utilidades sobre `ItemStackRegistry`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_14` | `kw` | Utilidades sobre `ItemStackRegistry`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_15` | `wi` | Utilidades sobre `Opaque145`: 30 métodos (12 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_2` | `azz` | Utilidades sobre `av`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_3` | `bab` | Utilidades sobre `av`: 6 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_4` | `bac` | Utilidades sobre `av`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_5` | `bar` | Utilidades sobre `objetos internos`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_6` | `bbe` | Utilidades sobre `objetos internos`: 27 métodos (27 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_7` | `bbw` | Utilidades sobre `PluginFileConfigurationHolder`: 8 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_8` | `bfr` | Utilidades sobre `objetos internos`: 14 métodos (5 estáticos). Sin interfaz de librería que la identifique. |
| `PluginBridge_9` | `bip` | Utilidades sobre `Player`: 4 métodos (4 estáticos). Sin interfaz de librería que la identifique. |
| `PotionEffectTypeBridge` | `of` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `PotionEffectTypeBridge_2` | `oh` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `RecipeBridge` | `ux` | Utilidades sobre `NamespacedKeyItemStackHolder`: 58 métodos (36 estáticos). Sin interfaz de librería que la identifique. |
| `SoundBridge` | `bcu` | Utilidades sobre `Player`: 3 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `SoundBridge_2` | `sg` | Utilidades sobre `Player`: 8 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `SoundCategoryBridge` | `bbi` | Utilidades sobre `ItemFlag`: 19 métodos (19 estáticos). Sin interfaz de librería que la identifique. |
| `SoundCategoryBridge_2` | `dt` | Utilidades sobre `LivingEntityBuilder`: 21 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `SoundCategoryBridge_3` | `od` | Utilidades sobre `ItemStackBuilder_4`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `TridentBridge` | `qa` | Utilidades sobre `ProjectileLaunchListener`: 2 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `VectorBridge` | `bcz` | Utilidades sobre `objetos internos`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `VectorBridge_2` | `bda` | Utilidades sobre `objetos internos`: 4 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `VectorBridge_3` | `bdb` | Utilidades sobre `objetos internos`: 5 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `VectorBridge_4` | `bfq` | Utilidades sobre `objetos internos`: 13 métodos (13 estáticos). Sin interfaz de librería que la identifique. |
| `VersionHelper` | `aaa` | Utilidades sobre `objetos internos`: 7 métodos (7 estáticos). Sin interfaz de librería que la identifique. |
| `VersionHelper_2` | `an` | Utilidades sobre `Material`: 31 métodos (6 estáticos). Sin interfaz de librería que la identifique. |
| `VersionHelper_3` | `zw` | Utilidades sobre `ServerJarEnum`: 27 métodos (27 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge` | `bde` | Utilidades sobre `objetos internos`: 7 métodos (1 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge_10` | `wy` | Utilidades sobre `LocationBridgeBuilder_2`: 4 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge_11` | `wz` | Utilidades sobre `LocationBridgeBuilder_2`: 8 métodos (5 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge_12` | `xb` | Utilidades sobre `WorldBridge_9`: 7 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge_13` | `xc` | Utilidades sobre `WorldBridge_10`: 11 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge_14` | `xd` | Utilidades sobre `WorldBridge_11`: 10 métodos (2 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge_2` | `fm` | Utilidades sobre `WorldSaveListener`: 31 métodos (14 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge_3` | `fo` | Utilidades sobre `RecordOfValueBuilder_2`: 3 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge_4` | `ii` | Utilidades sobre `PlayerBridge_15`: 19 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge_5` | `mj` | Utilidades sobre `BlockBridge_9`: 18 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge_6` | `tl` | Utilidades sobre `WorldBridge_7`: 13 métodos (13 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge_7` | `wu` | Utilidades sobre `MaterialBridge_20`: 7 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge_8` | `wv` | Utilidades sobre `LocationBridgeBuilder_2`: 6 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `WorldBridge_9` | `ww` | Utilidades sobre `LocationBridgeBuilder_2`: 4 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `WorldGeneratorBridge` | `awi` | Utilidades sobre `FeaturePlaceContext`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WorldGeneratorBridge_10` | `axa` | Utilidades sobre `FeaturePlaceContext`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WorldGeneratorBridge_2` | `awk` | Utilidades sobre `FeaturePlaceContext`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WorldGeneratorBridge_3` | `awm` | Utilidades sobre `FeaturePlaceContext`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WorldGeneratorBridge_4` | `awo` | Utilidades sobre `FeaturePlaceContext`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WorldGeneratorBridge_5` | `awq` | Utilidades sobre `FeaturePlaceContext`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WorldGeneratorBridge_6` | `aws` | Utilidades sobre `FeaturePlaceContext`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WorldGeneratorBridge_7` | `awu` | Utilidades sobre `FeaturePlaceContext`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WorldGeneratorBridge_8` | `aww` | Utilidades sobre `FeaturePlaceContext`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WorldGeneratorBridge_9` | `awy` | Utilidades sobre `FeaturePlaceContext`: 1 métodos (0 estáticos). Sin interfaz de librería que la identifique. |
| `WrappedBlockDataHelper` | `arg` | Utilidades sobre `Vector`: 6 métodos (3 estáticos). Sin interfaz de librería que la identifique. |
| `YamlConfigurationBridge` | `bdh` | Utilidades sobre `RecordOfString_3`: 7 métodos (7 estáticos). Sin interfaz de librería que la identifique. |
| `YamlConfigurationBridge_2` | `bdj` | Utilidades sobre `ConfigurationSectionBridge`: 2 métodos (2 estáticos). Sin interfaz de librería que la identifique. |

## Identificadas por su propio texto

Nombradas a partir de un mensaje o clave de configuración propio; el texto no se publica, sólo el nombre derivado.

| Clase | Antes | Qué hace |
|---|---|---|
| `AppendEquipmentLegacy` | `tn` | Identificada por un mensaje o clave de configuración propio. 5 métodos, 2 campos; usa `PluginContractImpl_8`, `ConfigurationSectionBridge`, `Error_3`, `PluginFileConfigurationHolder`. |
| `ArmorsRendering` | `s` | Identificada por un mensaje o clave de configuración propio. 1 métodos, 0 campos; usa `PluginFileConfigurationHolder`, `ConfigurationSection`, `ColorBridge`, `CommandSenderBridge_5`. |
| `Assets` | `b` | Identificada por un mensaje o clave de configuración propio. 11 métodos, 0 campos; usa `Main`, `Plugin`, `ColorBridge`. |
| `AvgPacketsSent` | `aoy` | Identificada por un mensaje o clave de configuración propio. 5 métodos, 3 campos; usa `Bukkit`, `Main`, `BukkitScheduler`. |
| `Behaviours` | `mu` | Identificada por un mensaje o clave de configuración propio. 15 métodos, 2 campos; usa `ItemStackBuilder_4`, `ConfigurationSectionBridge`, `ItemStackRegistry`, `CommandSenderBridge_5`. |
| `BufferCapacityEnough` | `bkf` | Identificada por un mensaje o clave de configuración propio. 43 métodos, 2 campos; usa `Opaque105`, `Opaque103`, `Opaque102`. |
| `BufferLocked` | `bdv` | Identificada por un mensaje o clave de configuración propio. 3 métodos, 2 campos; usa `Opaque034`, `Opaque031`, `Opaque030`. |
| `BufferPreviouslyUsed` | `bkc` | Identificada por un mensaje o clave de configuración propio. 20 métodos, 1 campos; usa `FluentBuilderBuilder`, `Opaque097`, `FluentBuilderBuilder_2`. |
| `BufferPreviouslyUsed_2` | `bkh` | Identificada por un mensaje o clave de configuración propio. 20 métodos, 1 campos; usa `FluentBuilderBuilder`, `Opaque099`, `FluentBuilderBuilder_2`. |
| `ChunkStreamSomehow` | `bds` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 13 campos; usa `Opaque030`, `Opaque031`, `IntData_2`. |
| `CodedInputEncounteredEmbedded` | `bkb` | Identificada por un mensaje o clave de configuración propio. 10 métodos, 2 campos; usa `IOError`. |
| `ComponentsNbtFile` | `tb` | Identificada por un mensaje o clave de configuración propio. 4 métodos, 0 campos; usa `ConfigurationSectionBridge`, `ItemStackBuilder_4`, `PluginFileConfigurationHolder`, `CommandSenderBridge_5`. |
| `Consumable` | `sj` | Identificada por un mensaje o clave de configuración propio. 5 métodos, 1 campos; usa `ConfigurationSectionBridge`, `PluginFileConfigurationHolder`, `CommandSenderBridge_5`, `RecordOfPotionEffectType`. |
| `Count` | `ajf` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 5 campos; usa `DataConverterSchemaNamed`. |
| `Count_10` | `ajx` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 5 campos; usa `DataConverterSchemaNamed`. |
| `Count_11` | `ajz` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 5 campos; usa `NamespacedSchema`. |
| `Count_12` | `akb` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 5 campos; usa `NamespacedSchema`. |
| `Count_13` | `akd` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 5 campos; usa `NamespacedSchema`. |
| `Count_2` | `ajh` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 5 campos; usa `DataConverterSchemaNamed`. |
| `Count_3` | `ajj` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 5 campos; usa `DataConverterSchemaNamed`. |
| `Count_4` | `ajl` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 5 campos; usa `DataConverterSchemaNamed`. |
| `Count_5` | `ajn` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 5 campos; usa `DataConverterSchemaNamed`. |
| `Count_6` | `ajp` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 5 campos; usa `DataConverterSchemaNamed`. |
| `Count_7` | `ajr` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 5 campos; usa `DataConverterSchemaNamed`. |
| `Count_8` | `ajt` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 5 campos; usa `DataConverterSchemaNamed`. |
| `Count_9` | `ajv` | Identificada por un mensaje o clave de configuración propio. 17 métodos, 5 campos; usa `DataConverterSchemaNamed`. |
| `Crops` | `sk` | Identificada por un mensaje o clave de configuración propio. 8 métodos, 4 campos; usa `ItemStackRegistry`, `PluginFileConfigurationHolder`, `ConfigurationSectionBridge`. |
| `CustomItemNull` | `ayz` | Identificada por un mensaje o clave de configuración propio. 4 métodos, 1 campos; usa `MaterialBridge_10`, `ItemStackBridge_2`, `Model`. |
| `Dictionary` | `c` | Identificada por un mensaje o clave de configuración propio. 2 métodos, 0 campos; usa `PluginFileConfigurationHolder`, `CommandSenderBridge_5`, `ConfigurationSection`, `Opaque109`. |
| `Durability` | `so` | Identificada por un mensaje o clave de configuración propio. 2 métodos, 0 campos; usa `ConfigurationSectionBridge`, `ItemStackBuilder_4`, `Material`, `ItemStackBridge_2`. |
| `Enabled` | `ts` | Identificada por un mensaje o clave de configuración propio. 4 métodos, 2 campos; usa `ResourceGraphics`, `PluginFileConfigurationHolder`, `ConfigurationSectionBridge`. |
| `ENTITYBlockViewer` | `fl` | Identificada por un mensaje o clave de configuración propio. 26 métodos, 24 campos; usa tipos internos. |
| `Equipments` | `g` | Identificada por un mensaje o clave de configuración propio. 3 métodos, 1 campos; usa `PluginFileConfigurationHolder`, `ConfigurationSection`, `CommandSenderBridge_5`, `NamespacedKey`. |
| `ExpectedMaxSizeNegative` | `bjk` | Identificada por un mensaje o clave de configuración propio. 6 métodos, 6 campos; usa `Opaque103`, `BufferedEnum`. |
| `FindYMLConfigurations` | `a` | Identificada por un mensaje o clave de configuración propio. 7 métodos, 1 campos; usa `PluginFileConfigurationHolder`, `CommandSenderBridge_5`, `r`. |
| `FishingRodHave` | `ayx` | Identificada por un mensaje o clave de configuración propio. 1 métodos, 0 campos; usa `Minecraft_2`, `MaterialBridge_10`, `d`, `Minecraft`. |
| `Found` | `aze` | Identificada por un mensaje o clave de configuración propio. 23 métodos, 6 campos; usa `ColorBridge_2`, `PluginFileConfigurationHolder`, `CommandSenderBridge_5`. |
| `Generated` | `ayo` | Identificada por un mensaje o clave de configuración propio. 6 métodos, 5 campos; usa `MaterialBridge_10`, `e`, `c`. |
| `GetPacketID` | `aox` | Identificada por un mensaje o clave de configuración propio. 2 métodos, 2 campos; usa `PacketListenerRegistry`, `PlayerWrapper_4`. |
| `Happen` | `biu` | Identificada por un mensaje o clave de configuración propio. 19 métodos, 4 campos; usa `FluentBuilder_5`, `Opaque105`. |
| `HideFlags` | `aje` | Identificada por un mensaje o clave de configuración propio. 56 métodos, 5 campos; usa `Count`, `ComponentDataFixUtils`, `BannerPatternFormatFix`. |
| `HideFlags_10` | `ajw` | Identificada por un mensaje o clave de configuración propio. 56 métodos, 5 campos; usa `Count_10`, `LegacyComponentDataFixUtils`, `ExtraDataFixUtils`. |
| `HideFlags_11` | `ajy` | Identificada por un mensaje o clave de configuración propio. 56 métodos, 5 campos; usa `Count_11`, `LegacyComponentDataFixUtils`, `ExtraDataFixUtils`. |
| `HideFlags_12` | `aka` | Identificada por un mensaje o clave de configuración propio. 56 métodos, 5 campos; usa `Count_12`, `LegacyComponentDataFixUtils`, `ExtraDataFixUtils`. |
| `HideFlags_13` | `akc` | Identificada por un mensaje o clave de configuración propio. 56 métodos, 5 campos; usa `Count_13`, `LegacyComponentDataFixUtils`, `ExtraDataFixUtils`. |
| `HideFlags_2` | `ajg` | Identificada por un mensaje o clave de configuración propio. 56 métodos, 5 campos; usa `Count_2`, `ComponentDataFixUtils`, `BannerPatternFormatFix`. |
| `HideFlags_3` | `aji` | Identificada por un mensaje o clave de configuración propio. 56 métodos, 5 campos; usa `Count_3`, `LegacyComponentDataFixUtils`, `ExtraDataFixUtils`. |
| `HideFlags_4` | `ajk` | Identificada por un mensaje o clave de configuración propio. 56 métodos, 5 campos; usa `Count_4`, `LegacyComponentDataFixUtils`, `ExtraDataFixUtils`. |
| `HideFlags_5` | `ajm` | Identificada por un mensaje o clave de configuración propio. 56 métodos, 5 campos; usa `Count_5`, `ComponentDataFixUtils`, `BannerPatternFormatFix`. |
| `HideFlags_6` | `ajo` | Identificada por un mensaje o clave de configuración propio. 56 métodos, 5 campos; usa `Count_6`, `ComponentDataFixUtils`, `BannerPatternFormatFix`. |
| `HideFlags_7` | `ajq` | Identificada por un mensaje o clave de configuración propio. 56 métodos, 5 campos; usa `Count_7`, `LegacyComponentDataFixUtils`, `ExtraDataFixUtils`. |
| `HideFlags_8` | `ajs` | Identificada por un mensaje o clave de configuración propio. 56 métodos, 5 campos; usa `Count_8`, `LegacyComponentDataFixUtils`, `ExtraDataFixUtils`. |
| `HideFlags_9` | `aju` | Identificada por un mensaje o clave de configuración propio. 56 métodos, 5 campos; usa `Count_9`, `LegacyComponentDataFixUtils`, `ExtraDataFixUtils`. |
| `Hitbox` | `ec` | Identificada por un mensaje o clave de configuración propio. 22 métodos, 11 campos; usa `Opaque140`, `c`, `SmoothEnum`, `InstanceRegistry_10`. |
| `Implemented` | `beb` | Identificada por un mensaje o clave de configuración propio. 11 métodos, 1 campos; usa tipos internos. |
| `Implemented_2` | `bec` | Identificada por un mensaje o clave de configuración propio. 47 métodos, 13 campos; usa `InstanceHolderBuilder`, `InstanceHolder_6`. |
| `InfoNamespace` | `sq` | Identificada por un mensaje o clave de configuración propio. 1 métodos, 1 campos; usa `ItemStackRegistry`, `PluginFileConfigurationHolder`, `ConfigurationSectionBridge`, `CommandSenderBridge_5`. |
| `InfoNamespace_2` | `sr` | Identificada por un mensaje o clave de configuración propio. 2 métodos, 1 campos; usa `CreatureSpawnListener`, `ItemStackRegistry`, `PluginFileConfigurationHolder`, `CommandSenderBridge_5`. |
| `InfoNamespace_3` | `te` | Identificada por un mensaje o clave de configuración propio. 3 métodos, 2 campos; usa `ItemStackRegistry`, `PluginFileConfigurationHolder`, `CommandSenderBridge_5`. |
| `Input` | `bkw` | Identificada por un mensaje o clave de configuración propio. 16 métodos, 5 campos; usa tipos internos. |
| `ItemJsonNull` | `aza` | Identificada por un mensaje o clave de configuración propio. 5 métodos, 5 campos; usa tipos internos. |
| `ItemsadderHttpCodec` | `bal` | Identificada por un mensaje o clave de configuración propio. 1 métodos, 0 campos; usa `OPTIONS`. |
| `ItemsadderHttpPacket` | `bak` | Identificada por un mensaje o clave de configuración propio. 3 métodos, 5 campos; usa `PacketListenerRegistry`, `PlayerWrapper_4`. |
| `Json` | `ad` | Identificada por un mensaje o clave de configuración propio. 3 métodos, 0 campos; usa tipos internos. |
| `Json_2` | `bhb` | Identificada por un mensaje o clave de configuración propio. 6 métodos, 20 campos; usa `Opaque079`, `Opaque081`, `Opaque083`, `Opaque061`. |
| `KabKab` | `ur` | Identificada por un mensaje o clave de configuración propio. 5 métodos, 2 campos; usa `Opaque137`. |
| `LastModified` | `tf` | Identificada por un mensaje o clave de configuración propio. 16 métodos, 3 campos; usa `Main`, `PluginFileConfigurationHolder`, `CommandSenderBridge_5`. |
| `Minecraft` | `ayp` | Identificada por un mensaje o clave de configuración propio. 1 métodos, 3 campos; usa tipos internos. |
| `Minecraft_2` | `ayr` | Identificada por un mensaje o clave de configuración propio. 9 métodos, 0 campos; usa `Generated`, `MaterialBridge_12`, `MaterialBridge_11`. |
| `Minecraft_3` | `azj` | Identificada por un mensaje o clave de configuración propio. 1 métodos, 2 campos; usa `MaterialBridge_8`, `ItemStackRegistry`, `ItemStackBuilder_4`, `CommandSenderBridge_5`. |
| `Minecraft_4` | `azt` | Identificada por un mensaje o clave de configuración propio. 9 métodos, 0 campos; usa `ItemStackRegistry`, `c`, `ColorBridge`. |
| `Model` | `ays` | Identificada por un mensaje o clave de configuración propio. 1 métodos, 0 campos; usa `Parent`, `d`, `MaterialBridge_10`, `ItemStackBridge_2`. |
| `Model_2` | `ayt` | Identificada por un mensaje o clave de configuración propio. 3 métodos, 0 campos; usa `Minecraft_2`, `MaterialBridge_10`, `d`. |
| `Model_3` | `ayv` | Identificada por un mensaje o clave de configuración propio. 3 métodos, 0 campos; usa `Minecraft_2`, `MaterialBridge_10`, `d`. |
| `Model_4` | `azb` | Identificada por un mensaje o clave de configuración propio. 2 métodos, 0 campos; usa `Minecraft_2`, `MaterialBridge_10`, `d`. |
| `Model_5` | `azd` | Identificada por un mensaje o clave de configuración propio. 3 métodos, 0 campos; usa `Minecraft_2`, `MaterialBridge_10`, `d`. |
| `Normal` | `azc` | Identificada por un mensaje o clave de configuración propio. 7 métodos, 0 campos; usa `Minecraft_2`, `MaterialBridge_12`, `MaterialBridge_10`, `e`. |
| `North` | `azk` | Identificada por un mensaje o clave de configuración propio. 5 métodos, 6 campos; usa `e`, `Material`, `ItemStackBuilder_4`. |
| `OpenBack` | `ayu` | Identificada por un mensaje o clave de configuración propio. 6 métodos, 0 campos; usa `Minecraft_2`, `Minecraft`, `MaterialBridge_10`. |
| `OPTIONS` | `bam` | Identificada por un mensaje o clave de configuración propio. 5 métodos, 0 campos; usa `RecordOfFullHttpRequest`, `RecordOfChannelHandlerContext`, `PluginContract_2`, `ItemsadderHttpPacket`. |
| `OutputNull` | `bbo` | Identificada por un mensaje o clave de configuración propio. 3 métodos, 0 campos; usa tipos internos. |
| `Parent` | `ayy` | Identificada por un mensaje o clave de configuración propio. 2 métodos, 0 campos; usa `Generated`, `MaterialBridge_12`, `MaterialBridge_10`, `e`. |
| `Parent_2` | `azr` | Identificada por un mensaje o clave de configuración propio. 22 métodos, 7 campos; usa `g`, `a`, `r`. |
| `PatternLinesLength` | `vt` | Identificada por un mensaje o clave de configuración propio. 5 métodos, 0 campos; usa `ItemStackBridge_2`. |
| `Predicate` | `azp` | Identificada por un mensaje o clave de configuración propio. 2 métodos, 0 campos; usa tipos internos. |
| `Resource` | `st` | Identificada por un mensaje o clave de configuración propio. 6 métodos, 1 campos; usa `ConfigurationSectionBridge`, `PluginFileConfigurationHolder`, `CommandSenderBridge_5`. |
| `ResourceGraphics` | `tr` | Identificada por un mensaje o clave de configuración propio. 8 métodos, 2 campos; usa `PluginContract_21`, `Error_3`, `PluginFileConfigurationHolder`. |
| `ResourceGraphics_2` | `tw` | Identificada por un mensaje o clave de configuración propio. 6 métodos, 1 campos; usa `PluginContractImpl_8`, `ConfigurationSectionBridge`, `Error_3`, `Material`. |
| `ResourcePackCustom` | `azm` | Identificada por un mensaje o clave de configuración propio. 6 métodos, 3 campos; usa `b`, `PluginFileConfigurationHolder`, `CommandSenderBridge_5`. |
| `SecretYml` | `ah` | Identificada por un mensaje o clave de configuración propio. 1 métodos, 1 campos; usa `PluginFileConfigurationHolder`, `Main`. |
| `SpecificPropertiesPotion` | `tc` | Identificada por un mensaje o clave de configuración propio. 2 métodos, 0 campos; usa `ItemStackBuilder_4`, `ConfigurationSectionBridge`, `PluginFileConfigurationHolder`, `CommandSenderBridge_5`. |
| `TestPassed` | `ov` | Identificada por un mensaje o clave de configuración propio. 14 métodos, 2 campos; usa tipos internos. |
| `Textures` | `ayw` | Identificada por un mensaje o clave de configuración propio. 2 métodos, 0 campos; usa `c`. |
| `TriedLoadUnrecognized` | `ash` | Identificada por un mensaje o clave de configuración propio. 14 métodos, 1 campos; usa tipos internos. |
| `Truncated` | `bjh` | Identificada por un mensaje o clave de configuración propio. 16 métodos, 0 campos; usa `FluentBuilderBuilder`, `Opaque089`, `PluginContract_14`. |
| `Truncated_2` | `bjl` | Identificada por un mensaje o clave de configuración propio. 9 métodos, 0 campos; usa `FluentBuilderBuilder`, `PluginContract_14`, `CodedInputEncounteredEmbedded`, `FluentBuilderBuilder_2`. |
| `UTF8` | `bjt` | Identificada por un mensaje o clave de configuración propio. 20 métodos, 1 campos; usa `FluentBuilder_4`, `Opaque103`, `BufferCapacityEnough`. |
| `UTF8_2` | `bju` | Identificada por un mensaje o clave de configuración propio. 20 métodos, 1 campos; usa `FluentBuilder_4`, `Opaque103`, `BufferCapacityEnough`. |
| `UTF8_3` | `bkt` | Identificada por un mensaje o clave de configuración propio. 5 métodos, 1 campos; usa `Opaque102`. |
| `While` | `azs` | Identificada por un mensaje o clave de configuración propio. 5 métodos, 3 campos; usa tipos internos. |
| `Worlds` | `zs` | Identificada por un mensaje o clave de configuración propio. 6 métodos, 13 campos; usa `ChunkBridge_3`, `WorldBridge_8`, `PluginBridge_7`. |
| `YyyyMMDd` | `sy` | Identificada por un mensaje o clave de configuración propio. 3 métodos, 0 campos; usa `ItemStackRegistry`, `PluginFileConfigurationHolder`, `CommandSenderBridge_5`. |
| `YyyyMMddHHmmss` | `bbl` | Identificada por un mensaje o clave de configuración propio. 5 métodos, 2 campos; usa `Bukkit`, `Opaque015`. |

## Descifradores de cadenas

Reconstruyen texto a partir de enteros desplazados. Restos del ofuscador.

| Clase | Antes | Qué hace |
|---|---|---|
| `StringDecryptor` | `bfs` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_10` | `bgb` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_11` | `bgc` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_12` | `bgd` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_13` | `bge` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_14` | `bgf` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_15` | `bgg` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_16` | `bgh` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_17` | `bgi` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_18` | `bgj` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_19` | `bgk` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_2` | `bft` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_20` | `bgl` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_21` | `bgq` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_22` | `bgr` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_23` | `bgs` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_24` | `bgt` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_25` | `bgu` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_26` | `bgv` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_27` | `bgw` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_28` | `bgy` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_29` | `bgz` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_3` | `bfu` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_30` | `bhe` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_31` | `bhf` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_32` | `bhg` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_33` | `bhh` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_34` | `bhi` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_35` | `bhj` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_36` | `bim` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_37` | `u` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_4` | `bfv` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_5` | `bfw` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_6` | `bfx` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_7` | `bfy` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_8` | `bfz` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |
| `StringDecryptor_9` | `bga` | Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio. |

## Interfaces funcionales

Un solo método abstracto: lambdas y callbacks.

| Clase | Antes | Qué hace |
|---|---|---|
| `AFunction` | `auw` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `AFunction_2` | `bkq` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `AFunction_3` | `ot` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `AKFunction` | `bkl` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `AKFunction_2` | `bkm` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `AKFunction_3` | `bkp` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `CallFunction` | `bck` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `CallFunction_2` | `bcl` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `CallFunction_3` | `bco` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `CallFunction_4` | `bdt` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `Consumer` | `au` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `Consumer_2` | `bcf` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `Consumer_3` | `oz` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `DFunction` | `bey` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `DIFunction` | `bdn` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `DMFunction` | `apz` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `Executor` | `nc` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `FkFunction` | `biv` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `FXFunction` | `bjb` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `GfFunction` | `bjw` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `IFunction` | `aeh` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `KfFunction` | `iq` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `Loader` | `gz` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `OFunction` | `bjs` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `Predicate_2` | `gc` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `ReplaceFunction` | `awe` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `Runner` | `bcm` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `Runner_2` | `qp` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `SetBlockDataFunction` | `awb` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `StepFunction` | `bfi` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `WdFunction` | `bjv` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |
| `XQFunction` | `bdp` | Interfaz funcional: un único método abstracto, usada como callback o lambda. |

## Excepciones

Errores propios del plugin.

| Clase | Antes | Qué hace |
|---|---|---|
| `Error` | `mo` | Excepción propia del plugin, derivada de `Exception`. |
| `Error_2` | `sx` | Excepción propia del plugin, derivada de `Exception`. |
| `Error_3` | `tq` | Excepción propia del plugin, derivada de `Exception`. |
| `IOError` | `bkg` | Excepción propia del plugin, derivada de `IOException`. |
| `RuntimeError` | `ao` | Excepción propia del plugin, derivada de `RuntimeException`. |
| `RuntimeError_2` | `bag` | Excepción propia del plugin, derivada de `RuntimeException`. |
| `RuntimeError_3` | `bkv` | Excepción propia del plugin, derivada de `RuntimeException`. |

## Tareas

Se ejecutan en un hilo propio.

| Clase | Antes | Qué hace |
|---|---|---|
| `NullRequestStringTask` | `baj` | Tarea que corre en un hilo aparte. |

## Sin ancla semántica

Sin cadenas, sin tipos de librería y sin interfaz: no hay evidencia para un nombre específico. Se conserva el rol (`Opaque`) y el número.

| Clase | Antes | Qué hace |
|---|---|---|
| `Opaque001` | `aeg` | Sin ancla semántica: 0 campos, 1 métodos. Usa `NmsWrapperFactory`, `IFunction`. |
| `Opaque002` | `ail` | Sin ancla semántica: 0 campos, 0 métodos. Usa `Opaque003`. |
| `Opaque003` | `aim` | Sin ancla semántica: 0 campos, 0 métodos. Usa tipos internos. |
| `Opaque004` | `amn` | Sin ancla semántica: 2 campos, 4 métodos. Usa `TargetGoal`, `Mob`, `LivingEntity`. |
| `Opaque005` | `amt` | Sin ancla semántica: 2 campos, 4 métodos. Usa `TargetGoal`, `Mob`, `LivingEntity`. |
| `Opaque006` | `amz` | Sin ancla semántica: 2 campos, 4 métodos. Usa `TargetGoal`, `Mob`, `LivingEntity`. |
| `Opaque007` | `aos` | Sin ancla semántica: 3 campos, 2 métodos. Usa `PlayerWrapper_4`. |
| `Opaque008` | `awd` | Sin ancla semántica: 1 campos, 4 métodos. Usa `RecordOfObject`, `ReplaceFunction`. |
| `Opaque009` | `azf` | Sin ancla semántica: 2 campos, 3 métodos. Usa tipos internos. |
| `Opaque010` | `bah` | Sin ancla semántica: 5 campos, 1 métodos. Usa `IntLongData`, `CommandSenderBridge_5`. |
| `Opaque011` | `bb` | Sin ancla semántica: 0 campos, 1 métodos. Usa `Opaque001`, `IFunction`. |
| `Opaque012` | `bba` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque013` | `bbd` | Sin ancla semántica: 6 campos, 6 métodos. Usa `Bukkit`, `ChatColor`. |
| `Opaque014` | `bbj` | Sin ancla semántica: 1 campos, 2 métodos. Usa tipos internos. |
| `Opaque015` | `bbm` | Sin ancla semántica: 4 campos, 4 métodos. Usa `Bukkit`. |
| `Opaque016` | `bbn` | Sin ancla semántica: 0 campos, 1 métodos. Usa `CommandSenderBridge_5`. |
| `Opaque017` | `bbp` | Sin ancla semántica: 0 campos, 2 métodos. Usa tipos internos. |
| `Opaque018` | `bbx` | Sin ancla semántica: 0 campos, 13 métodos. Usa `Opaque019`, `FluentBuilder`. |
| `Opaque019` | `bca` | Sin ancla semántica: 6 campos, 4 métodos. Usa tipos internos. |
| `Opaque020` | `bch` | Sin ancla semántica: 1 campos, 4 métodos. Usa tipos internos. |
| `Opaque021` | `bci` | Sin ancla semántica: 2 campos, 1 métodos. Usa tipos internos. |
| `Opaque022` | `bcn` | Sin ancla semántica: 0 campos, 14 métodos. Usa `CallFunction_3`. |
| `Opaque023` | `bcq` | Sin ancla semántica: 1 campos, 1 métodos. Usa `BukkitRunnable`. |
| `Opaque024` | `bcr` | Sin ancla semántica: 1 campos, 1 métodos. Usa `BukkitRunnable`. |
| `Opaque025` | `bcs` | Sin ancla semántica: 1 campos, 1 métodos. Usa `BukkitRunnable`. |
| `Opaque026` | `bct` | Sin ancla semántica: 1 campos, 1 métodos. Usa `BukkitRunnable`. |
| `Opaque027` | `bdc` | Sin ancla semántica: 0 campos, 3 métodos. Usa `Bukkit`, `PluginManager`, `Plugin`, `PluginDescriptionFile`. |
| `Opaque028` | `bdq` | Sin ancla semántica: 3 campos, 7 métodos. Usa tipos internos. |
| `Opaque029` | `bdr` | Sin ancla semántica: 1 campos, 3 métodos. Usa `Opaque028`. |
| `Opaque030` | `bdu` | Sin ancla semántica: 2 campos, 5 métodos. Usa `IntData_2`, `BufferLocked`. |
| `Opaque031` | `bdx` | Sin ancla semántica: 0 campos, 8 métodos. Usa `Opaque034`. |
| `Opaque032` | `bdy` | Sin ancla semántica: 0 campos, 2 métodos. Usa tipos internos. |
| `Opaque033` | `bdz` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque034` | `bea` | Sin ancla semántica: 0 campos, 7 métodos. Usa tipos internos. |
| `Opaque035` | `bee` | Sin ancla semántica: 0 campos, 2 métodos. Usa `Opaque038`. |
| `Opaque036` | `bef` | Sin ancla semántica: 1 campos, 7 métodos. Usa `Implemented_2`, `Opaque035`, `InstanceHolder_6`, `Opaque037`. |
| `Opaque037` | `beg` | Sin ancla semántica: 0 campos, 5 métodos. Usa `Opaque039`. |
| `Opaque038` | `beh` | Sin ancla semántica: 5 campos, 3 métodos. Usa `Implemented_2`. |
| `Opaque039` | `bei` | Sin ancla semántica: 6 campos, 2 métodos. Usa tipos internos. |
| `Opaque040` | `bej` | Sin ancla semántica: 0 campos, 1 métodos. Usa `Opaque038`. |
| `Opaque041` | `bek` | Sin ancla semántica: 1 campos, 9 métodos. Usa `Implemented_2`, `Opaque040`, `Opaque042`. |
| `Opaque042` | `bel` | Sin ancla semántica: 0 campos, 5 métodos. Usa `Opaque039`. |
| `Opaque043` | `beo` | Sin ancla semántica: 0 campos, 1 métodos. Usa `Opaque038`. |
| `Opaque044` | `bep` | Sin ancla semántica: 0 campos, 5 métodos. Usa `Opaque039`. |
| `Opaque045` | `beq` | Sin ancla semántica: 1 campos, 8 métodos. Usa `Implemented_2`, `Opaque043`, `Opaque044`. |
| `Opaque046` | `ber` | Sin ancla semántica: 0 campos, 1 métodos. Usa tipos internos. |
| `Opaque047` | `bes` | Sin ancla semántica: 0 campos, 1 métodos. Usa `Opaque032`. |
| `Opaque048` | `bew` | Sin ancla semántica: 0 campos, 0 métodos. Usa tipos internos. |
| `Opaque049` | `bfg` | Sin ancla semántica: 1 campos, 1 métodos. Usa `Opaque050`. |
| `Opaque050` | `bfh` | Sin ancla semántica: 2 campos, 2 métodos. Usa `StepFunction`. |
| `Opaque051` | `bfj` | Sin ancla semántica: 2 campos, 3 métodos. Usa `InstanceHolder_7`. |
| `Opaque052` | `bfl` | Sin ancla semántica: 4 campos, 4 métodos. Usa `Opaque051`, `Opaque053`. |
| `Opaque053` | `bfm` | Sin ancla semántica: 1 campos, 2 métodos. Usa `WaitingEnum`. |
| `Opaque054` | `bgm` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque055`. |
| `Opaque055` | `bgn` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque056` | `bgo` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque057`. |
| `Opaque057` | `bgp` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque058` | `bgx` | Sin ancla semántica: 2 campos, 2 métodos. Usa `StringDecryptor_28`, `StringDecryptor_29`. |
| `Opaque059` | `bhc` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque060`. |
| `Opaque060` | `bhd` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque061` | `bhk` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque062`. |
| `Opaque062` | `bhl` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque063` | `bhm` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque064`. |
| `Opaque064` | `bhn` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque065` | `bho` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque066`. |
| `Opaque066` | `bhp` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque067` | `bhq` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque068`. |
| `Opaque068` | `bhr` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque069` | `bhs` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque070`. |
| `Opaque070` | `bht` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque071` | `bhu` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque072`. |
| `Opaque072` | `bhv` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque073` | `bhw` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque074`. |
| `Opaque074` | `bhx` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque075` | `bhy` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque076`. |
| `Opaque076` | `bhz` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque077` | `bia` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque078`. |
| `Opaque078` | `bib` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque079` | `bic` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque080`. |
| `Opaque080` | `bid` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque081` | `bie` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque082`. |
| `Opaque082` | `bif` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque083` | `big` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque084`. |
| `Opaque084` | `bih` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque085` | `bii` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque086`. |
| `Opaque086` | `bij` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque087` | `bik` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque088`. |
| `Opaque088` | `bil` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque089` | `bjf` | Sin ancla semántica: 5 campos, 14 métodos. Usa `PluginContractImpl_3`, `FluentBuilderBuilder`, `Opaque103`, `PluginContract_14`. |
| `Opaque090` | `bjg` | Sin ancla semántica: 5 campos, 14 métodos. Usa `PluginContractImpl_3`, `FluentBuilderBuilder_2`, `Opaque103`, `PluginContract_14`. |
| `Opaque091` | `bjj` | Sin ancla semántica: 2 campos, 1 métodos. Usa `PluginContractImpl_4`, `ExpectedMaxSizeNegative`, `PluginContractImpl_6`, `Opaque103`. |
| `Opaque092` | `bjn` | Sin ancla semántica: 0 campos, 9 métodos. Usa tipos internos. |
| `Opaque093` | `bjo` | Sin ancla semántica: 1 campos, 5 métodos. Usa tipos internos. |
| `Opaque094` | `bjr` | Sin ancla semántica: 2 campos, 2 métodos. Usa `OFunction`. |
| `Opaque095` | `bjx` | Sin ancla semántica: 0 campos, 4 métodos. Usa `UTF8_3`. |
| `Opaque096` | `bjz` | Sin ancla semántica: 2 campos, 4 métodos. Usa `PluginContractImpl_5`. |
| `Opaque097` | `bkd` | Sin ancla semántica: 2 campos, 2 métodos. Usa `Opaque096`. |
| `Opaque098` | `bke` | Sin ancla semántica: 2 campos, 2 métodos. Usa `Opaque096`. |
| `Opaque099` | `bki` | Sin ancla semántica: 2 campos, 2 métodos. Usa `Opaque096`. |
| `Opaque100` | `bkj` | Sin ancla semántica: 2 campos, 2 métodos. Usa `Opaque096`. |
| `Opaque101` | `bkr` | Sin ancla semántica: 1 campos, 12 métodos. Usa `Opaque105`, `Opaque102`. |
| `Opaque102` | `bks` | Sin ancla semántica: 14 campos, 21 métodos. Usa `FluentBuilder_5`. |
| `Opaque103` | `bkx` | Sin ancla semántica: 17 campos, 3 métodos. Usa tipos internos. |
| `Opaque104` | `bky` | Sin ancla semántica: 0 campos, 0 métodos. Usa tipos internos. |
| `Opaque105` | `blf` | Sin ancla semántica: 8 campos, 7 métodos. Usa `FluentBuilder_5`, `PluginContract_16`. |
| `Opaque106` | `cn` | Sin ancla semántica: 2 campos, 1 métodos. Usa tipos internos. |
| `Opaque107` | `cu` | Sin ancla semántica: 3 campos, 1 métodos. Usa `BukkitRunnable`, `PlayerInteractListener`, `Chunk`. |
| `Opaque108` | `cx` | Sin ancla semántica: 2 campos, 2 métodos. Usa `PluginBridge_6`, `ColorBridge`. |
| `Opaque109` | `cy` | Sin ancla semántica: 2 campos, 8 métodos. Usa `PluginBridge_6`, `Opaque108`, `CommandSenderBridge_5`. |
| `Opaque110` | `dh` | Sin ancla semántica: 3 campos, 2 métodos. Usa tipos internos. |
| `Opaque111` | `ea` | Sin ancla semántica: 3 campos, 2 métodos. Usa `RefIntegerData`. |
| `Opaque112` | `eh` | Sin ancla semántica: 14 campos, 23 métodos. Usa `LivingEntityBuilder`, `LocationBridge_11`, `LocationEquipmentSlotHolder`. |
| `Opaque113` | `el` | Sin ancla semántica: 3 campos, 2 métodos. Usa `Bukkit`, `Main`, `BukkitScheduler`. |
| `Opaque114` | `ex` | Sin ancla semántica: 1 campos, 3 métodos. Usa tipos internos. |
| `Opaque115` | `ey` | Sin ancla semántica: 1 campos, 5 métodos. Usa `ENTITYBlockViewer`, `InstanceHolder_9`, `Builder_5`, `RecordOfValueBuilder_2`. |
| `Opaque116` | `ez` | Sin ancla semántica: 0 campos, 6 métodos. Usa tipos internos. |
| `Opaque117` | `f` | Sin ancla semántica: 2 campos, 8 métodos. Usa `Opaque028`, `ChatColor`, `CommandSenderBridge_5`. |
| `Opaque118` | `ff` | Sin ancla semántica: 2 campos, 6 métodos. Usa `RecordOfValue_16`. |
| `Opaque119` | `fk` | Sin ancla semántica: 1 campos, 7 métodos. Usa tipos internos. |
| `Opaque120` | `fs` | Sin ancla semántica: 3 campos, 1 métodos. Usa tipos internos. |
| `Opaque121` | `fx` | Sin ancla semántica: 2 campos, 1 métodos. Usa tipos internos. |
| `Opaque122` | `i` | Sin ancla semántica: 2 campos, 1 métodos. Usa tipos internos. |
| `Opaque123` | `il` | Sin ancla semántica: 5 campos, 8 métodos. Usa tipos internos. |
| `Opaque124` | `jh` | Sin ancla semántica: 2 campos, 1 métodos. Usa tipos internos. |
| `Opaque125` | `jx` | Sin ancla semántica: 6 campos, 4 métodos. Usa `Opaque126`. |
| `Opaque126` | `ki` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque127` | `nq` | Sin ancla semántica: 0 campos, 1 métodos. Usa `Opaque001`, `IFunction`. |
| `Opaque128` | `pk` | Sin ancla semántica: 1 campos, 5 métodos. Usa `Opaque129`. |
| `Opaque129` | `pl` | Sin ancla semántica: 4 campos, 1 métodos. Usa tipos internos. |
| `Opaque130` | `qu` | Sin ancla semántica: 3 campos, 1 métodos. Usa `PluginBridge_6`. |
| `Opaque131` | `rr` | Sin ancla semántica: 2 campos, 3 métodos. Usa `Builder_15`. |
| `Opaque132` | `rv` | Sin ancla semántica: 0 campos, 1 métodos. Usa `Opaque001`, `IFunction`. |
| `Opaque133` | `sh` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque140`, `BiomeHolder`, `BlockWrapper_2`. |
| `Opaque134` | `tk` | Sin ancla semántica: 0 campos, 6 métodos. Usa `Color`. |
| `Opaque135` | `uc` | Sin ancla semántica: 1 campos, 1 métodos. Usa `Opaque136`. |
| `Opaque136` | `ud` | Sin ancla semántica: 3 campos, 7 métodos. Usa `LocationBridgeImpl`, `EntityBridge_4`. |
| `Opaque137` | `uq` | Sin ancla semántica: 1 campos, 2 métodos. Usa `ItemStackRegistry`, `CommandSenderBridge_5`. |
| `Opaque138` | `uv` | Sin ancla semántica: 3 campos, 2 métodos. Usa `NamespacedKeyWrapper`. |
| `Opaque139` | `uz` | Sin ancla semántica: 0 campos, 0 métodos. Usa tipos internos. |
| `Opaque140` | `v` | Sin ancla semántica: 2 campos, 12 métodos. Usa tipos internos. |
| `Opaque141` | `vn` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque142` | `wf` | Sin ancla semántica: 1 campos, 2 métodos. Usa tipos internos. |
| `Opaque143` | `wg` | Sin ancla semántica: 1 campos, 2 métodos. Usa `Opaque144`. |
| `Opaque144` | `wh` | Sin ancla semántica: 2 campos, 3 métodos. Usa tipos internos. |
| `Opaque145` | `wj` | Sin ancla semántica: 5 campos, 6 métodos. Usa tipos internos. |
| `Opaque146` | `wl` | Sin ancla semántica: 3 campos, 4 métodos. Usa tipos internos. |
| `Opaque147` | `wo` | Sin ancla semántica: 6 campos, 1 métodos. Usa `Opaque148`. |
| `Opaque148` | `wp` | Sin ancla semántica: 2 campos, 9 métodos. Usa `CommandSenderBridge_5`. |
| `Opaque149` | `ws` | Sin ancla semántica: 1 campos, 1 métodos. Usa tipos internos. |
| `Opaque150` | `ze` | Sin ancla semántica: 0 campos, 1 métodos. Usa `PacketListener_56`, `Main`. |
| `Opaque151` | `zm` | Sin ancla semántica: 2 campos, 1 métodos. Usa tipos internos. |

## Límites

- Los nombres son **inferidos**, no recuperados. `NmsWrapperFactory` nunca se llamó así en el código original.
- Las clases `Opaque` no tienen evidencia: son tuplas, lambdas y bolsas de campos sin cadenas propias, sin interfaz de librería y sin tipo Bukkit al que anclarse.
- Sólo se renombraron **clases**. Los métodos y campos conservan sus nombres ofuscados salvo donde sobrescriben métodos de librería.
- Análisis estático. Nada se ejecutó.
