/*bitonic array is conntineous increasing and contineous decreasing elements
       Ex: 1,3,5,8,5,2,1
        bitonic element =8
        bitonic index=3;
search an element in a bitonic array;
//

algo
1.find the point where the array can be split(bitonic point)
2.check if the element is at the bitonic point, If yes return the bitonic point
3.Otherwise perform the binary search on left and right side
 of the bitonic point using binary search
*/
package array;

import java.util.Scanner;

public class BitonicArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        int k= scan.nextInt();

        int biIndex = bitonicIndex(arr);
        System.out.println("Bitonic index is "+biIndex);
        if(arr[biIndex]==k){
            System.out.println(biIndex);
            return ;
        }

        if(k>arr[biIndex]){
            System.out.println("element not present");
            return;
        }

        int ascBinary = ascendingBinarySearch(arr,k,biIndex-1);
        if(ascBinary!=-1){
            System.out.println(ascBinary);
            return;
        }
        int dscBinary = decendingBinarySearch(arr,k,biIndex+1);
        if(dscBinary!=-1){
            System.out.println(dscBinary);
            return ;
        }
        System.out.println("element not found");



    }

    private static int decendingBinarySearch(int[] arr, int k, int biIndex) {
        int low=biIndex;
        int high=arr.length-1;
        int mid=0;
        while (low<=high){
            mid=(low+high)/2;
            if(arr[mid]==k){
                return mid;
            }else if(arr[mid]<k){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }

    private static int ascendingBinarySearch(int[] arr, int k, int biIndex) {
        int low = 0;
        int high=biIndex;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==k){
                return mid;
            }else if(arr[mid]<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }


    private static int bitonicIndex(int[] arr) {
        int low=0;
        int high=arr.length-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]>arr[mid-1]&& arr[mid]>arr[mid+1]){
                return mid;
            }else if(arr[mid]>arr[mid-1]&&arr[mid]<arr[mid+1]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
