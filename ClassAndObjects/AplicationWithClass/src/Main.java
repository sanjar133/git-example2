import java.util.Scanner;

public class Main {
    static Users[] users = new Users[5];
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static int index = 0;

    public static void main(String[] args) {
        int step = 1;

        while (step != 0) {
            System.out.println("1.Add contact\n2.Show contact\n3.Delete contact\n4.Update contact\n0.Exit");
            step = scannerInt.nextInt();
            switch (step) {
                case 1: addContact(); break;
                case 2: showContact(); break;
                case 3: deleteContact(); break;
                case 4: updateContact(); break;
            }
        }
    }

    public static void addContact() {
        Users user = new Users();
        System.out.print("Name: ");
        user.name = scannerStr.nextLine();
        System.out.print("Last Name: ");
        user.lastName = scannerStr.nextLine();
        System.out.print("Phone Number: ");
        user.phoneNumber = scannerInt.nextInt();

        users[index ++] = user;
    }

    public static void showContact() {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                System.out.println("User: " + (i + 1));
                System.out.println(users[i].toString() + "\n");
            }
        }
    }

    public static void deleteContact() {
        System.out.println("Which user do you want to delete?");
        int deleteUser = scannerInt.nextInt();
        if (deleteUser >= 0 && deleteUser < index) {
            for (int i = 0; i < users.length; i++) {
                users[i] = users[i + 1];
            }
        } else {
            System.out.println("Invalid user!");
        }
    }

    public static void updateContact() {
        System.out.println("Which user do you want to update?");
        int updateUser = scannerInt.nextInt();
        if (updateUser >= 0 && updateUser < index) {
            System.out.print("Name: ");
            users[updateUser].name = scannerStr.nextLine();
            System.out.print("Last name: ");
            users[updateUser].lastName = scannerStr.nextLine();
            System.out.print("Phone number: ");
            users[updateUser].phoneNumber = scannerInt.nextInt();
        } else {
            System.out.println("Invalid user index!");
        }
    }
}
