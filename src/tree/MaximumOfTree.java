//10 20 30
//

package tree;

public class MaximumOfTree {
    static  int maximum(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }else{                                              //find max(left,right,mid)
            int temp1= maximum(root.left);
            int temp2= maximum(root.right);
            return Math.max( Math.max(temp1,temp2),root.data);
        }
    }
    public static void main(String[] args) {
        Node root = null;
        root = new Node(10);
        root.left=new Node(120);
        root.right= new Node(30);
        root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.right.left= new Node(60);
        root.right.right=new Node(70);


        int ans=maximum(root);
        System.out.println(ans);
    }
}
