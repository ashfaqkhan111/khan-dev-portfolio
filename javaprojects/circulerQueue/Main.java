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
            System.out.println("3. Show Rear");
            System.out.println("4. Show Front");
            System.out.println("5. Erase Queue");
            System.out.println("=================");
            System.out.println("Enter Choice : ");
            choice = in.nextInt();
            in.nextLine();
            
            switch (q) {
                case value:
                    
                    break;
            
                default:
                    break;
            }
        }
    }
    
}
