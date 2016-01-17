package JavaPro.FirstLection_13012016.HomeWork.Task_2;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)

public @interface SaveTo {
    String path();
}


