package model;

public class User {
    private int userId;
    private String username;
    private String password;
    private String role;
    
    
//    CONSTRUCTORS
	public User(int userId, String username, String password, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
    // Getters and Setters
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		
		return role;
	}

   
}