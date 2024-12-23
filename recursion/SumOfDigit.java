package recursion;

public class SumOfDigit {
    static int sum(int n){
        if(n==0){
            return 0;
        }else{
            return sum(n/10)+(n%10);
        }
    }
    static int count(int n){
        if(n==0){
            return 0;
        }else{
            return count(n/10)+1;
        }
    }
    public static void main(String[] args) {

        int n=1234567;
        int ans = count(n);
        int res=sum(n);
        System.out.println(ans);
        System.out.println(res);
    }
}
