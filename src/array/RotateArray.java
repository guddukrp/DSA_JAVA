package array;

import java.util.Scanner;

public class RotateArray {
    static  void reverseArray(int arr[],int i,int j){

        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    static  void rotateArray(int[] arr,int k){
        reverseArray(arr,0,k-1);
        reverseArray(arr,k,arr.length-1);
        reverseArray(arr,0,arr.length-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        rotateArray(arr,2);
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

//    static void rotateArray(int[] arr,int k){
//        if(k>=arr.length){
//            k=k%arr.length;
//        }
//        int temp[]=new int[k];
//        for(int i=0;i<k;i++){
//            temp[i]=arr[i];
//        }
//        int p=0;
//        for(int i=k;i<arr.length;i++){
//            arr[p]=arr[i];
//            p++;
//        }
//        for(int i=0;i<k;i++){
//            arr[p]=temp[i];
//            p++;
//        }
//
//    }

}
