package array;

import java.util.Scanner;

public class EvenOddSubarray {

    static void evenOddSub(int[] arr){
        int count=1;
        int ans=1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]%2==0 && arr[i+1]%2!=0  ||  arr[i]%2!=0 && arr[i+1]%2==0){
                count++;
            }else{
                count=1;
            }
            ans=Math.max(ans,count);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        evenOddSub(arr);
    }
}
