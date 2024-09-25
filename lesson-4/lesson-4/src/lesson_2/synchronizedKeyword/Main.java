package lesson_2.synchronizedKeyword;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        System.out.println("Current vallue: " + counter.getSum());

        for (int i = 0; i < 3; i++) {
            counter.counter();
        }
        System.out.println("New value: " + counter.getSum());

    }
}
