package queue;

import java.util.Queue;
import java.util.Scanner;

public class Series56 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n= scan.nextInt();

        Queue2 queue = new Queue2();

        queue.enqueue(5);
        queue.enqueue(6);

        for(int i=0;i<n;i++) {
            int t = queue.dequeue();
            System.out.print(t + " ");
            queue.enqueue(t * 10 + 5);      //concate 5, t+"5"
            queue.enqueue(t * 10 + 6);      //concate 6 to t
        }
    }
}
