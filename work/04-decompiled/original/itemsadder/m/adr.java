package itemsadder.m;

import java.awt.image.BufferedImage;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class adr
extends Record {
    private final String Yn;
    private final BufferedImage Yo;
    private final boolean Yp;

    public adr(String string, BufferedImage bufferedImage, boolean bl) {
        this.Yn = string;
        this.Yo = bufferedImage;
        this.Yp = bl;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{adr.class, "playerSkin;skin;isSlim", "Yn", "Yo", "Yp"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{adr.class, "playerSkin;skin;isSlim", "Yn", "Yo", "Yp"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{adr.class, "playerSkin;skin;isSlim", "Yn", "Yo", "Yp"}, this, object);
    }

    public String ty() {
        return this.Yn;
    }

    public BufferedImage tz() {
        return this.Yo;
    }

    public boolean tA() {
        return this.Yp;
    }
}
