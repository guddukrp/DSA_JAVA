//remove duplicate without using any extra space
package array;

import java.util.Scanner;

public class RemoveDuplicates {
    static int removeDuplicates(int[] arr){
        int j=0;
        arr[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[j]){
                j++;
                arr[j]=arr[i];
            }
        }
        return j+1;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        int lastIndex=removeDuplicates(arr);
        for (int i=0;i<lastIndex;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
