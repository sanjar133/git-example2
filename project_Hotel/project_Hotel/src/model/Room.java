package model;

public class Room {
    private int roomNumber;
    private boolean isOccupied;
    private String guest;


    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isOccupied = false;
        this.guest = null;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void checkIn(String guest) {
        if (!isOccupied) {
            this.isOccupied = true;
            this.guest = guest;
        } else {
            System.out.println("Room " + roomNumber + " is already occupied.");
        }
    }

    public void checkOut() {
        if (isOccupied) {
            this.isOccupied = false;
            this.guest = null;
        } else {
            System.out.println("Room " + roomNumber + " is not occupied.");
        }
    }

    public String getName() {
        return guest;
    }


    @Override
    public String toString() {
        return "Room " + roomNumber + " - " + (isOccupied ? "Occupied by " + guest.getName() : "Available");
    }
}
