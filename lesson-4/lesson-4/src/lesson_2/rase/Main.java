package lesson_2.rase;

import lesson_2.S_Metod_Bloklar.Counter;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        System.out.println("Current Value: " + counter.getSum());

        for (int i = 0; i < 30; i++) {
            counter.counter();
        }
        System.out.println("New Value: " + counter.getSum());
    }
}
