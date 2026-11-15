package itemsadder.m;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.SOURCE)
public @interface XQFunction {
    public String xQ() default "";
}
