package mathematics;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number to find factorial");
        int n= scan.nextInt();
        int ans =factorial(n);
        System.out.println(ans);
    }

    private static int factorial(int n) {
        if(n==1){
            return 1;
        }else{
            return n* factorial(n-1);
        }
    }
}
