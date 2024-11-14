package controller;

import dao.CourseDAO;
import dao.CourseDAOImpl;
import model.Course;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AdminController {
    private CourseDAO courseDAO;
    private Scanner scanner;

    public AdminController() throws SQLException {
        courseDAO = new CourseDAOImpl();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Course");
            System.out.println("2. Update Course");
            System.out.println("3. Delete Course");
            System.out.println("4. View All Courses");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    updateCourse();
                    break;
                case 3:
                    deleteCourse();
                    break;
                case 4:
                    viewAllCourses();
                    break;
                case 5:
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addCourse() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter credits: ");
        int credits = scanner.nextInt();
        scanner.nextLine(); 

        Course course = new Course(credits, courseName, courseName, credits);
        course.setCourseCode(courseCode);
        course.setCourseName(courseName);
        course.setCredits(credits);

        courseDAO.addCourse(course);
        System.out.println("Course added successfully.");
    }

    private void updateCourse() {
        System.out.print("Enter course ID to update: ");
        int courseId = scanner.nextInt();
        scanner.nextLine(); 

        Course course = courseDAO.getCourseById(courseId);
        if (course != null) {
            System.out.print("Enter new course code: ");
            String courseCode = scanner.nextLine();
            System.out.print("Enter new course name: ");
            String courseName = scanner.nextLine();
            System.out.print("Enter new credits: ");
            int credits = scanner.nextInt();
            scanner.nextLine(); 

            course.setCourseCode(courseCode);
            course.setCourseName(courseName);
            course.setCredits(credits);

            courseDAO.updateCourse(course);
            System.out.println("Course updated successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    private void deleteCourse() {
        System.out.print("Enter course ID to delete: ");
        int courseId = scanner.nextInt();
        scanner.nextLine(); 

        courseDAO.deleteCourse(courseId);
        System.out.println("Course deleted successfully.");
    }

    private void viewAllCourses() {
        List<Course> courses = courseDAO.getAllCourses();
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}
