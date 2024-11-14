package dao;

import model.Mark;
import java.util.List;

public interface MarkDAO {
    void addMarks(Mark marks);
    Mark getMarksById(int markId);
    void updateMarks(Mark marks);
    void deleteMarks(int markId);
    List<Mark> getMarksByStudentId(int studentId);
    List<Mark> getMarksByCourseId(int courseId);
    List<Mark> getAllMarks();
}





