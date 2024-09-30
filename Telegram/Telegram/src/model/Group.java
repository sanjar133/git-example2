package model;

public class Group extends Base {
    private String name;
    private User owner;
    private final User[] members = new User[20];
    private final Chat[] chats = new Chat[1000];

    private int memberCount = 0;
    private int chatCount = 0;

    // Constructor
    public Group(String name, User owner) {
        this.name = name;
        this.owner = owner;
        members[memberCount++] = owner;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User[] getMembers() {
        return members;
    }

    public void addMember(User user) {
        members[memberCount++] = user;
    }

    public Chat[] getChats() {
        return chats;
    }

    public void addChat(Chat chat) {
        chats[chatCount++] = chat;
    }
    // Additional methods as needed
}
