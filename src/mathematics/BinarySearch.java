package mathematics;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        int k= scan.nextInt();

        int ans = binarySearch(arr,k);
        System.out.println(ans);
    }

    private static int  binarySearch(int[] arr, int k) {

        int low = 0 ;
        int high=arr.length-1;
        while(low<high){
            int mid=(low+high)/2;
            if(arr[mid]==k){
                return mid;
            }else if(arr[mid]<k){
                low=mid+1;
            }else{
                high= mid-1;
            }
        }
        return -1;
    }
}
