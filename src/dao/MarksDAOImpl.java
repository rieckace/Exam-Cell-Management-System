package dao;

import model.Mark;
import utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarksDAOImpl implements MarkDAO {
    private Connection connection;

    public MarksDAOImpl() throws SQLException {
        connection = DBConnection.getConnection();
    }

    @Override
    public void addMarks(Mark marks) {
        String sql = "INSERT INTO Marks (StudentId, CourseId, MarksObtained, MaxMarks) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, marks.getStudentId());
            ps.setInt(2, marks.getCourseId());
            ps.setInt(3, marks.getMarksObtained());
            ps.setInt(4, marks.getMaxMarks());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Mark getMarksById(int markId) {
        String sql = "SELECT * FROM Marks WHERE MarkId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, markId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Mark marks = new Mark(markId, markId, markId, markId, markId);
                marks.setMarksObtained(rs.getInt("MarkId"));
                marks.setStudentId(rs.getInt("StudentId"));
                marks.setCourseId(rs.getInt("CourseId"));
                marks.setMarksObtained(rs.getInt("MarksObtained"));
                marks.setMaxMarks(rs.getInt("MaxMarks"));
                return marks;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Mark> getMarksByStudentId(int studentId) {
        List<Mark> marksList = new ArrayList<>();
        String sql = "SELECT * FROM Marks WHERE StudentId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mark marks = new Mark(studentId, studentId, studentId, studentId, studentId);
                marks.setMarksObtained(rs.getInt("MarkId"));
                marks.setStudentId(rs.getInt("StudentId"));
                marks.setCourseId(rs.getInt("CourseId"));
                marks.setMarksObtained(rs.getInt("MarksObtained"));
                marks.setMaxMarks(rs.getInt("MaxMarks"));
                marksList.add(marks);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    @Override
    public List<Mark> getMarksByCourseId(int courseId) {
        List<Mark> marksList = new ArrayList<>();
        String sql = "SELECT * FROM Marks WHERE CourseId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mark marks = new Mark(courseId, courseId, courseId, courseId, courseId);
                marks.setMarksObtained(rs.getInt("MarkId"));
                marks.setStudentId(rs.getInt("StudentId"));
                marks.setCourseId(rs.getInt("CourseId"));
                marks.setMarksObtained(rs.getInt("MarksObtained"));
                marks.setMaxMarks(rs.getInt("MaxMarks"));
                marksList.add(marks);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    @Override
    public List<Mark> getAllMarks() {
        List<Mark> marksList = new ArrayList<>();
        String sql = "SELECT * FROM Marks";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Mark marks = new Mark(0, 0, 0, 0, 0);
                marks.setMarksObtained(rs.getInt("MarkId"));
                marks.setStudentId(rs.getInt("StudentId"));
                marks.setCourseId(rs.getInt("CourseId"));
                marks.setMarksObtained(rs.getInt("MarksObtained"));
                marks.setMaxMarks(rs.getInt("MaxMarks"));
                marksList.add(marks);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marksList;
    }

    @Override
    public void updateMarks(Mark marks) {
        String sql = "UPDATE Marks SET StudentId = ?, CourseId = ?, MarksObtained = ?, MaxMarks = ? WHERE MarkId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, marks.getStudentId());
            ps.setInt(2, marks.getCourseId());
            ps.setInt(3, marks.getMarksObtained());
            ps.setInt(4, marks.getMaxMarks());
            ps.setInt(5, marks.getMarkId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMarks(int markId) {
        String sql = "DELETE FROM Marks WHERE MarkId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, markId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
