package array;

import java.util.Scanner;

public class InverseOfArray {
    public static void inverse(int[] arr){
        int[] arr2= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            arr2[arr[i]]=i;
        }

        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        inverse(arr);
    }
}
