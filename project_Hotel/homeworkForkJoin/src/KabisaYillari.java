import java.util.Scanner;

public class KabisaYillari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Birinchi yil: ");
        int year1 = scanner.nextInt();

        System.out.print("Ikkinchi yil: ");
        int year2 = scanner.nextInt();

        System.out.println("Kabisa yillari:");

        int start = Math.min(year1, year2);
        int end = Math.max(year1, year2);

        for (int year = start; year <= end; year++) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println(year);
            }
        }

        scanner.close();
    }
}
