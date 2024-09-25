package lesson_1.myThread;

public class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        try {
            for (int i = 1; i <= 1000; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "An error occurred while terminating: " + e);
        }
        System.out.println(Thread.currentThread().getName() + " finished.");
    }
}
