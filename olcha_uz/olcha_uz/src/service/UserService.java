package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> userList = new ArrayList<>();
    public String register(String username, String password) {
        if (hasUser(username)) {
            return "this user already exist";
        }
        User user = new User(username, password);
        userList.add(user);
        return "successfully";
    }
    public boolean hasUser(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    public String login(String username, String password) {
        User user = getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return "successfully";
        }
        return "error";
    }
    private User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
