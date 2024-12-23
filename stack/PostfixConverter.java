package stack;

import java.util.Scanner;
import java.util.Stack;

public class PostfixConverter {

    private static String postfixConverter(String str) {
        Stack<Character> st= new Stack<>();
        String res = "";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(Character.isLetter(ch)==true){
                res+=ch;
            }else if(ch=='('){
                st.push(ch);
            }else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    char temp = st.pop();
                    res+=temp;
                }
                st.pop();
            }
            else {
                if( !st.isEmpty() && presedence(ch)>presedence(st.peek())){
                    st.push(ch);
                }else{
                    while(!st.isEmpty() && presedence(ch)<=presedence(st.peek()) ){
                        char temp = st.pop();
                        res+=temp;
                    }
                    st.push(ch);
                }
            }

        }
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return  res;
    }

    private static int  presedence(char ch) {
        if(ch=='^'){
            return 3;
        }else if(ch=='*' || ch =='/'){
            return 2;
        }else if(ch =='+'|| ch == '-'){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        String res = postfixConverter(str);
        System.out.println(res);
    }


}
