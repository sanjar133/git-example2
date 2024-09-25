import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.List;
import java.util.ArrayList;

public class TaskExecutor {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        String task1 = "Task 1";
        String task2 = "Task 2";

        Callable<Boolean> checkTask1Callable = () -> checkTask1(task1);
        Callable<Boolean> checkTask2Callable = () -> checkTask2(task2);

        Future<Boolean> validTask1Future = executorService.submit(checkTask1Callable);
        Future<Boolean> validTask2Future = executorService.submit(checkTask2Callable);

        System.out.println(validTask1Future.isDone());
        System.out.println(validTask2Future.isDone());

        while (!validTask1Future.isDone() && !validTask2Future.isDone()) {
            Thread.sleep(100);
        }

        System.out.println(validTask1Future.isDone());
        System.out.println(validTask2Future.isDone());




        executorService.shutdown();
    }

    private static boolean checkTask1(String task1) {

        try {
            System.out.println("Started task 1 checking....");
            Thread.sleep(2000);
            System.out.println("Completed task 1 checking....");
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean checkTask2(String task2) {

        try {
            System.out.println("Started task 2 checking....");
            Thread.sleep(2000);
            System.out.println("Completed task 2 checking....");
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
