package mathematics;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = scan.nextInt();


            System.out.println(chekPrime(n)?"Yes":"No");

//        if(chekPrime(n)){
//            System.out.println("Yes");
//        }else {
//            System.out.println("NO");
//        }
    }

    private static boolean chekPrime(int n) {
        if(n<=1) return false;
        if(n<=3) return true;
        if(n%2==0 || n%3==0){
            return false;
        }

        for(int i=5;i*i<=n;i=i+6){
            if(n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }
}
