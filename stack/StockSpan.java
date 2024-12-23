
//input: 12 14 10 15 6 10
//output:1  2   1  4 1  2   count contineous lesser at left
package stack;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        stockspan(arr);
    }

    private static void stockspan(int[] arr) {

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                System.out.print(i+1+" ");
            }else{
                System.out.print(i-st.peek()+" ");
            }
            st.push(i);
        }
    }


//    private static void stockspan(int[] arr) {
//        Stack<Integer> st = new Stack<>();
//        for(int i=0;i<arr.length;i++){
//            int span=1;
//            for(int j=i-1;j>=0 && arr[j]<arr[i];j--){
//                span++;
//            }
//            System.out.print(span+" ");
//        }
//
//    }
}
