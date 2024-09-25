package lesson_6;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeAPIExamples {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current date: " + currentDate);

        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        System.out.println("Current time: " + formattedTime);
    }
}