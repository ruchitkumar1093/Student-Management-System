package dao;

import model.Student;
import util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class StudentDao {

    public void addStudent(Student student) {

        String sql = "INSERT INTO students (roll_no, name, marks) VALUES (?, ?, ?)";

        try (Connection con = DatabaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getRollNo());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getMarks());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getAllStudents() {

        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection con = DatabaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int rollNo = rs.getInt("roll_no");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");

                students.add(new Student(name, rollNo, marks));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getStudentByRollNo(int rollNo) {

        String sql = "SELECT * FROM students WHERE roll_no = ?";
        Student student = null;

        try (Connection con = DatabaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, rollNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                int marks = rs.getInt("marks");

                student = new Student(name, rollNo, marks);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    public boolean deleteStudent(int rollNo) {

        String sql = "DELETE FROM students WHERE roll_no = ?";

        try (Connection con = DatabaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, rollNo);

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateStudent(int rollNo, String name, int marks) {

        String sql = "UPDATE students SET name = ?, marks = ? WHERE roll_no = ?";

        try (Connection con = DatabaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, marks);
            ps.setInt(3, rollNo);

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
