package recursion;

public class SumOfArrayElements {
    static int sum(int[] arr,int i){
        if(i==arr.length){
            return 0;
        }else{
            return sum(arr,i+1)+arr[i];
        }
    }
    public static void main(String[] args) {

        int arr[]={1,2,3,4,5};
        int res = sum(arr,0);
        System.out.println(res);
    }
}
