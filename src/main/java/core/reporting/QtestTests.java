package core.reporting;

import java.lang.annotation.*;

/**
 * Created by Vladimir Garkin on 2/23/18
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface QtestTests {
    String[] value();
}