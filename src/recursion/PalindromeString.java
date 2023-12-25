package recursion;

public class PalindromeString {
//    static boolean checkPalindrome(String s,String r,int i){
//        if(i<0){
//            return (s.equals(r));
//        }else{
//            return checkPalindrome(s,r+s.charAt(i),i-1);
//        }
//    }

    static  boolean checkPalindrome(String s, int i,int j){
        if(i>=j){
            return true;
        }else if(s.charAt(i)!=s.charAt(j)){
            return false;
        }else{
            return checkPalindrome(s,i+1,j-1);
        }
    }
    public static void main(String[] args) {

        String s= "abba";
//        boolean res=checkPalindrome(s,"",s.length()-1);

        boolean res = checkPalindrome(s,0,s.length()-1);


        System.out.println(res);
    }
}
