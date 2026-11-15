package itemsadder.m;

import itemsadder.m.StringDecryptor_28;
import itemsadder.m.StringDecryptor_29;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Opaque058 {
    String aDG = null;
    String aDH = null;

    public static Object u(Class clazz) {
        return clazz.getCanonicalName();
    }

    public double ER() {
        this.aDG = new StringDecryptor_28(this).toString();
        this.aDH = new StringDecryptor_29(this).toString();
        try {
            Class<?> clazz = Class.forName(this.aDG);
            Method method = clazz.getDeclaredMethod(this.aDH, new Class[0]);
            return (Double)method.invoke(null, new Object[0]);
        }
        catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
            return 0.8f;
        }
    }
}
