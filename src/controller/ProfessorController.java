package controller;

import dao.MarkDAO;
import dao.MarksDAOImpl;
import model.Mark;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProfessorController {
    private MarkDAO marksDao;
    private Scanner scanner;

    public ProfessorController() throws SQLException {
        marksDao = new MarksDAOImpl();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n--- Professor Menu ---");
            System.out.println("1. Input Marks");
            System.out.println("2. Update Marks");
            System.out.println("3. View Marks by Student ID");
            System.out.println("4. View Marks by Course ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    inputMarks();
                    break;
                case 2:
                    updateMarks();
                    break;
                case 3:
                    viewMarksByStudentId();
                    break;
                case 4:
                    viewMarksByCourseId();
                    break;
                case 5:
                    System.out.println("Exiting.....");
                case 0:
                	utility.DBConnection.closeConnection(null);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void inputMarks() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter Course ID: ");
        int courseId = scanner.nextInt();
        System.out.print("Enter Marks Obtained: ");
        int marksObtained = scanner.nextInt();
        System.out.print("Enter Max Marks: ");
        int maxMarks = scanner.nextInt();

        Mark marks = new Mark(maxMarks, maxMarks, maxMarks, maxMarks, maxMarks);
        marks.setStudentId(studentId);
        marks.setCourseId(courseId);
        marks.setMarksObtained(marksObtained);
        marks.setMaxMarks(maxMarks);

        marksDao.addMarks(marks);
        System.out.println("Marks added successfully.");
    }

    private void updateMarks() {
        System.out.print("Enter Mark ID to update: ");
        int markId = scanner.nextInt();
        System.out.print("Enter new Marks Obtained: ");
        int marksObtained = scanner.nextInt();
        System.out.print("Enter new Max Marks: ");
        int maxMarks = scanner.nextInt();

        Mark marks = new Mark(maxMarks, maxMarks, maxMarks, maxMarks, maxMarks);
        marks.setMarkId(markId);
        marks.setMarksObtained(marksObtained);
        marks.setMaxMarks(maxMarks);

        marksDao.updateMarks(marks);
        System.out.println("Marks updated successfully.");
    }

    private void viewMarksByStudentId() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        List<Mark> marksList = marksDao.getMarksByStudentId(studentId);
        for (Mark marks : marksList) {
            System.out.println(marks);
        }
    }

    private void viewMarksByCourseId() {
        System.out.print("Enter Course ID: ");
        int courseId = scanner.nextInt();
        List<Mark> marksList = marksDao.getMarksByCourseId(courseId);
        for (Mark marks : marksList) {
            System.out.println(marks);
        }
    }
}
