package JavaPro.FirstLection_13012016.HomeWork.Task_2;

import java.io.File;
import java.io.FileOutputStream;

@SaveTo(path="/home/administrator/Рабочий стол/In/")
public class TextContainer {

    String text = "aaa";
    @StringSaver
    public void save(){
        File file = new File("text.txt");
        try {
            FileOutputStream os = new FileOutputStream(file);
        }catch (Exception e){
            System.out.println(e.getCause().toString());
        }
    }

}
