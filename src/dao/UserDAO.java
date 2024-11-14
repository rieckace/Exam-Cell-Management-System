package dao;

import model.User;
import java.util.List;

public interface UserDAO {
	void createUser(User user);
	User getUserById(int userId);
	User authenticateUser(String username, String password);
	void deleteUser(int userId);
	List<User> getAllUsers(); void updateUser(User user);
}
