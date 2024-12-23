package recursion;

public class ReverseString {
    static String revString(String s,String r,int i){
        if(i<0){
            return r;
        }else{
            return revString(s,r+s.charAt(i),i-1);
        }
    }
    public static void main(String[] args) {

        String s="abcdef";
        String r="";
        int n=s.length()-1;
        String res=revString(s,r,n);        //(s,"",s.length()-1)
        System.out.println(res);
    }
}
