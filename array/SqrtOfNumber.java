package array;

import java.util.Scanner;

public class SqrtOfNumber {

    static int sqrt(int n){
        int left=1;
        int right=n;
        int ans=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(mid*mid==n){
                return mid;
            }else if(mid*mid<n){
                left=mid+1;
                ans=mid;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println(sqrt(n));
    }
}
