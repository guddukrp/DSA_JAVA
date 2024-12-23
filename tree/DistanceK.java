package tree;

public class DistanceK {

    static void distance(Node root,int k){

        if(root!=null) {
            if (k == 0) {
                System.out.print(root.data + " ");
                return;
            } else {
                distance(root.left, k - 1);
                distance(root.right, k - 1);
            }
        }

    }
    public static void main(String[] args) {
        Node root = null;
        root = new Node(10);
        root.left=new Node(20);
        root.right= new Node(30);
        root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.right.left= new Node(60);
        root.right.right=new Node(70);

        int k=2;
        distance(root,k);
    }
}