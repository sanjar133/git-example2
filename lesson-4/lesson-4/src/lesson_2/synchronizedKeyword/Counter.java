package lesson_2.synchronizedKeyword;

public class Counter {
    private int sum = 0;

    public synchronized void counter() {
        setSum(getSum() + 1);
    }

    // Standard getters and setters
    public synchronized int getSum() {
        return sum;
    }

    public synchronized void setSum(int sum) {
        this.sum = sum;
    }
}
