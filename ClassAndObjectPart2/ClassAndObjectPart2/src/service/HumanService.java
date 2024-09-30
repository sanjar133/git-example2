package service;

import model.Human;

public class HumanService {
    public Human humans[] = new Human[10];
    public int index = 0;
    public void addHuman(Human human) {
        humans[index++] = human;
    }
    public boolean hasHuman(String name) {
        for (int i = 0; i < index; i++) {
            if (humans[i].name.equals(name)) {
                return true;

            }
        }
        return false;
    }
    public Human[] printHuman(String name) {
        return humans;
    }
}
