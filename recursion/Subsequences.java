//2^n sub subsequences present

package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Subsequences {

    static ArrayList<String> al = new ArrayList<>();

    private static void printAllSubsequence(String s,String ans) {

        if(s.length()==0){
            System.out.println(ans);
            al.add(ans);
            return ;
        }
        //pick first char   (bc,a)
        printAllSubsequence(s.substring(1),ans+s.charAt(0));

        //not pick first char   (bc , "")
        printAllSubsequence(s.substring(1),ans);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        String s = scan.next();

        String s= "abc";
        printAllSubsequence(s,"");

        System.out.println(al);
    }


}
