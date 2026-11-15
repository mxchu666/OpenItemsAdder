package ia.sh.customblockdata;

import ia.sh.customblockdata.BlockDataListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.BlockVector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CustomBlockData
implements PersistentDataContainer {
    private static final char[] DEFAULT_PACKAGE = new char[]{'c', 'o', 'm', '.', 'j', 'e', 'f', 'f', '_', 'm', 'e', 'd', 'i', 'a', '.', 'c', 'u', 's', 't', 'o', 'm', 'b', 'l', 'o', 'c', 'k', 'd', 'a', 't', 'a'};
    private static final Set<Map.Entry<UUID, BlockVector>> DIRTY_BLOCKS = new HashSet<Map.Entry<UUID, BlockVector>>();
    private static final PersistentDataType<?, ?>[] PRIMITIVE_DATA_TYPES = new PersistentDataType[]{PersistentDataType.BYTE, PersistentDataType.SHORT, PersistentDataType.INTEGER, PersistentDataType.LONG, PersistentDataType.FLOAT, PersistentDataType.DOUBLE, PersistentDataType.STRING, PersistentDataType.BYTE_ARRAY, PersistentDataType.INTEGER_ARRAY, PersistentDataType.LONG_ARRAY, PersistentDataType.TAG_CONTAINER_ARRAY, PersistentDataType.TAG_CONTAINER};
    private static final NamespacedKey PERSISTENCE_KEY = Objects.requireNonNull(NamespacedKey.fromString((String)"customblockdata:protected"), "Could not create persistence NamespacedKey");
    private static final Pattern KEY_REGEX = Pattern.compile("^x(\\d+)y(-?\\d+)z(\\d+)$");
    private static final int CHUNK_MIN_XZ = 0;
    private static final int CHUNK_MAX_XZ = 15;
    private static final boolean HAS_MIN_HEIGHT_METHOD;
    private final PersistentDataContainer pdc;
    private final Chunk chunk;
    private final NamespacedKey key;
    private final Map.Entry<UUID, BlockVector> blockEntry;
    private final Plugin plugin;

    public CustomBlockData(@NotNull Block block, @NotNull Plugin plugin) {
        this.chunk = block.getChunk();
        this.key = CustomBlockData.getKey(plugin, block);
        this.pdc = this.getPersistentDataContainer();
        this.blockEntry = CustomBlockData.getBlockEntry(block);
        this.plugin = plugin;
    }

    @Deprecated
    public CustomBlockData(@NotNull Block block, @NotNull String string) {
        this.chunk = block.getChunk();
        this.key = new NamespacedKey(string, CustomBlockData.getKey(block));
        this.pdc = this.getPersistentDataContainer();
        this.plugin = JavaPlugin.getProvidingPlugin(CustomBlockData.class);
        this.blockEntry = CustomBlockData.getBlockEntry(block);
    }

    private static void checkRelocation() {
        if (CustomBlockData.class.getPackage().getName().equals(new String(DEFAULT_PACKAGE))) {
            try {
                JavaPlugin javaPlugin = JavaPlugin.getProvidingPlugin(CustomBlockData.class);
                javaPlugin.getLogger().warning("Nag author(s) " + String.join((CharSequence)", ", javaPlugin.getDescription().getAuthors()) + " of plugin " + javaPlugin.getName() + " for not relocating the CustomBlockData package.");
            }
            catch (IllegalArgumentException illegalArgumentException) {
                // empty catch block
            }
        }
    }

    private static Map.Entry<UUID, BlockVector> getBlockEntry(@NotNull Block block) {
        UUID uUID = block.getWorld().getUID();
        BlockVector blockVector = new BlockVector(block.getX(), block.getY(), block.getZ());
        return new AbstractMap.SimpleEntry<UUID, BlockVector>(uUID, blockVector);
    }

    static boolean isDirty(Block block) {
        return DIRTY_BLOCKS.contains(CustomBlockData.getBlockEntry(block));
    }

    static void setDirty(Plugin plugin, Map.Entry<UUID, BlockVector> entry) {
        if (!plugin.isEnabled()) {
            return;
        }
        DIRTY_BLOCKS.add(entry);
        Bukkit.getScheduler().runTask(plugin, () -> DIRTY_BLOCKS.remove(entry));
    }

    private static NamespacedKey getKey(Plugin plugin, Block block) {
        return new NamespacedKey(plugin, CustomBlockData.getKey(block));
    }

    @NotNull
    static String getKey(@NotNull Block block) {
        int n = block.getX() & 0xF;
        int n2 = block.getY();
        int n3 = block.getZ() & 0xF;
        return "x" + n + "y" + n2 + "z" + n3;
    }

    @Nullable
    static Block getBlockFromKey(NamespacedKey namespacedKey, Chunk chunk) {
        Matcher matcher = KEY_REGEX.matcher(namespacedKey.getKey());
        if (!matcher.matches()) {
            return null;
        }
        int n = Integer.parseInt(matcher.group(1));
        int n2 = Integer.parseInt(matcher.group(2));
        int n3 = Integer.parseInt(matcher.group(3));
        if (n < 0 || n > 15 || n3 < 0 || n3 > 15 || n2 < CustomBlockData.getWorldMinHeight(chunk.getWorld()) || n2 > chunk.getWorld().getMaxHeight() - 1) {
            return null;
        }
        return chunk.getBlock(n, n2, n3);
    }

    static int getWorldMinHeight(World world) {
        if (HAS_MIN_HEIGHT_METHOD) {
            return world.getMinHeight();
        }
        return 0;
    }

    public static boolean hasCustomBlockData(Block block, Plugin plugin) {
        return block.getChunk().getPersistentDataContainer().has(CustomBlockData.getKey(plugin, block), PersistentDataType.TAG_CONTAINER);
    }

    public static boolean isProtected(Block block, Plugin plugin) {
        return new CustomBlockData(block, plugin).isProtected();
    }

    public static void registerListener(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents((Listener)new BlockDataListener(plugin), plugin);
    }

    @NotNull
    public static Set<Block> getBlocksWithCustomData(Plugin plugin, Chunk chunk) {
        NamespacedKey namespacedKey = new NamespacedKey(plugin, "dummy");
        return CustomBlockData.getBlocksWithCustomData(chunk, namespacedKey);
    }

    @NotNull
    private static Set<Block> getBlocksWithCustomData(@NotNull Chunk chunk, @NotNull NamespacedKey namespacedKey3) {
        PersistentDataContainer persistentDataContainer = chunk.getPersistentDataContainer();
        return persistentDataContainer.getKeys().stream().filter(namespacedKey2 -> namespacedKey2.getNamespace().equals(namespacedKey3.getNamespace())).map(namespacedKey -> CustomBlockData.getBlockFromKey(namespacedKey, chunk)).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    @NotNull
    public static Set<Block> getBlocksWithCustomData(String string, Chunk chunk) {
        NamespacedKey namespacedKey = new NamespacedKey(string, "dummy");
        return CustomBlockData.getBlocksWithCustomData(chunk, namespacedKey);
    }

    public static PersistentDataType<?, ?> getDataType(PersistentDataContainer persistentDataContainer, NamespacedKey namespacedKey) {
        for (PersistentDataType<?, ?> persistentDataType : PRIMITIVE_DATA_TYPES) {
            if (!persistentDataContainer.has(namespacedKey, persistentDataType)) continue;
            return persistentDataType;
        }
        return null;
    }

    @Nullable
    public Block getBlock() {
        World world = Bukkit.getWorld((UUID)this.blockEntry.getKey());
        if (world == null) {
            return null;
        }
        BlockVector blockVector = this.blockEntry.getValue();
        return world.getBlockAt(blockVector.getBlockX(), blockVector.getBlockY(), blockVector.getBlockZ());
    }

    @NotNull
    private PersistentDataContainer getPersistentDataContainer() {
        PersistentDataContainer persistentDataContainer = this.chunk.getPersistentDataContainer();
        PersistentDataContainer persistentDataContainer2 = (PersistentDataContainer)persistentDataContainer.get(this.key, PersistentDataType.TAG_CONTAINER);
        if (persistentDataContainer2 != null) {
            return persistentDataContainer2;
        }
        return persistentDataContainer.getAdapterContext().newPersistentDataContainer();
    }

    public boolean isProtected() {
        return this.has(PERSISTENCE_KEY, DataType.BOOLEAN);
    }

    public void setProtected(boolean bl) {
        if (bl) {
            this.set(PERSISTENCE_KEY, DataType.BOOLEAN, true);
        } else {
            this.remove(PERSISTENCE_KEY);
        }
    }

    public void clear() {
        this.pdc.getKeys().forEach(arg_0 -> ((PersistentDataContainer)this.pdc).remove(arg_0));
        this.save();
    }

    private void save() {
        CustomBlockData.setDirty(this.plugin, this.blockEntry);
        if (this.pdc.isEmpty()) {
            this.chunk.getPersistentDataContainer().remove(this.key);
        } else {
            this.chunk.getPersistentDataContainer().set(this.key, PersistentDataType.TAG_CONTAINER, (Object)this.pdc);
        }
    }

    public void copyTo(Block block, Plugin plugin) {
        CustomBlockData customBlockData = new CustomBlockData(block, plugin);
        this.getKeys().forEach(namespacedKey -> {
            PersistentDataType<?, ?> persistentDataType = CustomBlockData.getDataType(this, namespacedKey);
            if (persistentDataType == null) {
                return;
            }
            customBlockData.set((NamespacedKey)namespacedKey, (PersistentDataType)persistentDataType, (Object)this.get((NamespacedKey)namespacedKey, (PersistentDataType)persistentDataType));
        });
    }

    public <T, Z> void set(@NotNull NamespacedKey namespacedKey, @NotNull PersistentDataType<T, Z> persistentDataType, @NotNull Z z) {
        this.pdc.set(namespacedKey, persistentDataType, z);
        this.save();
    }

    public <T, Z> boolean has(@NotNull NamespacedKey namespacedKey, @NotNull PersistentDataType<T, Z> persistentDataType) {
        return this.pdc.has(namespacedKey, persistentDataType);
    }

    public boolean has(@NotNull NamespacedKey namespacedKey) {
        for (PersistentDataType<?, ?> persistentDataType : PRIMITIVE_DATA_TYPES) {
            if (!this.pdc.has(namespacedKey, persistentDataType)) continue;
            return true;
        }
        return false;
    }

    @Nullable
    public <T, Z> Z get(@NotNull NamespacedKey namespacedKey, @NotNull PersistentDataType<T, Z> persistentDataType) {
        return (Z)this.pdc.get(namespacedKey, persistentDataType);
    }

    @NotNull
    public <T, Z> Z getOrDefault(@NotNull NamespacedKey namespacedKey, @NotNull PersistentDataType<T, Z> persistentDataType, @NotNull Z z) {
        return (Z)this.pdc.getOrDefault(namespacedKey, persistentDataType, z);
    }

    @NotNull
    public Set<NamespacedKey> getKeys() {
        return this.pdc.getKeys();
    }

    public void remove(@NotNull NamespacedKey namespacedKey) {
        this.pdc.remove(namespacedKey);
        this.save();
    }

    public boolean isEmpty() {
        return this.pdc.isEmpty();
    }

    @NotNull
    public PersistentDataAdapterContext getAdapterContext() {
        return this.pdc.getAdapterContext();
    }

    @Deprecated
    @NotNull
    @PaperOnly
    public byte[] serializeToBytes() {
        return this.pdc.serializeToBytes();
    }

    @Deprecated
    @PaperOnly
    public void readFromBytes(byte[] byArray, boolean bl) {
        this.pdc.readFromBytes(byArray, bl);
    }

    @Deprecated
    @PaperOnly
    public void readFromBytes(byte[] byArray) {
        this.pdc.readFromBytes(byArray);
    }

    public PersistentDataType<?, ?> getDataType(NamespacedKey namespacedKey) {
        return CustomBlockData.getDataType(this, namespacedKey);
    }

    static {
        CustomBlockData.checkRelocation();
        boolean bl = false;
        try {
            World.class.getMethod("getMinHeight", new Class[0]);
            bl = true;
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            // empty catch block
        }
        HAS_MIN_HEIGHT_METHOD = bl;
    }

    private static final class DataType {
        private static final PersistentDataType<Byte, Boolean> BOOLEAN = new PersistentDataType<Byte, Boolean>(){

            @NotNull
            public Class<Byte> getPrimitiveType() {
                return Byte.class;
            }

            @NotNull
            public Class<Boolean> getComplexType() {
                return Boolean.class;
            }

            @NotNull
            public Byte toPrimitive(@NotNull Boolean bl, @NotNull PersistentDataAdapterContext persistentDataAdapterContext) {
                return bl != false ? (byte)1 : 0;
            }

            @NotNull
            public Boolean fromPrimitive(@NotNull Byte by, @NotNull PersistentDataAdapterContext persistentDataAdapterContext) {
                return by == 1;
            }
        };

        private DataType() {
        }
    }

    @Retention(value=RetentionPolicy.CLASS)
    @Target(value={ElementType.METHOD})
    private static @interface PaperOnly {
    }
}
