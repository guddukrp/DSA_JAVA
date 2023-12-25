package mathematics;

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        long n = scan.nextLong();
        long ans = countDigits(n);
        System.out.println(ans);
    }

    private static int countDigits(long n) {
        int count=0;
        while(n>0){
            count++;
            n=n/10;
        }
        return count;
    }
}
