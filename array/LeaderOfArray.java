//Leader is greater of his all right element

package array;

import java.util.Scanner;

public class LeaderOfArray {
    public static void leader(int [] arr){
        int leader = arr[arr.length-1];
        System.out.println(leader);
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>leader){
                leader=arr[i];
                System.out.println(leader);
            }
        }
    }

//    public static void leader(int[] arr){
//        for(int i=0;i<arr.length;i++){
//            boolean flag=true;
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[j]>=arr[i]){
//                    flag=false;
//                    break;
//                }
//            }
//            if(flag){
//                System.out.print(arr[i]+" ");
//            }
//        }
//    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        leader(arr);
    }
}
