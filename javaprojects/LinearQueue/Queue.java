package javaprojects.LinearQueue;

public class Queue {
    Students [] queue;

    int front,rear,size;
    
    Queue(int size){
        this.size = size;
        this.front = -1;
        this.rear = -1;
        queue = new Students[size];

    }

    boolean isEmpty (){
        return front == -1 && rear == -1;
    }

    boolean isFull (){
        return rear == size-1;
    }

    public void enqueue(Students data){
        if (isFull()){
            System.out.println("the Student Queue is full");
            return;
        }
        if(front == -1){
            front =0;
            
        }
        rear++;
        queue[rear] = data;
        System.out.println("the data of '"+data.name+"' is Enqueued");

    }

    public void dequeue (){
        if (isEmpty()){
            System.out.println("Student Queue is Empty ");
            return;
        }

        Students tmp = queue[front];

        front++;

        if(front > rear){
            front = -1;
            rear = -1;
        }
        System.out.println("the value removed : "+tmp.name);
    }

    public void showFront (){
        if (isEmpty()){
            System.out.println("the Queue is Empty");
            return;
        }
        System.out.println("the front is : "+queue[front].name);

    }

    public void showRear(){
        if (isEmpty()){
            System.out.println("the Queue is Empty");
            return;
        }
        System.out.println("the Rear is : "+queue[rear].name);
    }
    
}
