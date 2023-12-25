package mathematics;

import java.util.Scanner;

public class TrailingZeros {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter a number");
        long n = scan.nextLong();
        int res = trailingZeros(n);
        System.out.println(res);
    }

    private static int trailingZeros(long n) {
        int res=0;
        int powOf5=5;
        while(n>=powOf5){
            res += n/powOf5;
            powOf5 = powOf5*5;
        }
        return res;
    }

//    private static int trailingZeros(long n) {
//        int count2=0;
//        int count5=0;
//        for(int i=1;i<=n;i++){
//            int t=i;
//            while(t%2==0){
//                count2++;
//                t=t/2;
//            }
//            t=i;
//            while(t%5==0){
//                count5++;
//                t=t/5;
//            }
//        }
//        return Math.min(count2,count5);
//    }
}
