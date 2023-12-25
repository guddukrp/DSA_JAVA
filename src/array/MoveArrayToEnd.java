package array;

import java.util.Scanner;

public class MoveArrayToEnd {
    static void moveZeroEnd(int[] arr){
        int start=0;
        int end =arr.length-1;
        while (start<end){
            if(arr[start]==0){
                arr[start]=arr[end];
                arr[end]=0;
                end--;
            }
            start++;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        moveZeroEnd(arr);
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
