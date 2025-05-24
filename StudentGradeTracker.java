import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Student Grade Tracker ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Show Grade Summary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> showSummary();
                case 4 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        students.add(new Student(name, grade));
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println("Name: " + s.name + ", Grade: " + s.grade);
        }
    }

    private static void showSummary() {
        if (students.isEmpty()) {
            System.out.println("No data to summarize.");
            return;
        }

        double total = 0, max = Double.MIN_VALUE, min = Double.MAX_VALUE;

        for (Student s : students) {
            total += s.grade;
            if (s.grade > max) max = s.grade;
            if (s.grade < min) min = s.grade;
        }

        double average = total / students.size();

        System.out.println("\n--- Grade Summary ---");
        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + max);
        System.out.println("Lowest Grade: " + min);
    }
}
