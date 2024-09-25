package lesson_1.myThread;

public class Main {
    public static void main(String[] args) {
        System.out.println("Basic thread is started");
        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");
        MyThread thread3 = new MyThread("Thread-3");


        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);


        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Basic thread is finished");
    }
}
