package sorting_searching;

public class InsertionSort {
    static  void insertionSort(int[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int key= arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,1,3};
        insertionSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
