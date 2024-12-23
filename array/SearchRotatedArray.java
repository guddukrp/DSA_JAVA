package array;

import java.util.Scanner;

public class SearchRotatedArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        int res = search(arr, k);
        System.out.println(res);
    }

    private static int search(int[] arr, int k) {
        int l=0;
        int r=arr.length-1;
        int mid=0;
        while(l<=r){
            mid=(l+r)/2;
            if(arr[mid]==k){
                return mid;
            }else if(arr[l]<arr[mid]){
                if(arr[l]<=k && k<arr[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(arr[r]>=k &&  arr[mid]<k){
                    l=mid+1;
                }else{
                    r=mid-1;
                }

            }
        }
        return -1;
    }
}
