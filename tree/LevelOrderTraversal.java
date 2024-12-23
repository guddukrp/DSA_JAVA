package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

//    static  void levelOrderTraversal(Node root){
//
//        Queue<Node> q=new LinkedList<Node>();
//
//        if(root!=null){
//            q.add(root);
//            q.add(null);                               //
//            while(q.size()>1){                         //
//                Node curr = q.poll();
//                if(curr==null){                         //
//                    System.out.println();               //
//                    q.add(null);                        //
//                }else{
//                    System.out.print(curr.data + " ");
//                    if (curr.left != null) {
//                        q.add(curr.left);
//                    }
//                    if (curr.right != null) {
//                        q.add(curr.right);
//                    }
//                }
//
//            }
//        }
//    }


    public static void main(String[] args) {
        Node root = null;
        root = new Node(10);
        root.left=new Node(20);
        root.right= new Node(30);
        root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.right.left= new Node(60);
        root.right.right=new Node(70);

        levelOrderTraversal(root);
    }

    static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<Node>();
        if(root!=null){
            q.add(root);
            while (q.size()>0) {
                int count = q.size();

                for (int i = 0; i < count; i++) {           //
                    Node curr = q.poll();
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
                System.out.println();                       //

            }


        }
    }
}
