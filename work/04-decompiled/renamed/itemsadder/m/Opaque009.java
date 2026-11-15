package itemsadder.m;

class Opaque009 {
    public int uz;
    public int uA;

    public static Opaque009 Bb() {
        return new Opaque009(64, 32);
    }

    public Opaque009() {
    }

    public Opaque009(int n, int n2) {
        this.uA = n;
        this.uz = n2;
    }

    public String toString() {
        return this.uA + "x" + this.uz;
    }

    public boolean Bc() {
        return this.uA == 0 && this.uz == 0;
    }
}
