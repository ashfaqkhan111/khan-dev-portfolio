package javaprojects.circulerQueue;

public class Students {
    
    String nim,name,className,major;

    Students(String nim, String name, String className, String major){
        this.nim = nim;
        this.name = name;
        this.className = className;
        this.major = major;

    }

    public void print(){
        System.out.println(nim+" "+name+" "+className+" "+major);
    }
    
}
