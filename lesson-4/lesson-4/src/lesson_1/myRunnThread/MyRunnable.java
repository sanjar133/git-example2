package lesson_1.myRunnThread;

public class MyRunnable implements Runnable{
    private String threadName;

    public MyRunnable(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Thread started: " + threadName);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Terminating the thread resulted in an error: " + e);
        }
        System.out.println("Thread is finished: " + threadName);
    }
}
