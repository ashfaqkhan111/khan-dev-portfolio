package StudentsStack;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter size of stack : "); 
        int size = in.nextInt();

        Stack s = new Stack(size);

        int choice;

        do{
            System.out.println("    ====MENU====");
            System.out.println("1. Push data");
            System.out.println("2. PoP data");
            System.out.println("3. Peek top");
            System.out.println("4. Delete all data");
            System.out.println("5. Exit");
            System.out.println("========================");
            System.out.print("Enter Choice : ");
            choice = in.nextInt();
            in.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Student Number : ");
                    String studentNumber = in.nextLine();
                    
                    System.out.print("Enter Name           : ");
                    String name = in.nextLine();
                    System.out.print("Enter Class          : ");
                    String className = in.nextLine();
                    System.out.print("Enter Major          : ");
                    String major = in.nextLine();
                    

                    Student std = new Student(studentNumber, name, className, major);
                    s.push(std);
                    break;
            
                case 2:
                    s.pop();
                    break;

                case 3:
                    s.peek();
                    break;

                case 4:
                    s.deleteStack();
                    break;

                case 5:
                    System.out.println("thanks for using the program");
                    break;
                default :
                break;
            }
        }while (choice != 6);
    }
    
}
