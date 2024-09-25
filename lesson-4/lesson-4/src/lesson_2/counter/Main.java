package lesson_2.counter;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        System.out.println("The value we have: "+counter.getCount());
        counter.increment();

        System.out.println("New values: "+counter.getCount());
    }
}
