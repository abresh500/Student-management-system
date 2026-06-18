import java.io.*;

public class FileUtil {

    public static void showFileInfo(String path) {
        File file = new File(path);

        if (file.exists()) {
            System.out.println("Name: " + file.getName());
            System.out.println("Path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length() + " bytes");
            System.out.println("last modified: " + file.lastModified());
        }
    }

    public static void backupFile(String source, String dest) {
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))
        ) {
            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
            System.out.println("Backup completed.");
        } catch (IOException e) {
            System.out.println("Backup failed.");
        }
    }
}