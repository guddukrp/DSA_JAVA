package doublylinkedlist;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data=data;
        next=null;
        prev=null;
    }
}
class DoublyLinkedList{
    Node head;
    Node tail;

    public void printDl() {
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    void printReverse(){
        Node curr=tail;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.prev;
        }
    }
    void add(int e){
        Node temp= new Node(e);
        if(head==null){
            head=temp;
            tail=temp;
        }else{
            tail.next=temp;
            temp.prev=tail;

            tail=temp;
        }
    }
    void addFirst(int e){
        Node temp=new Node(e);
        if(head==null){
            head=temp;
            tail=temp;
        }else {
            head.prev = temp;
            temp.next = head;
            head = temp;
        }
    }
    void addIndex(int index,int element){
        if(index==0){
            addFirst(element);
        }else {
            Node temp = new Node(element);
            Node curr = head;
            int count = 0;
            while (count < index - 1) {
                curr = curr.next;
                count++;
            }
            curr.next.prev = temp;
            temp.next = curr.next;
            temp.prev = curr;
            curr.next = temp;
        }
    }
    void addAll(int[] elements){
        for(int i:elements){
            this.add(i);
        }
    }
    void removeFirst(){
        if(head==null){
            System.out.println("LinkedList is empty");
        }else if(head.next==null){
            head=null;
            tail=null;
        }else {
            Node curr=head;
            head=head.next;
            head.prev=null;
            curr.next=null;
        }
    }
    void removeLast(){
        if(head==null){
            System.out.println("linkedList is empty");
        }else if (head.next==null){
            head=null;
            tail=null;
        }else{
            Node curr=tail;
            tail=tail.prev;
            tail.next=null;
            curr.prev=null;
        }
    }
}
public class Main {
    public static void main(String[] args) {

        DoublyLinkedList dl=new DoublyLinkedList();


        dl.add(10);
        dl.add(20);
        dl.add(30);
        dl.add(40);

//        dl.addFirst(5);
//        dl.addIndex(2,25);

//        int[] arr={1,2,3,4,5};
//        dl.addAll(arr);
        dl.printDl();
        dl.removeFirst();
        dl.removeLast();
        System.out.println();
        dl.printDl();
    }
}
