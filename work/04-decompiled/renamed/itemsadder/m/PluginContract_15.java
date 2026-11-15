package itemsadder.m;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
public @interface PluginContract_15 {
    public int Gu();

    public String Gv() default "";

    public int Gw() default 0;
}
