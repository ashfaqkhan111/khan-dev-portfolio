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

    boolean isEmpry (){
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
        if (isEmpry()){
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
    
}
