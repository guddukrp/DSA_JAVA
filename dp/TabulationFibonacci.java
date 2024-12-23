package dp;

public class TabulationFibonacci {          //Bottom Up Approach

    static int fibo(int n,int[] arr){
        arr[1]=1;
        arr[2]=1;
        for(int i=3;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
    public static void main(String[] args) {
        int n=10;
        int[] arr = new int[n+1];

        for(int i=1;i<=n;i++)
            System.out.println(fibo(i,arr));
    }
}
