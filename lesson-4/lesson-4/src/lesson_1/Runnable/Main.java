package lesson_1.Runnable;

import lesson_1.Thread.MyThread;

public class Main {
    public static void main(String[] args) {
        System.out.println("MAin thread started");

        MyRunnable myRunnable1 = new MyRunnable("Thread -1");
        MyRunnable myRunnable2 = new MyRunnable("Thread -2");
        MyRunnable myRunnable3 = new MyRunnable("Thread -3");

        Thread thread1 = new Thread(myRunnable1);
        Thread thread2 = new Thread(myRunnable2);
        Thread thread3 = new Thread(myRunnable3);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("main thread finished:");
    }
}
