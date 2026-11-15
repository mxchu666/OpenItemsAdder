package itemsadder.m;

import java.awt.image.RenderedImage;
import java.io.File;
import java.util.Iterator;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class bbo {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean a(RenderedImage renderedImage, String string, File file) {
        if (file == null) {
            throw new IllegalArgumentException("output == null!");
        }
        ImageWriter imageWriter = bbo.a(renderedImage, string);
        if (imageWriter == null) {
            return false;
        }
        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(file);
        if (imageOutputStream == null) {
            throw new IIOException("Can't create an ImageOutputStream!");
        }
        try {
            boolean bl = bbo.a(renderedImage, imageWriter, imageOutputStream);
            return bl;
        }
        finally {
            imageOutputStream.close();
        }
    }

    private static ImageWriter a(RenderedImage renderedImage, String string) {
        ImageTypeSpecifier imageTypeSpecifier = ImageTypeSpecifier.createFromRenderedImage(renderedImage);
        Iterator<ImageWriter> iterator = ImageIO.getImageWriters(imageTypeSpecifier, string);
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

    private static boolean a(RenderedImage renderedImage, ImageWriter imageWriter, ImageOutputStream imageOutputStream) {
        if (imageWriter == null) {
            return false;
        }
        imageWriter.setOutput(imageOutputStream);
        try {
            imageWriter.write(renderedImage);
        }
        finally {
            imageWriter.dispose();
            imageOutputStream.flush();
        }
        return true;
    }
}
