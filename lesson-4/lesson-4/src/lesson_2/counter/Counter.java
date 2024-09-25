package lesson_2.counter;

public class Counter {
    private int count;

    public Counter(){
        count=0;
    }
    public void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
