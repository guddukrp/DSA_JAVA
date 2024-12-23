package tree;

public class SizeOfBinaryTree {
    static int sizeOfTree(Node root){

        if (root==null) {
            return 0;
        } else {
            return sizeOfTree(root.left) + sizeOfTree(root.right)+1;
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


        int size=sizeOfTree(root);
        System.out.println(size);
    }
}
