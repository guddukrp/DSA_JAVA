package dp;

public class FrogJump12 {
    static int jump(int n,int[] arr){
        if(arr[n]==0){
            if(n==1||n==2){
                arr[n]=n;
            }else{
                arr[n]=jump(n-1,arr)+jump(n-2,arr);
            }
        }
        return arr[n];
    }
    public static void main(String[] args) {
        int n=7;
        int[] arr=new int[n+1];
        System.out.println(jump(n,arr));
    }

//    static int jump(int n){
//        if(n==1){
//            return 1;
//        }else if(n==2){
//            return 2;
//        }else{
//            return jump(n-1)+jump(n-2);
//        }
//    }
}
