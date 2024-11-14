package dao;

import model.Course;
import utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    private Connection connection;

    public CourseDAOImpl() throws SQLException {
        connection = DBConnection.getConnection();
    }

    @Override
    public void addCourse(Course course) {
        String sql = "INSERT INTO Courses (CourseId,CourseCode, CourseName, Credits) VALUES (?,?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
        	ps.setInt(1, course.getCourseId());
            ps.setString(2, course.getCourseCode());
            ps.setString(3, course.getCourseName());
            ps.setInt(4, course.getCredits());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while adding course."+e.getMessage());
        }
    }

    @Override
    public Course getCourseById(int courseId) {
        String sql = "SELECT * FROM Courses WHERE CourseId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Course course = new Course(courseId, sql, sql, courseId);
                course.setCourseId(rs.getInt("CourseId"));
                course.setCourseCode(rs.getString("CourseCode"));
                course.setCourseName(rs.getString("CourseName"));
                course.setCredits(rs.getInt("Credits"));
                return course;
            }
        } catch (SQLException e) {
        	
        	System.out.println("Error retrieving specific course."+e.getMessage());
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM Courses";
        
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Course course = new Course(0, sql, sql, 0);
                course.setCourseId(rs.getInt("CourseId"));
                course.setCourseCode(rs.getString("CourseCode"));
                course.setCourseName(rs.getString("CourseName"));
                course.setCredits(rs.getInt("Credits"));
                courses.add(course);
            }
        } catch (SQLException e) {
        	System.out.println("Error retrieving all courses."+e.getMessage());
        }
        return courses;
    }
    

    @Override
    public void updateCourse(Course course) {
        String sql = "UPDATE Courses SET CourseCode = ?, CourseName = ?, Credits = ? WHERE CourseId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, course.getCourseCode());
            ps.setString(2, course.getCourseName());
            ps.setInt(3, course.getCredits());
            ps.setInt(4, course.getCourseId());
            ps.executeUpdate();
        } catch (SQLException e) {
        	System.out.println("Error updating course."+e.getMessage());
        }
    }

    @Override
    public void deleteCourse(int courseId) {
        String sql = "DELETE FROM Courses WHERE CourseId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, courseId);
            ps.executeUpdate();
        } catch (SQLException e) {
        	System.out.println("Error deleting course."+e.getMessage());
        }
    }
}
