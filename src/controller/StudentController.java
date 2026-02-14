package controller;

import service.StudentService;
import model.Student;
import java.util.Scanner;

public class StudentController {

    private StudentService service = new StudentService();
    private Scanner sc = new Scanner(System.in);

    public void start(){
        while(true){
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void addStudent(){
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter rollNo: ");
        int rollNo = sc.nextInt();

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();
        sc.nextLine();

        service.addStudent(name, rollNo, marks);
        System.out.println("Student added successfully!");
    }

    private void viewStudents(){
        for(Student s : service.getAllStudents()){
            System.out.println("Name: " + s.getName());
            System.out.println("Roll No: " + s.getRollNo());
            System.out.println("Marks: " + s.getMarks());
            System.out.println("------------------");
        }
    }

    private void searchStudent(){
        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        Student s = service.searchStudent(rollNo);
        if(s != null){
            System.out.println("Name: " + s.getName());
            System.out.println("Marks: " + s.getMarks());
        } else {
            System.out.println("Student not found");
        }
    }

    private void updateStudent(){
        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new name: ");
        String name = sc.nextLine();

        System.out.print("Enter new marks: ");
        int marks = sc.nextInt();
        sc.nextLine();

        if(service.updateStudent(rollNo, name, marks)){
            System.out.println("Student updated");
        } else {
            System.out.println("Student not found");
        }
    }

    private void deleteStudent(){
        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        if(service.deleteStudent(rollNo)){
            System.out.println("Student deleted");
        } else {
            System.out.println("Student not found");
        }
    }
}
