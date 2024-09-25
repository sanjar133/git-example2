package lesson_1.myRunnThread;

public class Main {
    public static void main(String[] args) {
        System.out.println("The main thread has started.");

        MyRunnable myRunnable1 = new MyRunnable("Thread-1");
        MyRunnable myRunnable2 = new MyRunnable("Thread-2");

        Thread thread1 = new Thread(myRunnable1);
        Thread thread2 = new Thread(myRunnable2);

        thread1.start();
        thread2.start();

        System.out.println("Thread 1 name: \n" + thread1.getName());
        System.out.println("Thread 2 name: \n" + thread2.getName());

        System.out.println("The main thread has finished.\n");
    }
}
