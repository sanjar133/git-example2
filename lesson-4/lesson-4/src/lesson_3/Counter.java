package lesson_3;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private AtomicInteger sum = new AtomicInteger(0);

    public void counter() {
        sum.incrementAndGet();
    }

    public int getSum() {
        return sum.get();
    }
}