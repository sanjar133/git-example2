package lesson_4;
import java.util.concurrent.*;

public class TaskExecutor {

    private final ExecutorService executor;

    public TaskExecutor() {
        executor = Executors.newSingleThreadExecutor();
    }

    public void executeRunnable(Runnable task) {
        executor.execute(task);
    }

    public <T> Future<T> executeCallable(Callable<T> task) {
        return executor.submit(task);
    }

    public <T> void executeAndCheckResult(Callable<T> task) {
        Future<T> future = executor.submit(task);
        try {
            T result = future.get();
            System.out.println("Task completed successfully. Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Task execution failed: " + e.getMessage());
        }
    }

    public <T> void executeAndCheckResult(Callable<T> task, long timeout, TimeUnit unit) {
        Future<T> future = executor.submit(task);
        try {
            T result = future.get(timeout, unit);
            System.out.println("Task completed successfully. Result: " + result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.err.println("Task execution failed: " + e.getMessage());
        }
    }

    public static class UserContext {
        private static final ThreadLocal<String> userThreadLocal = new ThreadLocal<>();

        public static void setCurrentUser(String username) {
            userThreadLocal.set(username);
        }

        public static String getCurrentUser() {
            return userThreadLocal.get();
        }

        public static void clearCurrentUser() {
            userThreadLocal.remove();
        }
    }

    public static void main(String[] args) {
        TaskExecutor taskExecutor = new TaskExecutor();

        taskExecutor.executeRunnable(() -> System.out.println("Hello from Runnable task"));

        taskExecutor.executeAndCheckResult(() -> {
            Thread.sleep(1000);
            return "Result from Callable task";
        });

        taskExecutor.executeAndCheckResult(() -> {
            Thread.sleep(1000);
            return "Result from Callable task with timeout";
        }, 2, TimeUnit.SECONDS);

        UserContext.setCurrentUser("John");
        System.out.println("Current user: " + UserContext.getCurrentUser());
        UserContext.clearCurrentUser();
    }
}