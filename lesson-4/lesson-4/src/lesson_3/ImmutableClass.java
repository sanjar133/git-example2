package lesson_3;
public final class ImmutableClass {

    private final int value;

    public ImmutableClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        ImmutableClass obj = new ImmutableClass(12);
        System.out.println(obj.getValue());
    }
}