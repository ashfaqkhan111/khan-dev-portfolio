package javaprojects.LinkedList;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        LinkList ll = new LinkList();

        int choice;

        do{
            System.out.println("=====MENU=====");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Print List");
            System.out.println("4. Remove First");
            System.out.println("5. Remove Last");
            System.out.println("6. Exit");
            System.out.println("=================");
            System.out.print("Enter Choice : ");
            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student NIM   : ");
                    String nim = in.nextLine();

                    System.out.print("Enter Student Name  : ");
                    String name = in.nextLine();
                    
                    System.out.print("Enter Class Name    :");
                    String className = in.nextLine();

                    System.out.print("Enter Student major : ");
                    String major = in.nextLine();

                    Student s = new Student(nim, name, className, major);
                    ll.addFirst(s);
                    break;
                case 2:
                  System.out.print("Enter Student NIM   : ");
                    String nim2 = in.nextLine();

                    System.out.print("Enter Student Name  : ");
                    String name2 = in.nextLine();
                    
                    System.out.print("Enter Class Name    :");
                    String className2 = in.nextLine();

                    System.out.print("Enter Student major : ");
                    String major2 = in.nextLine();

                    Student s2 = new Student(nim2, name2, className2, major2);
                    ll.addLast(s2); 
                    break;
                case 3:
                    ll.print();
                    break;

                case 4:
                    ll.removeFirst();
                    break;

                case 5:
                    ll.removeLast();
                    break;

                case 6:
                    System.out.println("program Ended");
                    break;
                

                default:
                    System.out.println("program Ended");
                    break;
            }
        } while (choice != 6);
    }
    
}
