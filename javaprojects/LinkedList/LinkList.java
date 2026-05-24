package javaprojects.LinkedList;

public class LinkList {
    Node head;

    boolean isEmpty (){
        return head == null;
    }

    public void addFirst (Student data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
        }else{
          newNode.next = head;
          head = newNode;  
        }
    }

    public void addLast (Student data){
        Node newNode = new Node(data);
        if (isEmpty()){
            head = newNode;
        }else{
           Node currNode = head;
           
           while(currNode.next != null){
            currNode = currNode.next;
           }

           currNode = newNode;
        }

    }

    public void print(){
        if (isEmpty()){
            System.out.println("The Stack is Empty");
            return;
        }else {
            Node currnNode = head;

            while(currnNode != null){
                currnNode.data.print();

                currnNode = currnNode.next;
            }
        }

    }

    public void removeFirst(){
        if (isEmpty()){
            System.out.println("the stack is already empty !!");
            return;
        }else{
            head = head.next;
        }
    }
    
}
