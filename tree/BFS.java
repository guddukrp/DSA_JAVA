
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static  void bfs(Node root){

        Queue<Node> q = new LinkedList<Node>();

        if(root!=null){
            q.add(root);
            boolean flag=false;
            while(q.size()>0){
                Node curr=q.poll();
                System.out.print(curr.data+" ");

                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
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


        bfs(root);
    }
}
