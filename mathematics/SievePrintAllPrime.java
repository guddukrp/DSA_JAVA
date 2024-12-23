package mathematics;

import java.util.Scanner;

public class SievePrintAllPrime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        printAllPrime(n);
    }

    private static void printAllPrime(int n) {
        boolean[] arr = new boolean[n+1];
        for(int i=2;i<=n;i++){          // for(i=2;i*i<=n;i++)
            if(arr[i]==false){          //first mul is sqrt(n)
                for(int j=i*2;j<=n;j=j+i){ //for(j=i*i;j<=n;j++)
                    arr[j]=true;         //first unmark mul is of 2 is 2^2=4,(3,9)
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(arr[i]==false){
                System.out.print(i+" ");
            }
        }

    }
}
