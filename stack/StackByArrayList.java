package stack;


import java.util.ArrayList;

class StackUnderFlowException extends Exception{
    public StackUnderFlowException(){
        super("No element in Stack");
    }
}

class Stack1{
    ArrayList<Integer> ar;
    int top;
    public Stack1() {
         ar= new ArrayList<Integer>();
        top=-1;
    }

    void print(){
        for(int i:ar){
            System.out.print(i+" ");
        }
    }
    void push(int e){
        top++;
        ar.add(e);
    }
    int pop() throws StackUnderFlowException{
        if(ar.size()==0){
            throw new StackUnderFlowException();
        }else{
            int temp= ar.get(ar.size() - 1);
            ar.remove(ar.size()-1);
            top--;
            return temp;
        }
    }
    int size(){
        return ar.size();
    }
}

public class StackByArrayList {
    public static void main(String[] args) throws StackUnderFlowException {

        Stack1 s = new Stack1();
        s.push(10);
        s.push(20);
        s.push(30);


        s.print();

//        System.out.println(s.pop());
//        System.out.println(s.pop());
//        System.out.println(s.pop());
        System.out.println(s.size());
    }
}
