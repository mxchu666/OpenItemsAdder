package itemsadder.m;

class azf {
    public int uz;
    public int uA;

    public static azf Bb() {
        return new azf(64, 32);
    }

    public azf() {
    }

    public azf(int n, int n2) {
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
