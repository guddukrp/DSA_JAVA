package queue;

import java.util.Stack;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
class Queue2{
    Node front;
    Node rear;
    int size;
    public Queue2(){
        this.size=0;
        this.front=null;
        this.rear=null;
    }
    void enqueue(int element){
        Node temp = new Node(element);
        if(size>0){
            rear.next=temp;
            rear=temp;
            size++;


        }else{
            front=temp;
            rear=temp;
            size++;
        }
    }
    int dequeue(){
        if(size>0){
            Node temp =front;
            front=front.next;
            temp.next=null;
            size--;
            return temp.data;

        }else{
            System.out.println("Queue is empty");
            return -1;

        }
    }
    int getFront(){
        return (front!=null)?front.data:-1;
    }
    int getRear(){
        return (rear!=null)?rear.data:-1;
    }
    boolean isEmpty(){
        if(front==null ){
            return true;
        }else{
            return false;
        }
    }
}

public class QueueByLinkedList {

    public static void main(String[] args) {

        Queue2 q = new Queue2();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

//reverse elements
        Stack<Integer> st = new Stack<Integer>();

        while (q.size>0 ){
            int t=q.dequeue();
            st.push(t);
        }

        while (st.size()>0){
            int t =st.pop();
            q.enqueue(t);
        }

        Node curr=q.front;
        while(curr!=null){
            System.out.println(curr.data);
            curr=curr.next;
        }
        System.out.println(q.getFront());
        System.out.println(q.getRear());
//rev




//        System.out.println(q.isEmpty());
//        System.out.println(q.getFront());
//        q.enqueue(10);
//        System.out.println();
//        q.enqueue(20);
//        q.enqueue(30);
//        System.out.println(q.size);
//        System.out.println(q.getFront());
//        System.out.println(q.getRear());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//
//        System.out.println(q.size);
//        System.out.println(q.isEmpty());

    }


}
