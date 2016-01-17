package JavaPro.Lection_1_13012016.HomeWork.Task_2;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Saver{}

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface SaveTo{
    public String path();
}

@SaveTo(path = "/home/administrator/Рабочий стол/In/text.txt")
class TextContainer {
    String text;

    public TextContainer(String text) {
        this.text = text;
    }

    @Saver
    public void save(String fileName) throws IOException{
        FileWriter fw = new FileWriter(fileName);
        try {
            fw.write(this.text);
            System.out.println("File successfully saved."); // ToDo: Add path. (Saved to: "path")
        }
        catch (Exception e){
            System.out.println(e.getCause().toString());
        }finally {
            fw.close();
        }
    }

}


public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TextContainer tc = new TextContainer("I am a text!");
        Class<?> cl = tc.getClass();
        if (cl.isAnnotationPresent(SaveTo.class)){
            Method[] methods = cl.getMethods();
            for (Method method : methods) {
                SaveTo ann = cl.getAnnotation(SaveTo.class);
                String path = ann.path();
                if (method.isAnnotationPresent(Saver.class)){
                    method.invoke(tc, path);
                }
            }
        }else System.out.println("Class " + cl.getName() + " have no annotations.");
    }
}
