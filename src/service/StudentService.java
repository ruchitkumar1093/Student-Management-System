package service;

import dao.StudentDao;
import model.Student;
import java.util.ArrayList;

public class StudentService {

    private StudentDao studentDao = new StudentDao();

    public void addStudent(String name, int rollNo, int marks){
        Student student = new Student(name, rollNo, marks);
        studentDao.addStudent(student);
    }

    public ArrayList<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }

    public Student searchStudent(int rollNo){
        return studentDao.getStudentByRollNo(rollNo);
    }

    public boolean updateStudent(int rollNo, String newName, int newMarks){
        return studentDao.updateStudent(rollNo, newName, newMarks);
    }

    public boolean deleteStudent(int rollNo){
        return studentDao.deleteStudent(rollNo);
    }
}
