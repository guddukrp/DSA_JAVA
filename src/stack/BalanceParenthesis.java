package stack;

import java.util.Scanner;
import java.util.Stack;

public class BalanceParenthesis {
    static boolean checkBalance(String str){

        Stack<Character> s = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);
            if( ch=='('||ch=='{'||ch=='['){
                s.push(ch);
            }else if(s.isEmpty()){
                return false;
            }
            else if ((ch==')'&& s.peek()=='(')||(ch=='}'&& s.peek()=='{')||(ch==']'&& s.peek()=='[')){
                s.pop();
            }else {
                return false;
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        System.out.println(checkBalance(str));

  }
}
