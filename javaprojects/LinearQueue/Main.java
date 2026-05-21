package javaprojects.LinearQueue;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

       
        System.out.print("Enter the size of Queue : ");
        int size = in.nextInt();
        
        Queue q = new Queue(size);

        int choice;

        do{
            System.out.println("====MENU====");
            System.out.println("1. Queue");
            System.out.println("2. Dequeue");
            System.out.println("3. Show Front");
            System.out.println("4. Show Rear");
            System.out.println("5. exit");
            System.out.println("===============");
            System.out.print("Enter Choice : ");
            choice = in.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter NIM          : ");
                    String nim = in.nextLine();
                    System.out.print("Enter Name         : ");
                    String name = in.nextLine();
                    System.out.print("Enter Class Name   : ");
                    String className = in.nextLine();
                    System.out.print("Enter Major        : ");
                    String major = in.nextLine();

                    Students s = new Students(nim, name, className, major);
                    q.enqueue(s);
                    break;

                case 2:
                    q.showFront();
                    break;

                case 3:
                    q.showRear();
                    break;

                case 4:
                    q.dequeue();
                    break;

                case 5:
                        System.out.println("program ended!!");
                        break;
                default:
                    System.out.println(" ");
                    break;


            }
        }while (choice != 5);
    } 
    
}
