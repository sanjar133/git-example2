public class Main {
    public static void main(String[] args) {

        Human sanjar = new Human();
        System.out.println(sanjar.age);
        sanjar.name = "Sanjar";
        sanjar.lastName = "Shonazarov";
        sanjar.age = 20;

        System.out.println(sanjar.toString());
    }
}