import model.Chat;
import model.Group;
import model.Notification;
import model.User;
import service.ChatService;
import service.GroupService;
import service.NotificationService;
import service.UserService;
import utils.ScannerUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static Scanner scannerStr = new Scanner(System.in);

    private static final UserService userService = new UserService();
    private static final GroupService groupService = new GroupService();
    private static final ChatService chatService = new ChatService();

    public static void main(String[] args) {
        int command;
        User currentUser;

        while (true) {
            printLoginMenu();
            command = ScannerUtil.inputInt("Choose: ");
            switch (command) {
                case 1 -> {
                    User user = enterUser();
                    userService.registerUser(user);
                }

                case 2 -> {
                    String username = ScannerUtil.inputString("Username: ");
                    String password = ScannerUtil.inputString("Password: ");
                    currentUser = userService.login(username, password);
                    if (currentUser == null) {
                        System.out.println("Username or password is incorrect!");
                    } else {
                        getMainMenu(currentUser);
                    }
                }

                default -> {
                }

            }
        }

    }

    private static void getMainMenu(User currentUser) {


        int command = 234215;
        while (command != 0) {
            System.out.println("1. One to one chat");
            System.out.println("2. Group");
            System.out.println("3. My contacts");
            System.out.println("0. Exit");
            command = ScannerUtil.inputInt("Choose: ");
            switch (command) {
                case 1 -> {
                    chatMenu(currentUser);
                }
                case 2 -> {
                    groupMenu(currentUser);
                }
                case 3 -> {

                }

            }
        }
    }

    private static void groupMenu(User currentUser) {

        int command = 7686;
        while (command != 0) {
            System.out.println("1. Create Group");
            System.out.println("2. Add user in group");
            System.out.println("3. Send message in group");
            System.out.println("4. Group members");
            System.out.println("5. Delete members");
            System.out.println("0. Exit");
            command = ScannerUtil.inputInt("Choose: ");
            switch (command) {

                case 1 -> {
                    String name = ScannerUtil.inputString("Enter group name: ");
                    groupService.createGroup(currentUser, name);
                }
                case 2 -> {
                    Group[] groups = groupService.getGroups();
                    for (int i = 0; i < groups.length; i++) {
                        System.out.println(i + 1 + " " + groups[i].getName());
                    }
                    int id = ScannerUtil.inputInt("Enter group number: ");
                    String userName = ScannerUtil.inputString("Enter user name: ");
                    User user = UserService.findByUsername(userName);
                    if (user == null) {
                        break;
                    }
                    groupService.addUserToGroup(groups[id - 1], user);

                }
                case 3 -> {
                    Group[] groups = groupService.getGroups();
                    for (int i = 0; i < groups.length; i++) {
                        System.out.println(i + 1 + " " + groups[i].getName());
                    }

                    int id = ScannerUtil.inputInt("Enter group number: ");
                    Notification[] notifications = chatService.getMessages(groups[id - 1]);

                    for (Notification notification : notifications) {
                        System.out.println(notification.getUser().getFirstName() + ": " + notification.getMessage() + "    time: " + notification.getDate());
                    }

                    String message = ScannerUtil.inputString("Enter message: ");

                    chatService.sendMessage(currentUser, groups[id - 1], message);

                }
                case 4 -> {
                    Group[] groups = groupService.getGroups();
                    for (int i = 0; i < groups.length; i++) {
                        System.out.println(i + 1 + " " + groups[i].getName());
                    }

                    int id = ScannerUtil.inputInt("Enter group number: ") - 1;
                    User[] users = groups[id].getMembers();

                    for (User user : users) {
                        if (user != null) {
                            System.out.println(groups[id].getName() + ": " + user.getUsername());
                        }
                    }
                }
            }
        }
    }

    private static User enterUser() {
        String first = ScannerUtil.inputString("First name: ");
        String last = ScannerUtil.inputString("Last name: ");

        String username = ScannerUtil.inputString("Username: ");
        while (true) {
            if (UserService.findByUsername(username) != null) {
                username = ScannerUtil.inputString("Invalid username, enter another: ");
            } else {
                break;
            }
        }
        String password = ScannerUtil.inputString("Password: ");
        return new User(first, last, username, password);
    }

    private static void printLoginMenu() {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
    }

    private static void chatMenu(User currentUser) {
        int command = 7686;
        while (command != 0) {
            System.out.println("1. Write");
            System.out.println("2. See notifications");
            System.out.println("0. Exit");
            command = ScannerUtil.inputInt("Choose: ");
            switch (command) {
                case 1 -> {
                    System.out.print("Enter username of the user you want to write to: ");
                    String username = scannerStr.nextLine();
                    User toUser = UserService.findByUsername(username);
                    if (toUser == null) {
                        System.out.println("User not found!");
                        break;
                    }
                    System.out.print("Enter message: ");
                    String message = scannerStr.nextLine();
                    chatService.sendMessage(currentUser, toUser, message);
                    System.out.println("Message sent successfully!");
                }
                case 2 -> {
                    Notification[] notifications = chatService.getNotifications(currentUser);
                    System.out.println("Notifications:");
                    for (Notification notification : notifications) {
                        System.out.println(notification.getUser().getUsername() + ": " + notification.getMessage());
                    }
                }
                case 0 -> {
                    System.out.println("Exiting chat menu.");
                    break;
                }
                default -> System.out.println("Invalid command!");
            }
        }
    }



}