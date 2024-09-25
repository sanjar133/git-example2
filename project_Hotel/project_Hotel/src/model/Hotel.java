package model;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private Map<Integer, Room> rooms;

    public Hotel(int numberOfRooms) {
        rooms = new HashMap<>();
        for (int i = 1; i <= numberOfRooms; i++) {
            rooms.put(i, new Room(i));
        }
    }

    public void checkIn(int roomNumber, String guest) {
        Room room = rooms.get(roomNumber);
        if (room != null) {
            room.checkIn(guest);
        } else {
            System.out.println("Room " + roomNumber + " does not exist.");
        }
    }

    public void checkOut(int roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room != null) {
            room.checkOut();
        } else {
            System.out.println("Room " + roomNumber + " does not exist.");
        }
    }

    public void showRoomStatus(int roomNumber) {
        Room room = rooms.get(roomNumber);
        if (room != null) {
            System.out.println(room);
        } else {
            System.out.println("Room " + roomNumber + " does not exist.");
        }
    }

    public void showAllRooms() {
        for (Room room : rooms.values()) {
            System.out.println(room);
        }
    }
}
