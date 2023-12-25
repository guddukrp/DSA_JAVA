package dequeue;
class Node{
    Node next;
    Node prev;
    int data;
    public Node(int data){
        this.data=data;
    }
}
class Dequeue{
    Node front;
    Node rear;
    int size;
    public Dequeue(){
        front =null;
        rear= null;
        int size=0;
    }
    void offerFirst(int element){
        Node temp = new Node(element);
        if(front==null){
            front=temp;
            rear=temp;
            size++;
        }else{
            temp.next= front;
            front.prev=temp;
            front=temp;
            size++;
        }
    }
    void offerLast(int element){
        Node temp = new Node(element);
        if(front==null){
            front=temp;
            rear=temp;
            size++;
        }else{
            rear.next=temp;
            temp.prev=rear;
            rear=temp;
            size++;
        }
    }
    int peekFirst(){
        if(size>0){
            return front.data;
        }else{
            System.out.println("Queue is empty");
            return -1;
        }
    }
    int peekLast(){
        if (size>0){
            return rear.data;
        }else{
            System.out.println("Queue is empty");
            return -1;
        }
    }
    int pollFirst(){
        if(size>0){
            int t=front.data;
            Node temp =front;
            front=front.next;
            front.prev=null;
            temp=null;

            size--;
            return t;
        }else{
            System.out.println("Queue is empty");
            return -1;
        }
    }
    int pollLast(){
        if(size>0){
            int t = rear.data;
            Node temp= rear;
            rear=rear.prev;
            rear.next=null;
            temp=null;

            size--;
            return t;
        }else{
            System.out.println("Queue is empty");
            return -1;
        }
    }
    boolean isEmpty(){
        return size>0?false:true;
    }

}


public class Main {
    public static void main(String[] args) {

        Dequeue dq = new Dequeue();
        System.out.println(dq.isEmpty());
        dq.offerFirst(20);
        dq.offerFirst(10);
        dq.offerLast(30);
        dq.offerLast(40);

        System.out.println(dq.size);
        System.out.println(dq.pollFirst());
        System.out.println(dq.pollLast());
        System.out.println(dq.isEmpty());


        Node curr=dq.front;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr= curr.next;
        }



    }
}
