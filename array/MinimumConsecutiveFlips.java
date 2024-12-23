package array;

import java.util.Scanner;

public class MinimumConsecutiveFlips {
    static void flips(int[] arr){

        for(int i=1;i<arr.length;i++){

            if(arr[i]!=arr[i-1]){
                if(arr[0] != arr[i]){               //1100110011
                    System.out.print(i+"-");
                }else{
                    System.out.println(i-1);
                }
            }
        }
        if(arr[0]!=arr[arr.length-1]){           //if groups are equals;  00110011
            System.out.println(arr.length-1);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }

        flips(arr);


    }
}
