package lesson_2.S_Metod_Bloklar;
public class Counter {
    private int sum = 0;

    public void counter() {
        synchronized (this) {
            sum++;
        }
    }

    public int getSum() {
        synchronized (this) {
            return sum;
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        System.out.println("Current value: " + counter.getSum());

        for (int i = 0; i < 30; i++) {
            counter.counter();
        }
        System.out.println("New value: " + counter.getSum());
    }
}