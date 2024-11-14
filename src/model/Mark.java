package model;

public class Mark {
    private int markId;
    private int studentId;
    private int courseId;
    private int marksObtained;
    private int maxMarks;

//    Constructors
    
	public Mark(int markId, int studentId, int courseId, int marksObtained, int maxMarks) {
		super();
		this.markId = markId;
		this.studentId = studentId;
		this.courseId = courseId;
		this.marksObtained = marksObtained;
		this.maxMarks = maxMarks;
	}
	
	// Getters and Setters

	public int getMarkId() {
    	return markId;
    }
    
    public void setMarkId(int markId) {
    	this.markId = markId;
    }

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}
    
}
