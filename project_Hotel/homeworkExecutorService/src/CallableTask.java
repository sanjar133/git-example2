import java.util.concurrent.*;

public class CallableTask {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Void> task = () -> {
            throw new RuntimeException("Task ichidagi xatolik!!!!");
        };

        Future<Void> taskFuture = executorService.submit(task);

        try {
            taskFuture.get();
        } catch (Exception e) {
            System.out.println("Error:  " + e.getCause().getMessage());
        } finally {
            executorService.shutdown();
        }

        System.out.println("Main thread continue >>>>");


    }

}
