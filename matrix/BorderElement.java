package matrix;

import java.util.Scanner;

public class BorderElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=scan.nextInt();
            }
        }
        int i=0;
        int j=0;
        for(j=0;j<n;j++){
            System.out.print(arr[i][j]+" ");
        }
        j=n-1;
        for(i=1;i<n;i++){
            System.out.print(arr[i][j]+" ");
        }
        i=n-1;
        for(j=n-2;j>=0;j--){
            System.out.print(arr[i][j]+" ");
        }
        j=0;
        for(i=n-2;i>0;i--){
            System.out.print(arr[i][j]+" ");
        }
    }
}
