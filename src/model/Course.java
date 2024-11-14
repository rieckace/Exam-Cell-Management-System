package model;


public class Course {
	
	private int courseId;
    private String courseCode;
    private String courseName;
    private int credits;
    
//    COnstructors
	public Course(int courseId, String courseName, String courseCode, int credits) {
	super();
	this.courseId = courseId;
	this.courseCode = courseCode;
	this.courseName = courseName;
	this.credits = credits;
}

	// Getters and Setters
	public int getCourseId() {
		return courseId;
	}
	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
    



    
}
