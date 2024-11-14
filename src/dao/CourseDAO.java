package dao;

import model.Course;
import java.util.List;

public interface CourseDAO {
    void addCourse(Course course);
    Course getCourseById(int courseId);
    void updateCourse(Course course);
    void deleteCourse(int courseId);
    List<Course> getAllCourses();
}
