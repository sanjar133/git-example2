package service;


import model.User;

public class UserService {
    // Methods for managing user entities
    private User currentUser;
    private static final User[] users = new User[1000];
    int userCount = 0;

    public void registerUser(User user) {
        users[userCount++] = user;
    }

    public void updateUser(User user, String username, String phoneNumber, String firstName, String lastName) {
        // Implement updating user information
    }

    public void deleteUser(User user) {
        // Implement deleting a user
    }

    public static User findByUsername(String username) {
        for (User user: users) {
            if (user != null && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User[] getUsers() {
        return users;
    }

    public User login(String username, String password) {
        User user = findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return currentUser;
        }
        return null;
    }

    // Other methods as needed
}
