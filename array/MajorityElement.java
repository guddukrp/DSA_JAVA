package array;

import java.util.Scanner;

public class MajorityElement {
    static void majority(int[] arr){
        int major=arr[0];
        int count=1;
        for (int i=0;i<arr.length;i++){
            if(arr[i]==major){
                count++;
            }else {
                count--;
            }
            if(count==0){
                major=arr[i];
                count=1;
            }
        }
        System.out.println(major);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        majority(arr);
    }
}
