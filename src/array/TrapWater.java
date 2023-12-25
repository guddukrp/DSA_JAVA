package array;

import java.util.Scanner;

public class TrapWater {
    public static int[] leftMax(int[] arr){
        int[] lm=new int[arr.length];
        lm[0]=arr[0];
        for(int i=1;i< arr.length;i++){
            lm[i]=Math.max(arr[i],lm[i-1]);
        }
        return lm;
    }
    public static int[] rightMax(int[] arr){
        int[] rm=new int[arr.length];
        rm[arr.length-1] =arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            rm[i]=Math.max(arr[i],rm[i+1]);
        }
        return rm;
    }
    public static void trapWater(int[] arr){
        int n=arr.length;
        if(n<3) System.out.println(0);
        int[] leftMax= leftMax(arr);
        int[] rightMax=rightMax(arr);

        int sum=0;
        for(int i=0;i<n;i++){
            int temp= Math.min(leftMax[i],rightMax[i]);
                sum+=temp-arr[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        trapWater(arr);
    }
}
