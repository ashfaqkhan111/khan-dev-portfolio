package javaprojects.circulerQueue;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size : ");
        int size = in.nextInt();

        CirculerQueue q = new CirculerQueue(size);

        int choice;

        do {
            System.out.println("====MENU====");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Show Front");
            System.out.println("4. Show Rear");
            System.out.println("5. Erase Queue");
            System.out.println("6. program ended");
            System.out.println("=================");
            System.out.print("Enter Choice : ");
            choice = in.nextInt();
            in.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter your NIM : ");
                    String nim = in.nextLine();

                    System.out.print("Enter your Name : ");
                    String name = in.nextLine();

                    System.out.print("Enter your Class Name : ");
                    String className = in.nextLine();

                    System.out.print("Enter your Major : ");
                    String major = in.nextLine();

                    Students s = new Students(nim, name, className, major);
                    q.enqueue(s);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.showFront();
                    break;

                case 4:
                    q.showRear();
                    break;

                case 5:
                    q.eraseQueue();
                    break;

                case 6:
                    System.out.println("program is ended ");
                    break;
            
                default:
                    System.out.println("program ended!!");
                    break;
            }
        }while (choice != 6);
    }
    
}
