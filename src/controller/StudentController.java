package controller;

import dao.MarkDAO;
import dao.MarksDAOImpl;
import model.Mark;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    private MarkDAO marksDAO;
    private Scanner scanner;

    public StudentController() throws SQLException {
        marksDAO = new MarksDAOImpl();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. View My Marks");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    viewMyMarks();
                    break;
                case 2:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewMyMarks() {
        System.out.print("Enter Your Student ID: ");
        int studentId = scanner.nextInt();
        List<Mark> marksList = marksDAO.getMarksByStudentId(studentId);
        for (Mark marks : marksList) {
            System.out.println(marks);
        }
    }
}
