package JavaOOP.CopyFile;

import java.io.*;
import java.util.Scanner;


public class CopyFile {

    private static int BUFSIZE = 1024;
    Scanner scanner;


    public void copy(){

//        System.out.println("Enter from:"); //   /home/administrator/Рабочий стол/Out/1.txt
//        scanner = new Scanner(System.in);
//        String from = scanner.nextLine();
//
//        System.out.println("Enter to:");  //     /home/administrator/Рабочий стол/In/1.txt
//        scanner = new Scanner(System.in);
//        String to = scanner.nextLine();

        String from = "/home/administrator/Рабочий стол/Out/1.txt";
        String to = "/home/administrator/Рабочий стол/In/1.txt";

        long start = System.currentTimeMillis();

 try {

     InputStream is = new FileInputStream(from);
     OutputStream os = new FileOutputStream(to);
     byte[] buf = new byte[BUFSIZE];
     int n;
     while ((n = is.read(buf)) > 0)
         os.write(buf, 0, n);
     os.flush();
     os.close();
     is.close();

 }catch (IOException e){
     System.out.println(e.getCause().toString());
 }
        long end = System.currentTimeMillis();
        System.out.print("Time: ");
        System.out.print(end-start);
    }

    public static void main(String[] args) {
        CopyFile c = new CopyFile();
        c.copy();
    }

}
