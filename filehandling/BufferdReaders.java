package filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferdReaders {
    public static void main(String[] args) throws IOException {

        String path=  "E:\\JAVA\\TapAcademyDSA\\src\\filehandling\\abc.txt";
        FileReader reader = new FileReader(path);
        BufferedReader reader2 = new BufferedReader(reader);
        int count=0;

        String line = reader2.readLine();
        while(line!=null){
            count++;
            System.out.println(line);
             line = reader2.readLine();
        }
        System.out.println(count);

    }
}
