package service;

import model.Human;

public class HumanService {
    public Human humans[] = new Human[10];
    public int index = 0;
    public boolean addHuman(Human human) {
        if (!hasHuman(human.name)) {
            humans[index ++] = human;
            return true;
        }
        return false;
    }
    public boolean hasHuman(String name) {
        for (int i = 0; i < index; i++) {
            if (humans[i].name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Human[] getHumans() {
        return humans;
    }
    public void deleteHuman(String name) {
        for (int i = 0; i < index; i++) {
            if (humans[i].name.equals(name)) {
                for (int j = i; j < index - 1; j++) {
                    humans[j] = humans[j + 1];
                }
                humans[index - 1] = null;
                index--;
            }
        }
    }
    public void updateHuman(String name, Human human) {
        for (int i = 0; i < index; i++) {
            if (humans[i].name.equals(name)) {

            }
        }
    }
}
