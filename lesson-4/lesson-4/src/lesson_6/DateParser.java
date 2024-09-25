package lesson_6;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

    public static void main(String[] args) {
        String dateString = "2024-05-05";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(dateString);
            System.out.println("Parsed Date: " + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}