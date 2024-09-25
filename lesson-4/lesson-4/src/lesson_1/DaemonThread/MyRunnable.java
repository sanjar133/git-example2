package lesson_1.DaemonThread;

public class MyRunnable implements Runnable{
    public void run(){
        while (true){
            System.out.println("Daemon thread started:");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("An error occurred while stopping the daemon thread: "+e);
            }
        }
    }
}
