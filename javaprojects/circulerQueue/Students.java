package javaprojects.circulerQueue;

public class Students {
    int nim;
    String name,className,major;

    Students(int nim, String name, String className, String major){
        this.nim = nim;
        this.name = name;
        this.className = className;
        this.major = major;

    }

    public void print(){
        System.out.println(nim+" "+name+" "+className+" "+major);
    }
    
}
