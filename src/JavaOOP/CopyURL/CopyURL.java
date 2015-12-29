package JavaOOP.CopyURL;


import java.io.InputStream;
import java.net.URL;

public class CopyURL {
    public static void main(String[] args) {
        try {
            InputStream is = new URL("https://www.youtube.com").openStream();
            long startTime = System.currentTimeMillis();
            while (is.read() != -1){
                long stopTime = System.currentTimeMillis();
                System.out.println(" Elapsed time = " + (stopTime - startTime));
                //startTime=stopTime;
                // make threads!!!!!!!!!!!!!!!
            }
        }catch (Exception e){
            System.out.println(e.getCause().toString());
        }
    }
}
