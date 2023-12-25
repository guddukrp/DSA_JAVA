package array;

import java.util.Scanner;

public class FirstAndLastOccurance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        firstAndLast(arr,k);
    }

    private static void firstAndLast(int[] arr, int k) {

        int low=0;
        int high=arr.length-1;
        int mid=0;

        int l=-1;
        int r=-1;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==k){
                r=mid;
                l=mid;
                while(r+1<arr.length && arr[r+1]==k){
                    r=r+1;
                }
                while(l-1>=0 && arr[l-1]==k){
                    l=l-1;
                }
                break;
            }else if(arr[mid]<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        System.out.println("left index "+l);
        System.out.println("right index "+r);
    }
}
