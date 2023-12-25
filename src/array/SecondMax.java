package array;

import java.util.Scanner;

public class SecondMax {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }

        int largest=arr[0];
        int second=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                second = largest;
                largest=arr[i];
            }else if (arr[i]>second && arr[i]<largest){
                second=arr[i];
            }
        }
        if(second==Integer.MIN_VALUE){
            System.out.println("No second largest present");
        }else
        System.out.println(second);
    }
}
