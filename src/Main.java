import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

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

            switch (choice){
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter rollNo: ");
                    int rollNo = sc.nextInt();

                    System.out.print("Enter marks: ");
                    int marks = sc.nextInt();
                    sc.nextLine();

                    Student s1 = new Student(name, rollNo, marks);
                    students.add(s1);

                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if(students.isEmpty()){
                        System.out.println("No Student found");
                    }
                    else{
                        for(int i=0; i<students.size(); i++){
                            students.get(i).display();
                            System.out.println("------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = sc.nextInt();
                    sc.nextLine();

                    boolean found = false;

                    for(int i=0; i<students.size(); i++){
                        if(students.get(i).getRollNo() == searchRoll){
                            students.get(i).display();
                            found = true;
                            break;
                        }
                    }

                    if(!found){
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter roll number to update: ");
                    int updateRoll = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;

                    for(Student s : students){
                        if(s.getRollNo() == updateRoll){

                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();

                            System.out.print("Enter new marks: ");
                            int newMarks = sc.nextInt();
                            sc.nextLine();

                            s.setName(newName);
                            s.setMarks(newMarks);

                            System.out.println("Student updated successfully.");
                            updated = true;
                            break;
                        }
                    }

                    if(!updated){
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter roll number to delete: ");
                    int deleteRoll = sc.nextInt();
                    sc.nextLine();

                    boolean deleted = false;

                    for(int i=0; i<students.size(); i++){
                        if(students.get(i).getRollNo() == deleteRoll){
                            students.remove(i);
                            deleted = true;
                            System.out.println("Student deleted successfully.");
                            break;
                        }
                    }

                    if(!deleted){
                        System.out.println("Student not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;
                
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
