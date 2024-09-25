import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.lang.Math.random;

public class TaskExecutor {

    public static void main(String[] args) {

        Random random = new Random();

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        List<Future<Integer>>

        for (int i = 0; i < 5; i++) {

            int finalI = i;
            int time = random.nextInt(6);
            System.out.println("Time is : " + time);
            Future<Integer> submit = executorService.submit(() -> generationNumber(
                    finalI + "-vazifa",
                    time
            ));

        }

        System.out.println("Overall time is ");
    }

    private static Integer generationNumber(String name, int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
            System.out.println(name + " -> completed");
            return new Random().nextInt(11);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
