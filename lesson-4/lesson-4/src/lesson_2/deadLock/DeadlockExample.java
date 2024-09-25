package lesson_2.deadLock;

public class DeadlockExample {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Resource 1 ga ega bo'ldi");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Resource 2 ni olishga harakat qilayabdi");
                synchronized (resource2) {
                    System.out.println("Thread 1: Resource 1 va Resource 2 ni olishga harakat qilayabdi");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Resource 2 ga ega bo'ldi");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Resource 1 ni olishga harakat qilayabdi");
                synchronized (resource1) {
                    System.out.println("Thread 2: Resource 2 va Resource 1 ni olishga harakat qilayabdi");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}