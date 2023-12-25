package test;

public class t1 {
    public static void main(String[] args) {
        int[] arr = {5,8,10,21,25,6,11};

        for(int i=0;i<arr.length-1;i++){
            int ans =-1;
            int abs=Integer.MAX_VALUE;
            for(int j=i+1;j< arr.length;j++){
                if(arr[i]<arr[j]){

                    if(ans==-1){
                        ans=arr[j];
                        abs=arr[j]-arr[i];
                    }else if(arr[j]-arr[i]<abs){
                        ans=arr[j];
                        abs= arr[j]-arr[i];
                    }

                }
            }
            System.out.print(ans+" ");

        }
        System.out.print("-1");


    }
}
