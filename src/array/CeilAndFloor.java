package array;

import java.util.Scanner;

public class CeilAndFloor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        int k= scan.nextInt();

        ceilandFloor(arr, k);

    }

//for sorted array
    private static void ceilandFloor(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==k){
                System.out.println("ceil "+arr[mid]);
                System.out.println("floor "+arr[mid]);
                return ;
            }else if(arr[mid]<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        if(arr[arr.length-1]<k) {                   //if(low>arr.length)
            System.out.println("no ceil available");
        }else{
            System.out.println("ceil = " + arr[low]);
        }
        if(arr[0]>k){                               //if(high<0)
            System.out.println("no floor available");
        }else {
            System.out.println("floor= " + arr[high]);
        }
    }

    //for unsorted array

//    private static void ceilandFloor(int[] arr,int k) {
//        int ceilAns=Integer.MAX_VALUE;
//        int floorAns=Integer.MIN_VALUE;
//        for(int i=0;i<arr.length;i++){
//            if(arr[i]==k){
//                ceilAns=k;
//                floorAns=k;
//                break;
//            }else if(arr[i]>k && arr[i]<ceilAns){
//                ceilAns=arr[i];
//            }else if(arr[i]<k && arr[i]>floorAns){
//                floorAns=arr[i];
//            }
//        }
//        System.out.println("ceil "+ceilAns);
//        System.out.println("floor "+floorAns);
//    }
}
