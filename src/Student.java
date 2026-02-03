class Student{
    private int rollNo;
    private String name;
    private int marks;

    Student(String name, int rollNo, int marks){
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public void display(){
        System.out.println("Student name: " + name);
        System.out.println("Student rollNo: " + rollNo);
        System.out.println("Student marks: " + marks);

    }

    public int getRollNo(){
        return rollNo;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMarks(int marks){
        this.marks = marks;
    }
}
