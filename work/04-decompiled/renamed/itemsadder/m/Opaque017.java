package itemsadder.m;

import java.awt.image.BufferedImage;

public class Opaque017 {
    public static int[] d(BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int[] nArray = new int[n * n2];
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                nArray[i * n + j] = bufferedImage.getRGB(j, i);
            }
        }
        return nArray;
    }

    public static boolean e(BufferedImage bufferedImage) {
        if (bufferedImage == null) {
            return false;
        }
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        if (n == 64 && n2 == 32) {
            return false;
        }
        if (n % 64 != 0 || n2 % 64 != 0) {
            return false;
        }
        int n3 = Math.max(1, n / 64);
        int n4 = 54 * n3;
        int n5 = 20 * n3;
        if (n4 >= n || n5 >= n2) {
            return false;
        }
        int n6 = bufferedImage.getRGB(n4, n5);
        int n7 = n6 >>> 24 & 0xFF;
        return n7 == 0;
    }
}
