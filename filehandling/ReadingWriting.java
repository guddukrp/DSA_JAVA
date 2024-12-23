package filehandling;

import java.io.*;

public class ReadingWriting {
    public static void main(String[] args) throws IOException {

        String path =   "E:\\JAVA\\TapAcademyDSA\\src\\filehandling\\aaa.txt";
        String path2=  "E:\\JAVA\\TapAcademyDSA\\src\\filehandling\\bbb.txt";
        String path3=  "E:\\JAVA\\TapAcademyDSA\\src\\filehandling\\ccc.txt";

        FileReader reader = new FileReader(path);
        BufferedReader reader11 = new BufferedReader(reader);
        String line1 = reader11.readLine();

        FileReader reader2 = new FileReader(path2);
        BufferedReader reader22 = new BufferedReader(reader2);
        String line2 = reader22.readLine();


        FileWriter writer = new FileWriter(path3);


        while(line1!=null){
            writer.write(line1+" : "+line2+"\n");
//            System.out.println(line1+" : "+line2);
            line1 = reader11.readLine();
            line2= reader22.readLine();
        }
        writer.flush();



    }
}
