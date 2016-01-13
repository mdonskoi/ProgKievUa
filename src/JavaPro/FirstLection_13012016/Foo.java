package JavaPro.FirstLection_13012016;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Foo {
    @Test(a = 10, b = 12)
    public /*static*/ int sum(int a, int b){
        return a+b;
    }
}
