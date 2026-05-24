package javaprojects.circulerQueue;

public class CirculerQueue {
    Students queue [];

    int front;
    int rear;
    int size;

    CirculerQueue(int size){
        this.size = size;
        this.front = -1;
        this.rear = -1;
        queue = new Students[size];
    }

    boolean isEmpty (){
        return front == -1;
    }

    boolean isFull(){
        return (rear+1)%size == front;
    }

    public void enqueue (Students data){
        if (isFull()){
            System.out.println("the Queue is full!!");
            return;
        }
        if (front == -1){
            front = rear =0;
        }else{
            rear = (rear+1)%size;
        }
        queue[rear]=data;

        System.out.println(data.name+" is enqueued successfully");
    }

    public void dequeue (){
        if (isEmpty()){
            System.out.println("the Queue is already empty");
            return;
        }
        Students temp = queue[front];
        if(front == rear){
            front = rear = -1;
        }else{
            front = (front+1)%size;
        }
        System.out.println(temp.name+" is removed");
    }

    public void showRear (){
        if (isEmpty()){
            System.out.println("the Queue is empty");
            return;
        }else{
            System.out.println("the rear is : "+queue[rear].name);
        }
    }

    public void showFront(){
        if (isEmpty()){
            System.out.println("the Queue is empty");
            return;
        }else{
            System.out.println("the front is : "+queue[front].name);
        }
    }
    
    public void eraseQueue(){
        if (isEmpty()){
            System.out.println("the Queue is already Empty");
            return;
        }else{
            front = rear =-1;
        }
    }

    
}
