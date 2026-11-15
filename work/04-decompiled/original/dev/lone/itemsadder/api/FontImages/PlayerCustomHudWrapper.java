package dev.lone.itemsadder.api.FontImages;

import dev.lone.itemsadder.api.FontImages.FontImageWrapper;
import dev.lone.itemsadder.api.FontImages.PlayerHudsHolderWrapper;
import dev.lone.itemsadder.api.FontImages.PlayerQuantityHudWrapper;
import itemsadder.m.ik;
import java.util.List;

public class PlayerCustomHudWrapper
extends PlayerQuantityHudWrapper {
    private final ik internalCustomHud;

    public PlayerCustomHudWrapper(PlayerHudsHolderWrapper playerHudsHolderWrapper, String string) {
        super(playerHudsHolderWrapper, string);
        this.internalCustomHud = (ik)this.internal;
    }

    public void clearFontImagesAndRefresh() {
        this.internalCustomHud.ka();
        this.playerHUDsHolderWrapper.getInternal().recalculateOffsets();
    }

    public void setFontImages(List list) {
        this.clearFontImagesAndRefresh();
        for (int i = 0; i < list.size(); ++i) {
            FontImageWrapper fontImageWrapper = (FontImageWrapper)list.get(i);
            this.internalCustomHud.a(fontImageWrapper.getInternal());
        }
    }

    public void removeFontImageByIndex(int n) {
        this.internalCustomHud.Z(n);
    }

    public void addFontImageToIndex(FontImageWrapper fontImageWrapper, int n) {
        if (fontImageWrapper.getInternal() != null) {
            this.internalCustomHud.a(n, fontImageWrapper.getInternal());
        }
    }

    public void addFontImage(FontImageWrapper fontImageWrapper) {
        if (fontImageWrapper.getInternal() != null) {
            this.internalCustomHud.a(fontImageWrapper.getInternal());
        }
    }

    public int getFontImagesCount() {
        return this.internalCustomHud.kb();
    }
}
