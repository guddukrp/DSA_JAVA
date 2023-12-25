//Can it be broken down to smaller problem
//Are the results dependent on each other
//Does it have a base condition

//recurstion is possible

package recursion;

public class Fibonacci {
    static int fib(int n){
        if(n==1 ||n ==2){
            return 1;
        }else{
            return fib(n-1)+fib(n-2);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(6));
    }
}
