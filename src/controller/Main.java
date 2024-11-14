package controller;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDAO userDao = new UserDAOImpl();
        Scanner sc = new Scanner(System.in);

        System.out.println("***Welcome to the Exam Cell Management System**");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User user = userDao.authenticateUser(username, password);

        if (user != null) {
            System.out.println("Login successful. Role: " + user.getRole());
            switch (user.getRole().toLowerCase()) {
                case "user":
                    UserController userController = new UserController();
                    userController.displayMenu();
                    break;
                case "admin":
                    AdminController adminController = new AdminController();
                    adminController.displayMenu();
                    break;
                case "professor":
                    ProfessorController professorController = new ProfessorController();
                    professorController.displayMenu();
                    break;
                case "student":
                    StudentController studentController = new StudentController();
                    studentController.displayMenu();
                    break;
                default:
                    System.out.println("Invalid role.");
            }
        } else {
            System.out.println("Authentication failed. Please check your username and password.");
        }
    }
}
