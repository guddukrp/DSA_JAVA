package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfTree {
    static void leftView(Node root){
        Queue<Node> q = new LinkedList<Node>();
        if(root!=null){
            q.add(root);
            while (q.size()>0){
                int count=q.size();

                for(int i=0;i<count;i++){
                    Node curr = q.poll();
                    if(i==0) {
                        System.out.print(curr.data + " ");
                    }
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }


                }
                System.out.println();
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

        leftView(root);
    }
}
