import model.Human;
import service.HumanService;

import java.util.Scanner;

public class Main {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stepCode = 10;

        HumanService humanService = new HumanService();
        while (stepCode != 0) {
            System.out.println("1. Add Human. 2. Print Humans. 3.Delete Human. 4.Update Human. 0. Exit.");
            stepCode = scanner.nextInt();

            switch (stepCode) {
                case 1 -> {
                    Human human = createHuman();
                    humanService.addHuman(human);
                }
                case 2 -> {
                    Human humans[] = humanService.getHumans();
                    printHumans(humans);
                }
                case 3 -> {
                    System.out.print("Which human you want to delete: ");
                    String nameToDelete = scannerStr.nextLine();
                    humanService.deleteHuman(nameToDelete);
                }
                case 4-> {
                    System.out.print("Which human you want to update: ");
                    String nameToUpdate = scannerStr.nextLine();
                    humanService.updateHuman(nameToUpdate);
                }
            }
        }
    }

    public static Human createHuman() {
        Human human = new Human();

        System.out.println("Enter name: ");
        human.name = scannerStr.nextLine();

        System.out.println("Enter age: ");
        human.age = scannerInt.nextInt();

        System.out.println("Enter job: ");
        human.job = scannerStr.nextLine();

        return human;
    }

    public static void printHumans(Human humans[]) {
        for (int i = 0; i < humans.length; i++) {
            if (humans[i] != null) {
                System.out.print("Human " + i + ": ");
                System.out.println(humans[i].toString());
            }
        }
    }


}