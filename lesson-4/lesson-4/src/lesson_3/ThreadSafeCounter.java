package lesson_3;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeCounter {

    private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public void increment(String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public int getCount(String key) {
        return map.getOrDefault(key, 0);
    }

    public void decrement(String key) {
        map.put(key, map.getOrDefault(key, 0) - 1);
    }

    public static void main(String[] args) {
        ThreadSafeCounter counter = new ThreadSafeCounter();
        counter.increment("A");
        counter.increment("B");
        counter.increment("C");
        System.out.println(counter.getCount("B"));
    }
}