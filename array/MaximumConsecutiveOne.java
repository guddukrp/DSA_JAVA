package array;

import java.util.Scanner;

public class MaximumConsecutiveOne {

    static void consecutiveOne(int[] arr){
        int count=0;
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                count++;
                ans=Math.max(count,ans);
            }else{
                count=0;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        consecutiveOne(arr);
    }
}
