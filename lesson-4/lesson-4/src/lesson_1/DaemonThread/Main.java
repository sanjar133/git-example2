package lesson_1.DaemonThread;

public class Main {
    public static void main(String[] args) {
        System.out.println("Asosiy thread boshlandi.");

        Thread daemonThread = new Thread(new MyRunnable());
        daemonThread.setDaemon(true);
        daemonThread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Asosiy threadni to'xtatishda xatolik yuzaga keldi: " + e);
        }

        System.out.println("Asosiy thread tugatildi. Daemon thread ham to'xtadi.");

    }
}
