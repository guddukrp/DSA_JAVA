package mathematics;

import java.util.Scanner;

public class HCF {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a and b");
        int a = scan.nextInt();
        int b = scan.nextInt();

        int res = hcf(a,b);
        System.out.println(res);
    }

    private static int hcf(int a, int b) {
        while(a!=0 && b!=0){
            if(a>b){
                a=a%b;
            }else{
                b=b%a;
            }
        }
        return (a!=0)?a:b;
    }

//    private static int hcf(int a, int b) { // Euclid's Algorithm
//        while (a!=b){
//            if(a>b){
//                a=a-b;
//            }else{
//                b=b-a;
//            }
//        }
//        return a;
//    }

//    private static int hcf(int a, int b) {
//        int i=Math.min(a,b);
//        for(i=i;i>1;i--){
//            if(a%i==0 && b%i==0){
//                return i;
//            }
//        }
//        return i;
//    }
}
