package JavaPro.Lection_2_18012016.ClassWork.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.RandomAccessFile;

/**
 * Created by administrator on 24.01.16.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        byte[] buf;

        RandomAccessFile f = new RandomAccessFile("/home/administrator/Рабочий стол/Out/json.txt", "r");
        try {
            buf = new byte[(int) f.length()];
            f.read(buf);

            String result = new String(buf);

            Gson gson = new GsonBuilder().create();

            Person person = gson.fromJson(result, Person.class);

            System.out.print(person.name);
            System.out.print(person.address.city);
            System.out.print(" ");
            System.out.println(person.surname);
            System.out.println("Phones: ");
            for (String p : person.phones) {
                System.out.println(p);
            }
            for (String s : person.sites
                    ) {
                System.out.println(s);
            }
            System.out.print("Country: ");
            System.out.println(person.address.country);
            System.out.print("City: ");
            System.out.println(person.address.city);
            System.out.print("Street: ");
            System.out.print(person.address.street);

        } catch (Exception e) {
            e.getCause();
        }
    }
}
