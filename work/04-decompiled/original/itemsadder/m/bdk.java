package itemsadder.m;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.SOURCE)
public @interface bdk {
    public boolean DF() default true;

    public boolean DG() default true;

    public boolean DH() default true;
}
