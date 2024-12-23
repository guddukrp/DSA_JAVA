//inorder(): left->root->right
//preorder(): root->left->right
//postorder(): left->right->root

package tree;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data =data;
    }
}

public class Main {
    private static void inorder(Node root) {
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    static void preorder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    static  void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }

    public static void main(String[] args) {

        Node root = null;
        root = new Node(10);
        root.left=new Node(20);
        root.right= new Node(30);
        root.left.left=new Node(40);
        root.right.left= new Node(50);
        root.right.right=new Node(60);

        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
    }



}
