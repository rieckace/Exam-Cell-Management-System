package dao;

import model.User;
import utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl() throws SQLException {
        connection = DBConnection.getConnection();
    }

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO Users (Username, Password, Role) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Error creating user: "+ e.getMessage());
        }
    }

    @Override
    public User getUserById(int userId) {
        String sql = "SELECT * FROM Users WHERE UserId = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                User user = new User(userId, sql, sql, sql);
                user.setUserId(rs.getInt("UserId"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setRole(rs.getString("Role"));
                return user;
            }
        } catch (SQLException e) {
        	System.err.println("Error getting specific  user: "+ e.getMessage());
        }
        return null;
    }

    @Override
    public User authenticateUser(String username, String password) {
        String sql = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                User user = new User(0, sql, sql, sql);
                user.setUserId(rs.getInt("UserId"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setRole(rs.getString("Role"));
                return user;
            }
        } catch (SQLException e) {
        	System.err.println("Error authenticating user: "+ e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User(0, sql, sql, sql);
                user.setUserId(rs.getInt("UserId"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setRole(rs.getString("Role"));
                users.add(user);
            }
        } catch (SQLException e) {
        	System.err.println("Error retrieving user: "+ e.getMessage());
        }
        return users;
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE Users SET Username = ?, Password = ?, Role = ? WHERE UserId = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.setInt(4, user.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Error updating user: "+ e.getMessage());
        }
    }

    @Override
    public void deleteUser(int userId) {
        String sql = "DELETE FROM Users WHERE UserId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
        	System.err.println("Error deleting user: "+ e.getMessage());
        }
    }
}
