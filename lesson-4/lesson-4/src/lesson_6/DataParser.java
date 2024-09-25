package lesson_6;
import java.time.LocalDate;

class dateParser {

    public static void main(String[] args) {
        String dateString = "2024-07-08";
        LocalDate date = LocalDate.parse(dateString);
        System.out.println("Parsed LocalDate: " + date);
    }
}