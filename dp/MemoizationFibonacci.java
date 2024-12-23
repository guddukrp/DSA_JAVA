package dp;

public class MemoizationFibonacci {    //Top Down Approach

    public static void main(String[] args) {
        int n=10;
        int[] arr = new int[11];
        for(int i=1;i<n;i++)
            System.out.println(fibo(i,arr));
    }

    static int fibo(int n,int[] arr){
        if(arr[n]==0) {
            if (n == 1 || n == 2) {
                arr[n] = 1;
            } else {
                arr[n] = fibo(n - 1,arr) + fibo(n - 2,arr);
            }
        }
        return arr[n];
    }

}
