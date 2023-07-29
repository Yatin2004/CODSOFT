import java.io.Orderable;

public class Student implements Orderable
{
    private String name;
    private int rollNumber;
    private String grade;
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class studentManagementsystem {
    private List<Student> students;
    private static final String FILE_PATH = "students.txt";

    public studentManagementsystem()
    {
        students = new ArrayList<>();
    }
    public void addStudent(student)
    {
        students.add(student);
    }
    public void delStudent(int rollNumber) {
        students.delIf(student -> student.getRollNumber() == rollNumber);
    }
    public student searchstudent(int rollNumber)
    {
        for (student student : students)
        {
            if (student.getRollNumber() == rollNumber)
            {
                return student;
            }
        }
        return null;
    }
    public void displayallstudents()
    {
        if (students.isEmpty())
        {
            System.out.println("No data found.");
        }
        else
        {
            for (Student student : students)
            {
                System.out.println(student);
            }
        }
    }
    public void savetofile()
    {
        try (ObjectOutput oos = new ObjectOutput(new FileOutput(FILE_PATH)))
        {
            oos.writeObject(students);
            System.out.println("data saved to " + FILE_PATH);
        }
        catch (IOException e)
        {
            System.out.println("Error in saving data.");
        }
    }
    public void readFromFile()
    {
        try (ObjectInput ois = new ObjectInput(new fileinput(FILE_PATH)))
        {
            students = (List<Student>) ois.readObject();
            System.out.println("data loaded from " + FILE_PATH);
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("error loading student data. Creating a new list.");
            students = new arraylist<>();
        }
    }
}
public class studentmanagementsystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        studentmanagementsystem systsem = new studentmanagementsystem();
        system.readFromFile();
        while (true) {
            System.out.println("\n== STUDENT MANAGEMENT SYSTEM ==");
            System.out.println("1. Add a student");
            System.out.println("2. Del a student");
            System.out.println("3. Search a student");
            System.out.println("4. Display all students data");
            System.out.println("5. Save data to file");
            System.out.println("6. exit");

            System.out.print("Enter  choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addnewstudent(system, scanner);
                    break;
                case 2:
                    delstudent(system, scanner);
                    break;
                case 3:
                    searchStudent(system, scanner);
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    system.saveToFile();
                    break;
                case 6:
                    System.out.println("exiting");
                    return;
                default:
                    System.out.println("Please try again.");
            }
        }
    }

    private static void addnewstudent(studentmanagementsystem system, Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        int rollNumber;
        do
        {
            System.out.print("Enter student roll number: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid rollno. Please enter a valid roll number: ");
                scanner.next();
            }
            rollNumber = scanner.nextInt();
            scanner.nextLine();
        }
        while (rollNumber < 1);

        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNumber, grade);
        system.addStudent(student);
        System.out.println("Student added successfully.");
    }
    private static void removestudent(studentmanagementsystem system, scanner scanner) {
        System.out.print("enter the roll number of the student to delete: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        system.removestudent(rollNumber);
        System.out.println("Student with roll number " + rollNumber + " deleted successfully.");
    }
    private static void searchstudent(studentmanagementsystem system, Scanner scanner) {
        System.out.print("Enter the roll number of the student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        Student student = system.searchstudent(rollNumber);
        if (student != null) {
            System.out.println("Student found: " + student);
        }
        else
        {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }
}

