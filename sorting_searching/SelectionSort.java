package sorting_searching;

public class SelectionSort {
    static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            int min_ind = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min_ind]){
                    min_ind=j;
                }
            }
            int t= arr[i];
            arr[i]=arr[min_ind];
            arr[min_ind]=t;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,4,5,1,3,8};
        selectionSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
