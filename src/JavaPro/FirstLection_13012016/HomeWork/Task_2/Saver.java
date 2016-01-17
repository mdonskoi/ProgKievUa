package JavaPro.FirstLection_13012016.HomeWork.Task_2;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Saver {

    public void save(){
        File file = new File("/home/administrator/Рабочий стол/In/text.txt");
        try {
            FileOutputStream os = new FileOutputStream(file);
        }catch (Exception e){
            System.out.println(e.getCause().toString());
        }
    }
}
