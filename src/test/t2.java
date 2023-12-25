package test;

import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {

        int[] arr = {5,6,1,2,3,8,9,4,3};
        int left=0;
        int right=0;


        int ans =1;
        for(int i=0;i<arr.length;i++){
            int count=1;
            for(int j=i;j<arr.length-1;j++){
                if(arr[j]<arr[j+1]){
                    count++;
                }else{
                    if(count>ans){
                        ans=count;
                        left=i;
                        right=j+1;
                    }
                    break;
                }
            }
        }
        for(int i=left;i<right;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
