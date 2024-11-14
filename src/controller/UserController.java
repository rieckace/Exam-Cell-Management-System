package controller;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserController {
    private UserDAO userDao;
    private Scanner scanner;

    public UserController() throws SQLException {
        userDao = new UserDAOImpl();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("User Management Menu:");
            System.out.println("1. Add New User");
            System.out.println("2. Update User");
            System.out.println("3. Delete User");
            System.out.println("4. View All Users");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    viewAllUsers();
                    break;
                case 5:
                    System.out.println("Exiting User Management Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void addUser() {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Role (admin/professor/student): ");
        String role = scanner.nextLine();
        User user = new User(0, username, password, role); // UserId is auto-incremented by the database
        userDao.createUser(user);
        System.out.println("User added successfully.");
    }

    private void updateUser() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        User user = userDao.getUserById(userId);
        if (user != null) {
            System.out.print("Enter New Username: ");
            user.setUsername(scanner.nextLine());
            System.out.print("Enter New Password: ");
            user.setPassword(scanner.nextLine());
            System.out.print("Enter New Role: ");
            user.setRole(scanner.nextLine());
            userDao.updateUser(user);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    private void deleteUser() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        userDao.deleteUser(userId);
        System.out.println("User deleted successfully.");
    }

    private void viewAllUsers() {
        List<User> users = userDao.getAllUsers();
        System.out.println("All Users:");
        for (User user : users) {
            System.out.println("ID: " + user.getUserId() + ", Username: " + user.getUsername() + ", Role: " + user.getRole());
        }
    }
}
