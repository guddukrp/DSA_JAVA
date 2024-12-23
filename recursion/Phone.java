package recursion;

public class Phone {
     static String[] keypad= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
     static  void possibleWords(String s,String ans){

         if(s.length()==0){
             System.out.println(ans);
             return;
         }
         String key = keypad[s.charAt(0)-48];
         possibleWords(s.substring(1),ans+key.charAt(0));
         possibleWords(s.substring(1),ans+key.charAt(1));
         possibleWords(s.substring(1),ans+key.charAt(2));
     }



    public static void main(String[] args) {


        String s="23";
        possibleWords(s,"");


    }
}
