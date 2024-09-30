package service;
import model.Group;
import model.User;

public class GroupService {
    private final Group[] groups = new Group[100];
    int groupCont = 0;

    public void createGroup(User owner, String groupName) {
        // Implement creating a group
        Group group = new Group(groupName, owner);
        groups[groupCont++] = group;
        System.out.println("Group create");

    }

    public void addUserToGroup(Group group, User user) {

        group.addMember(user);
        System.out.println("user added");
    }

    public void removeUserFromGroup(String id, User user) {
        // Implement removing a user from a group
    }

    public Group[] getGroups() {
        Group[] groups1 = new Group[groupCont];
        for (int i = 0; i < groupCont; i++) {
            groups1[i] = groups[i];
        }
        return groups1;
    }




    // Other methods as needed
}
