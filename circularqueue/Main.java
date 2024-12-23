package circularqueue;

class CircularQueue{
    int[] arr;
    int rear;
    int front;
    int capacity;
    int size;
    CircularQueue(int capacity){
        this.capacity=capacity;
        arr= new int[capacity];
        rear=-1;
        front =0;
        size=0;

    }
    void enqueue(int element){
        if(size==capacity){
            System.out.println("Queue is full");
        }else{
            rear=(rear+1)%capacity;
            arr[rear]=element;
            size++;
        }
    }
    int  dequeue(){
        if(size==0){
            System.out.println("Queue is empty");
            return -1;
        }else{
            int temp = arr[front];
            front=(front+1) % capacity;
            size--;

            return temp;
        }
    }
    int getFront(){
        if(size==0){
            System.out.println("Queue is empty");
            return -1;
        }else{
            return arr[front];
        }
    }
    int getRear(){
        if(size==0){
            System.out.println("Queue is empty");
            return -1;
        }else{
            return arr[rear];
        }
    }
    boolean isFull(){
        return (size==capacity)?true:false;
    }
    boolean isEmpty(){
        return (size==0)?true:false;
    }
}


public class Main {
    public static void main(String[] args) {

        CircularQueue cq = new CircularQueue(6);

        cq.enqueue(10);
        System.out.println(cq.getFront()+"f");
        System.out.println(cq.getRear()+"r");
        cq.enqueue(20);
        System.out.println(cq.getFront()+"f");
        System.out.println(cq.getRear()+"r");
        cq.enqueue(30);
        System.out.println(cq.getFront()+"f");
        System.out.println(cq.getRear()+"r");
        System.out.println(cq.size);
        cq.enqueue(40);
        System.out.println(cq.getFront()+"f");
        System.out.println(cq.getRear()+"r");
        System.out.println(cq.size);
        cq.enqueue(50);
        System.out.println(cq.getFront()+"f");
        System.out.println(cq.getRear()+"r");
        System.out.println(cq.size);
        cq.enqueue(60);
        System.out.println(cq.getFront()+"f");
        System.out.println(cq.getRear()+"r");
        System.out.println(cq.size);
        System.out.println(cq.getFront());
        System.out.println(cq.getRear());





    }
}
