import java.util.Scanner;

public class Main2 {
    static Human humans[] = new Human[5];
    static int index = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int step = 1;

        while (step != 0) {
            System.out.println("1.Add Human 2.Print Human 3.Delete Human 4.Update Human 0.Exit");
            step = scanner.nextInt();
            switch (step) {
                case 1: addHuman(); break;
                case 2: printHuman(); break;
                case 3: deleteHuman(); break;
                case 4: updateHuman(); break;
            }
        }
    }

    public static void addHuman() {
            Scanner scanner1 = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);
            Human human = new Human();
            System.out.println("First name: ");
            human.name = scanner1.nextLine();
            System.out.println("Last name: ");
            human.lastName = scanner2.nextLine();
            System.out.println("Age: ");
            human.age = scanner2.nextInt();

            humans[index ++] = human;
    }
    public static void printHuman() {
        for (int i = 0; i < humans.length; i++) {
            if (humans[i] != null) {
                System.out.println("Human: " + (i + 1));
                System.out.println(humans[i].toString() + "\n");
            }
        }
    }
    public static void deleteHuman() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which user you want delete ?");
        int deleteIndex = scanner.nextInt();

        if (deleteIndex >= 0 && deleteIndex < index) {
            for (int i = deleteIndex; i < index; i++) {
                humans[i] = humans[i + 1];
            }
            index --;
        }else {
            System.out.println("Invalid index");
        }
    }

    public static void updateHuman() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Which user you want to update?");
        int updateIndex = scanner.nextInt();

        if (updateIndex >= 0 && updateIndex < index) {
            System.out.print("Name: ");
            humans[updateIndex].name = scanner1.nextLine();
            System.out.print("Last name: ");
            humans[updateIndex].lastName = scanner1.nextLine();
            System.out.print("Age: ");
            humans[updateIndex].age = scanner.nextInt();
        }else {
            System.out.println("invalid user index");
        }
    }

}
