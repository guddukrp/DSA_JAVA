package filehandling;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriters {
    public static void main(String[] args) throws FileNotFoundException {
        String path=  "E:\\JAVA\\TapAcademyDSA\\src\\filehandling\\abc.txt";
        PrintWriter writer = new PrintWriter(path);
        float f = 20f;
        int n = 65;
        writer.println("India");
        writer.println(f);
        writer.println(56);
        writer.flush();


    }
}
