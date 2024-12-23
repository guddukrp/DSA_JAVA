package filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BufferdWriters {

    public static void main(String[] args) throws IOException {
        String path=  "E:\\JAVA\\TapAcademyDSA\\src\\filehandling\\abc.txt";
        FileWriter writer = new FileWriter(path);
        BufferedWriter writer2 = new BufferedWriter(writer);

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        writer2.write("India");
        writer2.write(n);               //print char A

        writer2.flush();


    }
}
