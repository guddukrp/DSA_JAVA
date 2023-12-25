package queue;

class Queue1{
    int[] arr;
    int front;
    int rear;
    int capacity;
    int size;
    Queue1(int capacity){
        this.capacity=capacity;
        this.arr = new int[capacity];
        int front =0;
        int rear = -1;
        int size=0;

    }

    void enqueue(int element){

        if(rear==capacity-1){
            System.out.println("Queue if full");
        }else {
            rear++;
            arr[rear] = element;
            size++;
        }
    }
    int dequeue(){
        if(front>rear){
            System.out.println("Queue is empty");
            return -1;
        }else{
            int temp = arr[front];
            front++;
            size--;
            return temp;
        }
    }
    int getFront(){
        if(size>0){
            return arr[front];
        }else {
            System.out.println("Queue is empty");
            return -1;
        }
    }
    int getRear(){
        if(size>0){
            return arr[rear];
        }else {
            System.out.println("Queue is empty");
            return -1;
        }
    }
    boolean isEmpty(){
        if(size==0 || rear<front){
            return true;
        }else{
            return false;
        }
    }
    boolean isFull(){
        if(rear==capacity-1){
            return true;
        }else{
            return false;
        }
    }

}
public class QueueByArray {
    public static void main(String[] args) {

        Queue1 q = new Queue1(6);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        q.enqueue(70);
    }
}
