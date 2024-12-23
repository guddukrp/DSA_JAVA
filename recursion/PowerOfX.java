package recursion;

public class PowerOfX {

    static long power(long x, long n){
        if(n==0){
            return 1;
        }
        if(n%2==0){
            long res=power(x,n/2);
            return res*res;

//            return power(x,n/2)*power(x,n/2);
        }else{
            return power(x,n-1)*x;
        }
    }

    public static void main(String[] args) {

        int x = 10;
        int n=5;
        long ans = power(x,n);
        System.out.println(ans);
    }
//    static int power(int x,int n){
//        if(n==0){
//            return 1;
//        }
//        return  x*power(x,n-1);
//    }
}
