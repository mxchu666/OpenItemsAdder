package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NFile;

class NFileHelper {
    public final NFile cg;
    boolean ch;

    public NFileHelper(NFile nFile) {
        this.cg = nFile;
    }

    public void g(boolean bl) {
        this.ch = bl;
    }

    public boolean al() {
        return this.ch;
    }
}
