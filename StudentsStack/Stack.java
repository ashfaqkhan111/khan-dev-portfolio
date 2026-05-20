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

    public void pop (){
        if (isEmpty()){
            System.out.println("there is no data in stack");
            return;
        }
        Student tmp = stack[top];
        top--;
        System.out.println("data of student '"+tmp.name+"' is removed");
    }

    public void peek(){
        if (isEmpty()){
            System.out.println("there is no data in stack");
            return;
        }else{
            System.out.println("the top is : "+stack[top].name);
        }
    }

    public void deleteStack(){
        if (isEmpty()){
            System.out.println("there is no data in stack");
            return;
        }else{
            top =-1;
            
        }
    }
}
