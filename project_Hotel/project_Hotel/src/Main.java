import model.Hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel(10); // Example: Hotel with 10 rooms

        while (true) {
            System.out.println("\nHotel Management System");
            System.out.println("1. Check In");
            System.out.println("2. Check Out");
            System.out.println("3. Show Room Status");
            System.out.println("4. Show All Rooms");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room number to check in: ");
                    int checkInRoomNumber = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    hotel.checkIn(checkInRoomNumber, guestName);
                    break;
                case 2:
                    System.out.print("Enter room number to check out: ");
                    int checkOutRoomNumber = scanner.nextInt();
                    hotel.checkOut(checkOutRoomNumber);
                    break;
                case 3:
                    System.out.print("Enter room number to show status: ");
                    int statusRoomNumber = scanner.nextInt();
                    hotel.showRoomStatus(statusRoomNumber);
                    break;
                case 4:
                    hotel.showAllRooms();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
