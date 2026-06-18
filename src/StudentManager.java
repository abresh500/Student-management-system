import java.io.*;
import java.util.*;

public class StudentManager {
    private static final String filenameee = "data/students.ser";

    // Create directory automatically
    static {
        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    public static void addStudent(Student s) {
        List<Student> students = readAll();
        students.add(s);
        writeAll(students);
    }

    public static List<Student> readAll() {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filenameee))) {
            students = (List<Student>) ois.readObject();
        } catch (Exception e) {
        }
        return students;
    }

    public static void writeAll(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filenameee))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    public static Student search(int id) {
        for (Student s : readAll()) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public static void updateStudent(int id, String name, String dept, double gpa) {
        List<Student> students = readAll();
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setDepartment(dept);
                s.setGpa(gpa);
            }
        }
        writeAll(students);
    }

    public static void deleteStudent(int id) {
        List<Student> students = readAll();
        students.removeIf(s -> s.getId() == id);
        writeAll(students);
    }

    public static void displayAll() {
        for (Student s : readAll()) {
            System.out.println(s);
        }
    }
}