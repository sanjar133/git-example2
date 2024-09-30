package service;


import model.History;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HistoryService {
    public List<History> histories = new ArrayList<>();



    public List getHistories(String userHistory) {
        List get = new ArrayList<>();



        if (histories.isEmpty())
            return null;

        for (History history : histories) {
            if (Objects.equals(history.to, userHistory)){
                get.add(history);
            }
        }

        return get;


    }

    public void printHistory(String name, String name1, double amount) {
        History history = new History(name, name1, amount);
        histories.add(history);

    }
}
