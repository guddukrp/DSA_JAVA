//span = max-min;

package array;
import java.util.Scanner;

public class SpanOfArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        int max=arr[0];
        int min = arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]<min){
                min=arr[i];
            }else if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("span = "+(max-min));
    }
}
