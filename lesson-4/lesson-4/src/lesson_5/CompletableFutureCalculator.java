package lesson_5;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureCalculator {

    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10 * 5;
        });

        future.thenAccept(result -> System.out.println("Result: " + result));
    }
}