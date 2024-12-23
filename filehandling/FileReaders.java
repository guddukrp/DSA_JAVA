package filehandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaders {
    public static void main(String[] args) throws IOException {

        String path = "E:\\JAVA\\TapAcademyDSA\\src\\filehandling\\abc.txt";

        FileReader reader = new FileReader(path);

//        System.out.println((char) reader.read());        //give int value of first char

//        char[] arr= new char[15];
//        System.out.println(reader.read(arr));      //length of chars available in file
//        System.out.print(arr);                      //print array of chars

        FileWriter writer = new FileWriter("E:\\JAVA\\TapAcademyDSA\\src\\filehandling\\aaa.txt");

        int  c = reader.read();
        while(c!=-1){
            System.out.print((char)c);
            writer.write(c);                        //auto convert to int to char then store
            c = reader.read();
        }
        writer.flush();











    }
    }
