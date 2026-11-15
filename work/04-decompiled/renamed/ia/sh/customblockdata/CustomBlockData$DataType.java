package ia.sh.customblockdata;

import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

private static final class CustomBlockData.DataType {
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

    private CustomBlockData.DataType() {
    }

    static /* synthetic */ PersistentDataType access$000() {
        return BOOLEAN;
    }
}
