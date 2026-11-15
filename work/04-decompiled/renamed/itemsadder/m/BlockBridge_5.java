package itemsadder.m;

import it.unimi.dsi.fastutil.ints.Int2ByteMap;
import it.unimi.dsi.fastutil.ints.Int2ByteOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import itemsadder.m.RecordOfList;
import itemsadder.m.RecordOfString_4;
import itemsadder.m.RecordOfValue_5;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Nullable;

public final class BlockBridge_5 {
    private final List gO = new ObjectArrayList(16);
    private final Int2IntMap gP = new Int2IntOpenHashMap(64);
    private final Int2ByteMap gQ = new Int2ByteOpenHashMap(64);
    private volatile RecordOfList gR;

    public static int a(int n, int n2, int n3) {
        if ((n & 0xFFFFFFF0) != 0 || (n3 & 0xFFFFFFF0) != 0) {
            throw new IllegalArgumentException("x,z must be 0..15");
        }
        int n4 = n2 & 0xFFFF;
        return n & 0xF | (n3 & 0xF) << 4 | n4 << 8;
    }

    public static int c(int n) {
        return n & 0xF;
    }

    public static int d(int n) {
        return n >>> 4 & 0xF;
    }

    public static int e(int n) {
        return (short)(n >>> 8);
    }

    BlockBridge_5() {
        this.gP.defaultReturnValue(-1);
        this.gQ.defaultReturnValue((byte)0);
    }

    private int ab(String string) {
        int n = this.gO.indexOf(string);
        if (n >= 0) {
            return n;
        }
        this.gO.add(string);
        return this.gO.size() - 1;
    }

    public void a(int n, int n2, int n3, String string, byte by) {
        int n4 = BlockBridge_5.a(n, n2, n3);
        int n5 = this.ab(string);
        this.gP.put(n4, n5);
        this.gQ.put(n4, (byte)(by & 0xFF));
        this.gR = null;
    }

    public void a(Block block, String string, byte by) {
        int n = block.getX() & 0xF;
        int n2 = block.getY();
        int n3 = block.getZ() & 0xF;
        this.a(n, n2, n3, string, by);
    }

    public boolean b(int n, int n2, int n3) {
        int n4 = BlockBridge_5.a(n, n2, n3);
        boolean bl = this.gP.remove(n4) != -1;
        this.gQ.remove(n4);
        if (bl) {
            this.gR = null;
        }
        return bl;
    }

    @Nullable
    public RecordOfString_4 c(int n, int n2, int n3) {
        int n4 = BlockBridge_5.a(n, n2, n3);
        int n5 = this.gP.get(n4);
        if (n5 == -1) {
            return null;
        }
        String string = (String)this.gO.get(n5);
        byte by = this.gQ.getOrDefault(n4, (byte)0);
        return new RecordOfString_4(string, by);
    }

    public RecordOfString_4 f(Block block) {
        int n = block.getX() & 0xF;
        int n2 = block.getY();
        int n3 = block.getZ() & 0xF;
        return this.c(n, n2, n3);
    }

    public int size() {
        return this.gP.size();
    }

    public List be() {
        return Collections.unmodifiableList(this.gO);
    }

    public void bf() {
        BitSet bitSet = new BitSet();
        Object object = this.gP.values().iterator();
        while (object.hasNext()) {
            int n = (Integer)object.next();
            bitSet.set(n);
        }
        if (bitSet.length() == this.gO.size()) {
            return;
        }
        object = new int[this.gO.size()];
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < this.gO.size(); ++i) {
            if (bitSet.get(i)) {
                object[i] = (IntIterator)arrayList.size();
                arrayList.add((String)this.gO.get(i));
                continue;
            }
            object[i] = (IntIterator)-1;
        }
        for (Map.Entry entry : this.gP.int2IntEntrySet()) {
            IntIterator intIterator = object[(Integer)entry.getValue()];
            if (intIterator < 0) {
                throw new IllegalStateException("Remap produced gap");
            }
            entry.setValue((int)intIterator);
        }
        this.gO.clear();
        this.gO.addAll(arrayList);
        this.gR = null;
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public byte[] bg() {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();){
            Object object;
            try (DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);){
                dataOutputStream.writeByte(1);
                dataOutputStream.writeInt(this.gO.size());
                for (String string : this.gO) {
                    dataOutputStream.writeUTF(string);
                }
                dataOutputStream.writeInt(this.gP.size());
                object = this.gP.keySet().iterator();
                while (object.hasNext()) {
                    int n = (Integer)object.next();
                    int n2 = this.gP.get(n);
                    byte by = this.gQ.getOrDefault(n, (byte)0);
                    dataOutputStream.writeInt(n);
                    dataOutputStream.writeShort(n2 & 0xFFFF);
                    dataOutputStream.writeByte(by & 0xFF);
                }
                object = byteArrayOutputStream.toByteArray();
            }
            return object;
        }
        catch (IOException iOException) {
            throw new IllegalStateException("Serialize chunk crops failed", iOException);
        }
    }

    public static BlockBridge_5 b(byte[] byArray) {
        BlockBridge_5 blockBridge_5;
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(byArray));
        try {
            int n;
            int n2 = dataInputStream.readUnsignedByte();
            if (n2 != 1) {
                throw new IllegalStateException("Unsupported version " + n2);
            }
            BlockBridge_5 blockBridge_52 = new BlockBridge_5();
            int n3 = dataInputStream.readInt();
            for (n = 0; n < n3; ++n) {
                blockBridge_52.gO.add(dataInputStream.readUTF());
            }
            n = dataInputStream.readInt();
            for (int i = 0; i < n; ++i) {
                int n4 = dataInputStream.readInt();
                int n5 = dataInputStream.readUnsignedShort();
                byte by = (byte)dataInputStream.readUnsignedByte();
                blockBridge_52.gP.put(n4, n5);
                blockBridge_52.gQ.put(n4, by);
            }
            blockBridge_5 = blockBridge_52;
        }
        catch (Throwable throwable) {
            try {
                try {
                    dataInputStream.close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (IOException iOException) {
                throw new IllegalStateException("Deserialize chunk crops failed", iOException);
            }
        }
        dataInputStream.close();
        return blockBridge_5;
    }

    public RecordOfList bh() {
        RecordOfList recordOfList = this.gR;
        if (recordOfList != null) {
            return recordOfList;
        }
        ArrayList<RecordOfValue_5> arrayList = new ArrayList<RecordOfValue_5>(this.gP.size());
        IntIterator intIterator = this.gP.keySet().iterator();
        while (intIterator.hasNext()) {
            int n = (Integer)intIterator.next();
            int n2 = this.gP.get(n);
            String string = (String)this.gO.get(n2);
            byte by = this.gQ.getOrDefault(n, (byte)0);
            arrayList.add(new RecordOfValue_5(BlockBridge_5.c(n), BlockBridge_5.e(n), BlockBridge_5.d(n), string, by));
        }
        this.gR = recordOfList = new RecordOfList(Collections.unmodifiableList(arrayList));
        return recordOfList;
    }
}
