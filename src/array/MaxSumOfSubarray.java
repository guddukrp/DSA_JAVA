package array;

import java.util.Scanner;

public class MaxSumOfSubarray {
    static void sumOfSubarray(int[] arr){
        int sum=arr[0];
        int maxSum=arr[0];
        for (int i=1;i<arr.length;i++){
            if(sum>=0){
                sum+=arr[i];
            }else{
                sum=arr[i];
            }
            maxSum=Math.max(sum,maxSum);
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
        sumOfSubarray(arr);
    }


//    static void sumOfSubarray(int[] arr){
//        int ans=Integer.MIN_VALUE;
//        for(int i=0;i<arr.length;i++){
//            for(int j=i;j<arr.length;j++){
//                int sum=0;
//                for(int k=i;k<=j;k++){
//                    sum+=arr[k];
//                }
//                ans=Math.max(sum,ans);
//            }
//        }
//        System.out.println(ans);
//    }
}
