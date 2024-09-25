package lesson_1.Thread;

public class MyThread extends Thread{
    private String threadName;
    MyThread(String name){
        threadName=name;
        System.out.println("A new thread has been created:"+threadName);
    }

    @Override
    public void run() {
        System.out.println("Thread started:"+threadName);
        try {
            for (int i = 5; i > 0; i++) {
                System.out.println("Thread: "+threadName+" time left "+i);
                Thread.sleep(1);
            }
        }catch (InterruptedException e){
            System.out.println(" Terminating the thread resulted in an error: "+e);
        }
        System.out.println(" Thread finished "+threadName);
    }
}
