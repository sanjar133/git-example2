package lesson_1.Runnable;

public class MyRunnable implements Runnable{
    private String runnableName;
    MyRunnable(String name){
        runnableName=name;
        System.out.println("A new thread has been created:"+runnableName);
    }

    @Override
    public void run() {
        System.out.println("Thread started:"+runnableName);
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread: "+runnableName+" time left "+i);
                Thread.sleep(10);
            }
        }catch (InterruptedException e){
            System.out.println(" Terminating the thread resulted in an error: "+e);
        }
        System.out.println(" Thread finished "+runnableName);
    }
}
