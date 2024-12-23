package sorting_searching;
//int bubble sort we swap the adjecent elements only
// swaping happens size-1 times
public class BubbleSort {
    static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            boolean swapped = false;
            for(int j=0;j<n-1-i;j++){        // -i is used to optimization
                if(arr[j]>arr[j+1]){
                    int t =arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]= t;
                    swapped=true;
                }
            }
            if(swapped==false){
//                break;
                return;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {2,3,5,4,1,7};

        bubbleSort(arr);
        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+" ");
    }
}
