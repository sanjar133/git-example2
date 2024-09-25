package lesson_6;
import java.util.Timer;
import java.util.TimerTask;

public class TodoApp {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task time reached!");
            }
        }, 5000);
    }
}