package filehandling;

import java.io.File;
import java.io.IOException;

public class FileHandling {
    public static void main(String[] args) throws IOException {

        String path = "E:\\JAVA\\TapAcademyDSA\\src\\filehandling\\bbb.txt";

        File file = new File(path);

//        System.out.println(file.exists());
//        System.out.println(file.canRead());
//        System.out.println(file.getName());
//        System.out.println(file.getAbsolutePath());         //string format
//        System.out.println(file.getAbsoluteFile());       //file format
//        System.out.println(file.getParent());
//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());

        file.createNewFile();
//        file.mkdir();

//        String[] myFiles = file.list();
//        for (String myFile : myFiles){
//            System.out.println(myFile);
//        }

//        file.delete();          //deletes file or directory


    }
}
