import java.lang.reflect.AnnotatedType;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {

        AtomicLong atomicLong = new AtomicLong(0L);

        Counter counter = new Counter();

        Runnable task = () -> {

            counter.counter();

            System.out.println("Finished: : " + counter);

        };

        for (int i = 0; i < 1000; i++) {

            atomicLong.incrementAndGet(counter.setSum());

        }

    }
}