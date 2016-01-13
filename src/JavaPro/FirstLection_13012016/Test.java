package JavaPro.FirstLection_13012016;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Test {
    int a();
    int b();
}
