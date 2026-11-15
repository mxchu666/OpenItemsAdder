"""Render the class catalogue (CLASSES.md) from classes.tsv."""
import pathlib, re, collections

BASE = pathlib.Path(r"F:\OpenItemsAdder\work\deobf")
SRC = BASE / "out" / "classes.tsv"
JAR_MAP = BASE / "out" / "mapping.tsv"
OUT = pathlib.Path(r"F:\OpenItemsAdder\openitemsadder\CLASSES.md")

rows = []
with SRC.open(encoding="utf-8") as f:
    hdr = f.readline().rstrip("\n").split("\t")
    for line in f:
        rows.append(dict(zip(hdr, line.rstrip("\n").split("\t"))))

# NMS version comes from the factory evidence, not from the name suffix.
nms_version = {}
with JAR_MAP.open(encoding="utf-8") as f:
    for line in f:
        p = line.rstrip("\n").split("\t")
        if len(p) >= 4 and " on " in p[3]:
            nms_version[p[0]] = p[3].split(" on ")[-1].replace("_", ".")

SECTIONS = [
    ("nms", "Wrappers NMS", "Una clase por versión de Minecraft y por interfaz base. Seleccionadas en tiempo de ejecución por la fábrica NMS."),
    ("listener", "Listeners de Bukkit", "Métodos anotados con `@EventHandler`: reaccionan a eventos del servidor."),
    ("packet", "Adaptadores de paquetes", "Subclases de `PacketAdapter` (ProtocolLib): interceptan o modifican paquetes de red."),
    ("command", "Comandos", "Implementan `onCommand`: lógica de un subcomando del plugin."),
    ("interface", "Contratos e interfaces", "Interfaces que definen una API interna o un wrapper."),
    ("impl", "Implementaciones", "Clases que implementan o extienden otra clase ya nombrada."),
    ("builder", "Builders", "Objetos con setters fluidos que devuelven `this` y construyen otro objeto."),
    ("holder", "Contenedores de datos Bukkit", "Agrupan dos o más tipos de Bukkit/NMS."),
    ("dto", "DTO", "Sólo campos, sin lógica: transporte de datos entre capas."),
    ("record", "Records", "`java.lang.Record`: tuplas inmutables generadas por el compilador."),
    ("enum", "Enumeraciones", "Constantes fijas usadas como claves o modos."),
    ("switchmap", "Tablas de switch", "Arrays `int[]` sintéticos que mapean `Enum.ordinal()` a índices de `switch`."),
    ("registry", "Registros", "Índices en memoria (Map/List) con acceso por clave."),
    ("singleton", "Singletons y accesores", "Mantienen una instancia propia y la exponen."),
    ("type", "Utilidades por tipo dominante", "Sin interfaz de librería: se nombran por el tipo que más usan."),
    ("literal", "Identificadas por su propio texto", "Nombradas a partir de un mensaje o clave de configuración propio; el texto no se publica, sólo el nombre derivado."),
    ("decryptor", "Descifradores de cadenas", "Reconstruyen texto a partir de enteros desplazados. Restos del ofuscador."),
    ("function", "Interfaces funcionales", "Un solo método abstracto: lambdas y callbacks."),
    ("exception", "Excepciones", "Errores propios del plugin."),
    ("task", "Tareas", "Se ejecutan en un hilo propio."),
    ("fallback", "Sin ancla semántica", "Sin cadenas, sin tipos de librería y sin interfaz: no hay evidencia para un nombre específico. Se conserva el rol (`Opaque`) y el número."),
]

def clean(s):
    return s.strip()

def short_list(s, n=3):
    parts = [p for p in s.split(",") if p and p not in ("Object", "Record", "Enum")]
    return parts[:n]

def describe(r):
    kind = r["kind"]
    new = r["new"]
    own = new.replace("Impl", "")
    methods = int(r["methods"] or 0)
    fields = int(r["fields"] or 0)
    statics = int(r["statics"] or 0)
    events = short_list(r["events"], 3)
    bukkit = [x for x in short_list(r["bukkit"], 4) if not new.startswith(x)]
    lib = [x for x in short_list(r["lib"], 4) if not new.startswith(x)]
    uses = [x for x in short_list(r["uses"], 4) if not new.startswith(x)]
    supers = r["super"]
    itfs = short_list(r["interfaces"], 2)
    enums = short_list(r["enum"], 4)
    ftypes = short_list(r["fieldTypes"], 3)

    if kind == "nms":
        base = re.sub(r"_\d[\d_]*$", "", new)
        ver = nms_version.get(r["old"], "")
        return f"Wrapper NMS de `{base}` para Minecraft {ver}. Implementación concreta que la fábrica elige según la versión del servidor."
    if kind == "listener":
        base = "Clase base compartida por varias implementaciones. " if "ListenerBase" in new else ""
        ev = ", ".join(f"`{e}`" for e in events) or "eventos de Bukkit"
        return f"{base}Escucha {ev}. {methods} métodos."
    if kind == "packet":
        return f"Adaptador de ProtocolLib: intercepta paquetes antes o después del servidor. {methods} métodos, {fields} campos."
    if kind == "command":
        return f"Subcomando del plugin: parsea argumentos en `onCommand` y ejecuta la acción. {methods} métodos."
    if kind == "interface":
        dom = (lib or bukkit or ["objetos internos"])[0]
        return f"Contrato interno sobre `{dom}`: {methods} métodos, {fields} campos. Lo implementan las clases `*Impl` correspondientes."
    if kind == "impl":
        return f"Implementación de `{supers}`. {methods} métodos."
    if kind == "builder":
        prod = (lib or bukkit or ["objeto"])[0]
        return f"Builder fluido de `{prod}`: {r['fluent']} setters que devuelven `this`, {fields} campos."
    if kind == "holder":
        types = ", ".join(f"`{t}`" for t in (bukkit or ftypes))
        return f"Contenedor de datos: guarda {types}."
    if kind == "dto":
        types = ", ".join(f"`{t}`" for t in ftypes) or "valores"
        return f"DTO de {fields} campos ({types}), sin lógica propia."
    if kind == "record":
        types = ", ".join(f"`{t}`" for t in ftypes)
        return f"`record` de {fields} componentes ({types})."
    if kind == "enum":
        consts = ", ".join(f"`{c}`" for c in enums)
        return f"Enumeración de {len(r['enum'].split(',')) if r['enum'] else 0} constantes: {consts}."
    if kind == "switchmap":
        return "Tabla `int[]` sintética que traduce `Enum.ordinal()` a índices de `switch`. La genera el compilador."
    if kind == "registry":
        return f"Registro en memoria: indexa objetos por clave. {methods} métodos, {fields} campos."
    if kind == "singleton":
        return f"Accesor de instancia única: guarda y expone su propio estado. {methods} métodos."
    if kind == "type":
        dom = (lib or bukkit or ["objetos internos"])[0]
        return f"Utilidades sobre `{dom}`: {methods} métodos ({statics} estáticos). Sin interfaz de librería que la identifique."
    if kind == "decryptor":
        return "Descifrador de cadenas del ofuscador: reconstruye texto con desplazamientos de bits. No tiene lógica de negocio."
    if kind == "function":
        return "Interfaz funcional: un único método abstracto, usada como callback o lambda."
    if kind == "exception":
        return f"Excepción propia del plugin, derivada de `{supers}`."
    if kind == "literal":
        used = ", ".join(f"`{u}`" for u in uses) or "tipos internos"
        return f"Identificada por un mensaje o clave de configuración propio. {methods} métodos, {fields} campos; usa {used}."
    if kind == "task":
        return "Tarea que corre en un hilo aparte."
    # fallback
    used = ", ".join(f"`{u}`" for u in uses) or "tipos internos"
    return f"Sin ancla semántica: {fields} campos, {methods} métodos. Usa {used}."

by_kind = collections.defaultdict(list)
for r in rows:
    by_kind[r["kind"]].append(r)

for k in by_kind:
    by_kind[k].sort(key=lambda r: r["new"].lower())

total = len(rows)
named = total - len(by_kind.get("fallback", []))

out = []
out.append("# Catálogo de clases — ItemsAdder 4.0.18\n")
out.append("Las 1.674 clases de `itemsadder/m/` estaban ofuscadas: nombres de una o dos letras, sin `LocalVariableTable`, sin nombres originales en `SourceFile`, sin `InnerClasses`. Los identificadores originales **no se pueden recuperar**. Lo que sí se recupera es la estructura: qué hace cada clase, deducido del bytecode.\n")
out.append(f"Este catálogo cubre las 1.674. **{named}** tienen nombre respaldado por evidencia (`nms`, `listener`, `packet`, `builder`, `record`, `enum`, …); las **{total - named}** restantes no tienen ninguna pista y conservan el rol `Opaque` con un número.\n")
out.append("La columna «Antes» es el nombre ofuscado original. La columna «Qué hace» se genera a partir de la superclase, las interfaces, los tipos usados, las anotaciones y los miembros; no es una descripción escrita a mano clase por clase.\n")
out.append("Método completo: [`DEOBFUSCATION.md`](DEOBFUSCATION.md). Mapa de renombrado: [`work/03-deobfuscation/mapping.tsv`](work/03-deobfuscation/mapping.tsv).\n")

out.append("## Índice\n")
for kind, title, _ in SECTIONS:
    n = len(by_kind.get(kind, []))
    if not n:
        continue
    anchor = title.lower().replace(" ", "-").replace("ó", "o").replace("í", "i").replace("á", "a").replace("é", "e").replace("ú", "u").replace("ñ", "n")
    out.append(f"- [{title}](#{anchor}) — {n}")
out.append("")

for kind, title, blurb in SECTIONS:
    group = by_kind.get(kind, [])
    if not group:
        continue
    out.append(f"## {title}\n")
    out.append(blurb + "\n")
    out.append("| Clase | Antes | Qué hace |")
    out.append("|---|---|---|")
    for r in group:
        d = describe(r).replace("|", "\\|")
        out.append(f"| `{r['new']}` | `{r['old'].split('/')[-1]}` | {d} |")
    out.append("")

out.append("## Límites\n")
out.append("- Los nombres son **inferidos**, no recuperados. `NmsWrapperFactory` nunca se llamó así en el código original.")
out.append("- Las clases `Opaque` no tienen evidencia: son tuplas, lambdas y bolsas de campos sin cadenas propias, sin interfaz de librería y sin tipo Bukkit al que anclarse.")
out.append("- Sólo se renombraron **clases**. Los métodos y campos conservan sus nombres ofuscados salvo donde sobrescriben métodos de librería.")
out.append("- Análisis estático. Nada se ejecutó.\n")

OUT.write_text("\n".join(out), encoding="utf-8")
print(f"rows {total}, named {named}, fallback {total - named}, file {OUT.stat().st_size} bytes")
