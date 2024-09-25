import java.io.File;

public class Exercise1 {

    public static void main(String[] args) {
        String folderPath = "C:\\pdp java";

        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] subFolders = folder.listFiles(File::isDirectory);
            if (subFolders != null) {
                for (File subFolder : subFolders) {
                    long sizeInBytes = calculateFolderSize(subFolder);
                    double sizeInMB = sizeInBytes / (1024.0 * 1024.0);

                    System.out.printf("%s: %.3f MB%n", subFolder.getName(), sizeInMB);
                }
            } else {
                System.out.println("Hech qanday ichki papkalar topilmadi.");
            }
        } else {
            System.out.println("Berilgan katalog mavjud emas yoki papka emas.");
        }
    }

    private static long calculateFolderSize(File folder) {
        long length = 0;

        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    length += file.length();
                } else if (file.isDirectory()) {
                    length += calculateFolderSize(file);
                }
            }
        }
        return length;
    }
}
