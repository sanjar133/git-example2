import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.print("Tug'ilgan sana (yyyy-MM-dd HH:mm:ss): ");
        String inputDate = scanner.nextLine();

        LocalDateTime birthDate = LocalDateTime.parse(inputDate, formatter);
        LocalDateTime currentDate = LocalDateTime.now();

        Duration duration = Duration.between(birthDate, currentDate);

        long years = duration.toDays() / 365;
        long months = (duration.toDays() % 365) / 30;
        long days = (duration.toDays() % 365) % 30;
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        System.out.println("Siz " + years + " yil, " + months + " oy, " + days + " kun, " +
                hours + " soat, " + minutes + " minut, " + seconds + " soniya yashagansiz.");

        scanner.close();
    }
}
