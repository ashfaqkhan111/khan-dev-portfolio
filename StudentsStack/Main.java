package StudentsStack;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter size of stack : ");
        int size = in.nextInt();

        Stack s = new Stack(size);

        int choice;

        do{
            System.out.println("    ====MENU====");
            System.out.println("1. Push data");
            System.out.println("2. PoP data");
            System.out.println("3. Peek top");
            System.out.println("4. Delete all data");
            System.out.println("========================");
            System.out.println("Enter Choice : ");
            
        }
    }
    
}
