package lesson_5;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task completed asynchronously");
        });

        future.join();
    }
}