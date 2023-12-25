package linkedlist;

public class AddElements {

    static Node adds(Node head, int e) {
        Node temp = new Node(e);
        if (head == null) {
            head = temp;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
        return head; // Return the updated head.
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        head = adds(head, 10); // Assign the updated head to the 'head' variable.
        head = adds(head, 20);
        head = adds(head, 30);
        head = adds(head, 40);
        printLinkedList(head);
    }
}
