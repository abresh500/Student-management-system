public class Main {
    public static void main(String[] args) {

        StudentManager.addStudent(new Student(1, "Abenezer", "SWE", 3.8));
        StudentManager.addStudent(new Student(2, "abrham", "ITS", 3.5));

        System.out.println("All Students:");
        StudentManager.displayAll();

        System.out.println("\nSearch ID 1:");
        System.out.println(StudentManager.search(1));

        StudentManager.updateStudent(1, "Abraham Updated", "SWE", 3.9);

        System.out.println("\nAfter Update:");
        StudentManager.displayAll();

        StudentManager.deleteStudent(2);

        System.out.println("\nAfter Delete:");
        StudentManager.displayAll();

        System.out.println("\nReport:");
        Report.generate();

        FileUtil.showFileInfo("data/students.ser");

        FileUtil.backupFile("data/students.ser", "data/backup.ser");
    }
}//