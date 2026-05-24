package javaprojects.LinkedList;

public class Student {
    String nim,name,className,major;

    Student(String nim, String name, String className, String major){
        this.nim = nim;
        this.name = name;
        this.className = className;
        this.major = major;
    }

    public void print(){
        System.out.println(nim+" "+name+" "+className+" "+major);
    }
    
}
