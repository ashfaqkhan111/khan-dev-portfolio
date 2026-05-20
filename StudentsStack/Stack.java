package StudentsStack;

public class Stack {
    Student [] stack;

    int top , size;

    Stack(int size){
        this.size = size;
        this.top = -1;
        stack = new Student[size];
    }

    boolean isfull(){
        return top == size-1;
    }

    boolean isEmpty (){
        return top == -1;
    }

    public void push(Student data){
        if (isfull()){
            System.out.println("the Stack is already full");
            return;
        }
        top++;
        stack[top]=data;
        System.out.println("the data of : '"+data.name+"' is pushed");
    }

    public
}
