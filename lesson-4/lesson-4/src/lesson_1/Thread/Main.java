package lesson_1.Thread;

public class Main {
    public static void main(String[] args) {
        System.out.println("Asosiy kodlarni boshladik");
        MyThread thread1=new MyThread("Thread-1");
        MyThread thread2=new MyThread("Thread-2");

        thread1.start();
        thread2.start();
        System.out.println("Asosiy kod tugadi sog' bulasila suuuuuuuuu");
    }
}
