package matrix;

import java.util.Scanner;

public class ZigZag {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=scan.nextInt();
            }
        }

        for(int i=0;i<n;i++){
            if(i%2==0){
                for(int j=0;j<n;j++){
                    System.out.print(arr[i][j]+" ");
                }
            }else {
                for (int j = n-1; j >=0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();

        }
    }
}
