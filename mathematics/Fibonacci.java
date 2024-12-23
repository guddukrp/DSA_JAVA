package mathematics;

public class Fibonacci {
    static int fibo(int n){
        int a=1;
        int b=1;
        if(n==1||n==2) return 1;

        for(int i=3;i<=n;i++){
            int t=a;
            a=b;
            b=t+b;
        }
        return b;
    }
    public static void main(String[] args) {
        int n=10;
        for (int i=1;i<=n;i++)
        System.out.println(fibo(i));
    }
}
