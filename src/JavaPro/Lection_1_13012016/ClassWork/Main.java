package JavaPro.Lection_1_13012016.ClassWork;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        /*if "sum" in Foo is no static*/ Foo foo = new Foo();
        Class<?> cls = Foo.class;

        Method[] methods =cls.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)){
                Test test = m.getAnnotation(Test.class);
                int res = (Integer)m.invoke(/*null*/foo, test.a(), test.b());
                System.out.println(res);
            }

        }

    }
}
