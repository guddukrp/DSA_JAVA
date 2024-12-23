package tree;

public class HeightOfTree {

    static int heightOfTree(Node root){
        if(root==null){
            return 0;
        }else{
            int lh=heightOfTree(root.left);
            int rh = heightOfTree(root.right);
            return Math.max(lh,rh)+1;
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

        System.out.println(heightOfTree(root));
    }
}
