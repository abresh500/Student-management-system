import java.util.*;

public class Report {

    public static void generate() {
        List<Student> students = StudentManager.readAll();

        if (students.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        double total = 0;
        double max = students.get(0).getGpa();
        double min = students.get(0).getGpa();

        for (Student s : students) {
            double gpa = s.getGpa();
            total += gpa;
            if (gpa > max) max = gpa;
            if (gpa < min) min = gpa;
        }

        System.out.println("total Students: " + students.size());
        System.out.println("highest GPA: " + max);
        System.out.println("lowest GPA: " + min);
        System.out.println("average GPA: " + (total / students.size()));
    }
}