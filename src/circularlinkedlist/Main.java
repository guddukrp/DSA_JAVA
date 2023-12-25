package circularlinkedlist;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class CircularLinkedList{
    Node head;
    void printCll(){
        if(head==null){
            System.out.println("linkedlist is empty");
        }else {

            Node curr = head;
            do {
                System.out.print(curr.data + " ");
                curr = curr.next;
            } while (curr != head);

//        Node curr=head.next;
//        System.out.println(head.data+" ");
//        while(curr!=head){                    //print first element the add condition curr!=head
//            System.out.println(curr.data+" ");
//            curr=curr.next;
//        }
        }
    }
    void add(int e){
        Node temp=new Node(e);
        if(head==null){
            head=temp;
            temp.next=head;
        }else {
            Node curr = head;

            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = temp;
            temp.next = head;
        }

    }
    void addFirst(int e){
        Node temp = new Node(e);
        if(head==null){
            head=temp;
            temp.next=head;
        }else{
            temp.next=head.next;
            head.next=temp;

            int t=head.data;
            head.data=temp.data;
            temp.data=t;

//            {
//                Node curr = head.next;
//                while(curr.next!=head){
//                    curr=curr.next;
//                }
//                curr.next=temp;
//                temp.next=head;
//                head=temp;
//            }
        }

    }
    void addLast(int e){
        Node temp = new Node(e);
        if(head==null){
            head=temp;
            head.next=head;
        }else{
            temp.next=head.next;
            head.next=temp;

            int t = temp.data;
            temp.data=head.data;
            head.data=t;

            head=head.next ;      //head=temp;
//            {
//                Node curr=head;
//                while(curr.next!=head){
//                    curr=curr.next;
//                }
//                curr.next=temp;
//                temp.next=head;
//            }
        }
    }
    void removeFirst(){
        if(head==null){
            System.out.println("list is empty");
        }else if(head.next==head){
            head=null;
        }else{
            Node temp=head.next;
            head.next=head.next.next;

            head.data=temp.data;
//            {
//                Node curr= head.next;
//                while(curr.next!=head){
//                    curr=curr.next;
//                }
//                curr.next=head.next;
//                head=head.next;
//            }
        }
    }

    void removeLast(){
        if(head==null){
            System.out.println("linkedlist is empty");
        }else if(head.next==head){
            head=null;

        }else{
            Node curr=head;
            while(curr.next.next!=head){
                curr=curr.next;
            }
            curr.next=head;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        CircularLinkedList cll=new CircularLinkedList();
        cll.add(10);
        cll.add(20);
//        cll.add(30);
//
//        cll.addFirst(5);
//        cll.addFirst(10);
//        cll.addFirst(20);

//        cll.addLast(50);
//        cll.addLast(60);
//        cll.addLast(70);

        cll.printCll();
//        cll.removeFirst();
//        cll.removeFirst();
        cll.removeLast();
//        cll.removeLast();
        System.out.println();
        cll.printCll();
    }
}
