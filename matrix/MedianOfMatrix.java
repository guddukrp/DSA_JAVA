package matrix;

public class MedianOfMatrix {

    static int findCount(int[] arr,int k){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
    static int findMedian(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;

        int min = mat[0][0];
        int max = mat[0][0];
        int medianPos=(row*col+1)/2;

        for(int i=0;i<row;i++){         //find min for mat
            if(mat[i][0]<min){
                min=mat[i][0];
            }
            if(mat[i][col-1]>max){      //find max for all elements of mat
                max=mat[i][col-1];
            }
        }
        

        while(min < max){
            int mid=(min+max)/2;
            int count=0;
            for(int i=0;i<row;i++){
                int x = findCount(mat[i],mid);
                count=count+x;
            }
            if(count<medianPos){
                min = mid+1;
            }else{
                max=mid;
            }

        }
        return min;
    }
    public static void main(String[] args) {
        int[][] mat =   {{5,11,20,35,45},
                {1, 2, 3, 4, 6},
                {13,15,16,19,21}};

        int median=findMedian(mat);
        System.out.println(median);
    }
}
