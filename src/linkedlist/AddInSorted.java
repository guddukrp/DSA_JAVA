package linkedlist;

public class AddInSorted {

    static Node addInSorted(Node head,int e){
        Node temp = new Node(e);
        if(head==null){
            head=temp;
            return head;
        }else if(temp.data<head.data){
            temp.next=head;
            head=temp;
            return head;
        }else {
            Node curr = head;

            while (curr.next != null && curr.next.data < temp.data) {
                curr = curr.next;
            }
            temp.next = curr.next;
            curr.next = temp;
        }
        return head;

    }
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);

        ll.head=addInSorted(ll.head,8);
        ll.printLinkedList();
    }
}
