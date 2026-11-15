"""Derive rename hints for the NMS wrapper layer from the decompiled factory.

The factory (itemsadder/m/aab) is a 24-way switch: base interface -> MC version -> impl class.
That gives every version implementation a real identity: <Base>_<version>.
"""
import re, sys, collections, pathlib

SRC = pathlib.Path(sys.argv[1] if len(sys.argv) > 1 else r"F:\OpenItemsAdder\work\src_obf")
PKG = SRC / "itemsadder" / "m"
out = pathlib.Path(sys.argv[2] if len(sys.argv) > 2 else "hints.tsv")

# Bukkit/Paper types that describe what a wrapper is about, most specific first.
TYPE_WORDS = [
    ("BlockData", "BlockData"), ("BlockState", "BlockState"), ("Block", "Block"),
    ("ItemStack", "Item"), ("Inventory", "Inventory"), ("Entity", "Entity"),
    ("Player", "Player"), ("Chunk", "Chunk"), ("World", "World"),
    ("Sound", "Sound"), ("Particle", "Particle"), ("Recipe", "Recipe"),
    ("Advancement", "Advancement"), ("BossBar", "BossBar"), ("Scoreboard", "Scoreboard"),
    ("Team", "Team"), ("Sign", "Sign"), ("Firework", "Firework"), ("Map", "Map"),
    ("Biome", "Biome"), ("Potion", "Potion"), ("Enchantment", "Enchantment"),
    ("TileEntity", "TileEntity"), ("Nbt", "Nbt"), ("NBT", "Nbt"),
    ("Packet", "Packet"), ("Chat", "Chat"), ("Attribute", "Attribute"),
    ("Damage", "Damage"), ("Explosion", "Explosion"), ("Projectile", "Projectile"),
    ("Mob", "Mob"), ("Goal", "MobGoal"), ("Pathfind", "Pathfind"),
]

def base_name(base):
    f = PKG / (base + ".java")
    if not f.exists():
        return "Nms"
    text = f.read_text(encoding="utf-8", errors="replace")
    plus = collections.Counter()
    for word, name in TYPE_WORDS:
        n = len(re.findall(r"\b" + re.escape(word) + r"\b", text))
        if n:
            plus[name] = n
    picks = [n for n, _ in plus.most_common(2)]
    if not picks:
        return "Nms"
    if len(picks) == 2 and plus[picks[1]] * 100 >= plus[picks[0]] * 60:
        return picks[0] + "And" + picks[1] + "Nms"
    return picks[0] + "Nms"

factory = None
best = 0
for f in PKG.glob("*.java"):
    n = len(re.findall(r'Class\.forName\("itemsadder\.m\.', f.read_text(encoding="utf-8", errors="replace")))
    if n > best:
        best, factory = n, f
if factory is None or best < 10:
    sys.exit("factory not found")

lines = [(factory.stem, "NmsWrapperFactory", f"dispatches {best} NMS implementations")]
used_bases = {}

text = factory.read_text(encoding="utf-8", errors="replace")
# Split on the base-class guards.
blocks = re.split(r"\n\s*if \((\w+)\.class == clazz\) \{", text)
# blocks[0] is preamble; then pairs (base, body)
for i in range(1, len(blocks) - 1, 2):
    base, body = blocks[i], blocks[i + 1]
    bname = base_name(base)
    used_bases[bname] = used_bases.get(bname, 0) + 1
    if used_bases[bname] > 1:
        bname = bname + str(used_bases[bname])
    lines.append((base, bname, "NMS wrapper interface"))
    seen = collections.Counter()
    for ver, target in re.findall(r'case Version\.(v[\w]+) -> Class\.forName\("itemsadder\.m\.(\w+)"\)', body):
        v = ver[1:]  # strip leading v
        name = f"{bname}_{v}"
        seen[name] += 1
        if seen[name] > 1:
            name += f"_{seen[name]}"
        lines.append((target, name, f"Class.forName target for {base} on {v}"))
    # the one unrenamed implementation
    for ver, target in re.findall(r'case Version\.(v[\w]+) -> Class\.forName\("dev\.lone\.[\w.]+\.(\w+)"\)', body):
        pass

out.write_text("\n".join(f"{a}\t{b}\t{c}" for a, b, c in lines) + "\n", encoding="utf-8")
print(f"factory {factory.stem}: {best} targets, {len(lines)} hints -> {out}")
