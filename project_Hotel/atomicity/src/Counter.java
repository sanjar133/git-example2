import java.util.concurrent.atomic.AtomicLong;

public class Counter {

    private int sum = 0;

    public void counter() {
        setSum(getSum() + 1);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
