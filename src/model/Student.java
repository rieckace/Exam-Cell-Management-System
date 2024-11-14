package model;

public class Student {
    private int studentId;
    private String name;
    private String rollNo;
    private String department;
    
    
//    Constructors
    public Student(int id, String name,String roll, String department) {
    	this.studentId = id;
    	this.name = name;
    	this.rollNo = roll;
    	this.department = department;
    }

    // Getters and Setters
    
    public int getStudentId() {
    	return studentId;
    }
    
    public void setStudentId(int id) {
    	this.studentId = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRollNumber() {
		return rollNo;
	}
    
    
}
