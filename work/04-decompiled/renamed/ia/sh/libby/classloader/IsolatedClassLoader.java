package ia.sh.libby.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class IsolatedClassLoader
extends URLClassLoader {
    public IsolatedClassLoader(URL ... uRLArray) {
        super(Objects.requireNonNull(uRLArray, "urls"), ClassLoader.getSystemClassLoader().getParent());
    }

    @Override
    public void addURL(@NotNull URL uRL) {
        super.addURL(uRL);
    }

    public void addPath(@NotNull Path path) {
        try {
            this.addURL(Objects.requireNonNull(path, "path").toUri().toURL());
        }
        catch (MalformedURLException malformedURLException) {
            throw new IllegalArgumentException(malformedURLException);
        }
    }

    public Class<?> defineClass(@NotNull String string, @NotNull InputStream inputStream) {
        byte[] byArray = IsolatedClassLoader.readAllBytes(inputStream);
        return super.defineClass(string, byArray, 0, byArray.length);
    }

    private static byte[] readAllBytes(@NotNull InputStream inputStream) {
        int n = 4096;
        byte[] byArray = new byte[4096];
        IOException iOException = null;
        try {
            byte[] byArray2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                int n2;
                while ((n2 = inputStream.read(byArray, 0, 4096)) != -1) {
                    byteArrayOutputStream.write(byArray, 0, n2);
                }
                byArray2 = byteArrayOutputStream.toByteArray();
            }
            catch (Throwable throwable) {
                try {
                    try {
                        byteArrayOutputStream.close();
                    }
                    catch (Throwable throwable2) {
                        throwable.addSuppressed(throwable2);
                    }
                    throw throwable;
                }
                catch (IOException iOException2) {
                    iOException = iOException2;
                    throw iOException2;
                }
            }
            byteArrayOutputStream.close();
            return byArray2;
        }
        finally {
            if (iOException == null) {
                inputStream.close();
            } else {
                try {
                    inputStream.close();
                }
                catch (IOException iOException3) {
                    iOException.addSuppressed(iOException3);
                }
            }
        }
    }

    static {
        ClassLoader.registerAsParallelCapable();
    }
}
