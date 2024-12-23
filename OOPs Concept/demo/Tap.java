package demo;

import java.util.Scanner;

public class Tap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        printOddIndexElements(arr);
    }

    public static void printOddIndexElements(int[] arr) {
    	int sum=0;
       for(int i=0;i<arr.length;i++){
        sum+=arr[i];
       }
       int result=Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++) {
    	   int ans= sum-arr[i];
    	   result=Math.max(ans, result);
       }
       System.out.print(result);
    }
}