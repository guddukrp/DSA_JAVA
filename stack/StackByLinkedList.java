package stack;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}
class Stack2{
    Node top;
    int size;                       //
    public Stack2(){
        top=null;
        size=0;
    }
    void print(){
        Node curr=top;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    void push(int e){
        Node temp = new Node(e);
        temp.next=top;
        top=temp;
        size++;                         //
    }
    int pop() throws StackUnderFlowException{
        if(top==null){
            throw new StackUnderFlowException();
        }else{
            int t = top.data;
            top=top.next;
            size--;                     //
            return t;
        }
    }
    int size(){
        return size;                    //

//        Node curr=top;
//        int count=0;
//        while(curr!=null){
//            count++;
//            curr=curr.next;
//        }
//        return count;
    }
    int peek() throws StackUnderFlowException{
        if(top==null) {
            throw new StackUnderFlowException();
        }else{
            return top.data;
        }
    }
    boolean isEmpty(){
        return top==null;
//        return top==null?true:false;
    }

}
public class StackByLinkedList {
    public static void main(String[] args) throws StackUnderFlowException {

        Stack2 st = new Stack2();
        st.push(10);
        st.push(20);
        st.push(30);

        st.print();
//        System.out.println(st.pop());
//        System.out.println(st.pop());
//        System.out.println(st.pop());

//        System.out.println(st.size());
//        System.out.println(st.peek());

        System.out.println(st.isEmpty());
    }
}
