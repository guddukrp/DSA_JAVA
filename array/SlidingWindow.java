package array;

import java.util.Scanner;

public class SlidingWindow {
    static void sumOfSubarray(int arr[],int k){
        int maxSum=0;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        for(int i=k;i<arr.length;i++){
            sum += arr[i]-arr[i-k];
            maxSum= Math.max(sum,maxSum);
        }
        System.out.println(maxSum);

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        sumOfSubarray(arr,3);
    }
}
