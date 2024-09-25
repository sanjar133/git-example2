package lesson_6;
import java.time.LocalTime;

public class CurrentTimePrinter {

    public static void main(String[] args) {
        while (true) {
            LocalTime currentTime = LocalTime.now();
            System.out.println("Current time: " + currentTime);
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}