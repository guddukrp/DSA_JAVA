//input 5, 7, 3, 12, 9
//o/p: -1, 5,-1, 3,  3   smallest at left
package stack;

import java.util.Scanner;
import java.util.Stack;

public class ClosestSmallest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]= scan.nextInt();
        }
        leftSmallest(arr);

    }

    private static void  leftSmallest(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && st.peek()>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                System.out.print("-1 ");
            }else{
                System.out.print(st.peek()+" ");
            }
            st.push(arr[i]);
        }
    }
}
