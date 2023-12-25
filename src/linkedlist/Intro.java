package linkedlist;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class LinkedList{
    Node head;
    void printLinkedList(){
        Node curr=this.head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    void add(int e){
        Node temp=new Node(e);
        if(head==null){
            head=temp;
        }else{
            Node curr=head;
            while (curr.next!=null){
                curr=curr.next;
            }
            curr.next=temp;
        }
    }
    void addFirsts(int e){
        Node temp = new Node(e);
        if(head==null){
            head=temp;
        }else{
            temp.next=head;
            head=temp;
        }
    }
    void addIndex(int index,int element) throws ArrayIndexOutOfBoundsException{
        try{
            if(index==0){
                addFirsts(element);
            }else{
                Node temp=new Node(element);
                int count=0;
                Node curr = this.head;
                while(count<index-1){      //index=3;
                    curr=curr.next;
                    count++;                //count=2; loop shoud stop when count become 2; 2 is index(3)-1
                }
                temp.next=curr.next;
                curr.next=temp;
            }
        }catch (Exception e){
           throw new ArrayIndexOutOfBoundsException();
        }
    }
    void removeFirst(){
        if(head==null){
            System.out.println("empty linkedList");
        }else if(head.next==null){
            head=null;
        }
        else{
            Node temp=head.next;
            head=temp;
        }
    }
    void removeLast(){
        if(head==null){
            System.out.println("Empty linkedList");
        }else if(head.next==null){
            head=null;
        }else {
            Node curr=this.head;
            while(curr.next.next!=null){
                curr=curr.next;
            }
            curr.next=null;

        }
    }
    int indexOf(int e){
        Node curr=this.head;
        int count=0;
        while(curr!=null){
            if(curr.data==e){
                return count;
            }
            count++;
            curr=curr.next;
        }
        return -1;
    }
    int lastIndexOf(int e){
        Node curr=head;
        int ans=-1;
        int count=0;
        while(curr!=null){
            if(curr.data==e){
                ans=count;
            }
            count++;
            curr=curr.next;
        }
        return ans;
    }
    int size(){
        Node curr=this.head;
        int count=0;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        return count;
    }
}


public class Intro {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);

        ll.addIndex(3,35);
//        ll.removeFirst();
//        ll.removeLast();

//        System.out.println(ll.indexOf(20));
//        System.out.println(ll.lastIndexOf(30));
        System.out.println(ll.size());
        ll.printLinkedList();



    }
}
