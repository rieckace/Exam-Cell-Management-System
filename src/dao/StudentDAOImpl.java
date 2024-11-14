package dao;

import model.Student;
import utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private Connection connection;

    public StudentDAOImpl() throws SQLException {
        connection = DBConnection.getConnection();
    }

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO Students (Name, RollNumber, Department) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getRollNumber());
            ps.setString(3, student.getDepartment());
            ps.executeUpdate();
        } catch (SQLException e) {
        	System.out.println("Error adding Student."+e.getMessage());
        }
    }

    @Override
    public Student getStudentById(int studentId) {
        String sql = "SELECT * FROM Students WHERE StudentId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student(studentId, sql, sql, sql);
                student.setStudentId(rs.getInt("StudentId"));
                student.setName(rs.getString("Name"));
                student.setRollNo(rs.getString("RollNumber"));
                student.setDepartment(rs.getString("Department"));
                return student;
            }
        } catch (SQLException e) {
        	{ 
        		System.err.println("Error retrieving student: "+ e.getMessage());
        }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Students";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student(0, sql, sql, sql);
                student.setStudentId(rs.getInt("StudentId"));
                student.setName(rs.getString("Name"));
                student.setRollNo(rs.getString("RollNumber"));
                student.setDepartment(rs.getString("Department"));
                students.add(student);
            }
        } catch (SQLException e) {
        	System.err.println("Error retrieving all  student: "+ e.getMessage());
        }
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE Students SET Name = ?, RollNumber = ?, Department = ? WHERE StudentId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getRollNumber());
            ps.setString(3, student.getDepartment());
            ps.setInt(4, student.getStudentId());
            ps.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Error updating student: "+ e.getMessage());
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        String sql = "DELETE FROM Students WHERE StudentId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Error deleting student: "+ e.getMessage());
        }
    }
}
