package recursion;

public class PrintBalancePrenthesis {
    static void balanced(char arr[],int n,int i,int o, int c){
        if(i==arr.length){
            System.out.println(arr);
        }
        if(o<n){
            arr[i]='(';
            balanced(arr,n,i+1,o+1,c);
        }
        if(c<o){
            arr[i]=')';
            balanced(arr,n,i+1,o,c+1);
        }
    }
    public static void main(String[] args) {

        int n=10;
        char[] arr = new char[2*n];
        balanced(arr,n,0,0,0);
    }
}
