package service;


import model.User;

public class UserService {
    private final User[] users = new User[100];
    private int userIndex = 0;

    public User addUser(User user) {
        if(userIndex==0){
            users[userIndex++] = user;
            return user;
        }else {

            for (int i = 0; i < userIndex; i++) {
                if (hasUserName(user.getPhoneNumber()) == null) {
                    users[userIndex++] = user;
                    return user;
                }
            }
            return null;
        }
    }

    public User loginUser(String phoneNumber, String password) {
        User user = hasUserName(phoneNumber);
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }

    private User hasUserName(String phoneNumber) {
        for (int i = 0; i < userIndex; i++) {
            if (users[i].getPhoneNumber().equals(phoneNumber)) {
                return users[i];
            }
        }
        return null;
    }

    public void changeUserPassword() {

    }
}
