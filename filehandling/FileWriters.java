package filehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriters {
    public static void main(String[] args) throws IOException {

        String path = "E:\\JAVA\\TapAcademyDSA\\src\\filehandling\\abc.txt";
//        File file = new File(path);
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        String s3 = scan.next();

//        FileWriter writer = new FileWriter(file);
//        FileWriter writer = new FileWriter(file,true);

//        FileWriter writer = new FileWriter(path);
        FileWriter writer = new FileWriter(path,true);


        writer.write(s1);
        writer.write(s2);
        writer.write(s3);
        writer.flush();

        scan.close();
        writer.close(); 
    }
}
