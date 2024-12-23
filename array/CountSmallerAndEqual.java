/*count the smallest and equal element in sorted array
algo
1.perform binary serch
2.if key found check for duplicates return mid+1;
3. if key not found return mid;or high+1;


 */
package array;

import java.util.Scanner;

public class CountSmallerAndEqual {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        int k = scan.nextInt();
        int ans = countSmaller(arr, k);
        System.out.println(ans);


    }

    private static int countSmaller(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==k){
                while(mid+1<arr.length && arr[mid+1]==k ){
                    mid++;
                }
                break;

            }else if(arr[mid]<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        if(arr[mid]>k){          //if element not found
            return mid;
        }else{
            return mid+1;         //duplicate and unique element found
        }

    }
}
