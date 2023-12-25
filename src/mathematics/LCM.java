package mathematics;

import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a and b");
        int a = scan.nextInt();
        int b = scan.nextInt();

        int res = lcm(a,b);
        System.out.println(res);
    }

    private static int gcd(int a, int b) {
        return (b==0)?a:gcd(b,a%b);
    }
    private static int lcm(int a, int b) {
        return (a*b)/gcd(a,b);
    }
}
