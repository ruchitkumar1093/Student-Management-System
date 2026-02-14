package model;

public class Student {
    private int rollNo;
    private String name;
    private int marks;

    public Student(String name, int rollNo, int marks){
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public int getRollNo(){
        return rollNo;
    }

    public String getName(){
        return name;
    }

    public int getMarks(){
        return marks;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMarks(int marks){
        this.marks = marks;
    }
}
