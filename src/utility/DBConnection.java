package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ExamCell";
    private static final String USER = "root"; 
    private static final String PASS = "72637445"; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
        
    }
    
    
	public static void closeConnection(Connection con) {
		if (con != null) {
            System.out.println("Connection Established");
        } else {
            System.out.println("Connection failed to establish");
        }
		
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				System.out.println("Error Closing Connection"+ e.getMessage());
			}
		}
	}
}
