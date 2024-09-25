package model;

import java.util.HashMap;
import java.util.Map;

public class Admin {
    private Map<String, String> adminData;

    public Admin() {
        this.adminData = new HashMap<>();
    }

    public void addData(String key, String value) {
        adminData.put(key, value);
    }

    public String getData(String key) {
        return adminData.get(key);
    }

    public void removeData(String key) {
        adminData.remove(key);
    }

    public void displayAllData() {
        System.out.println("Admin Data:");
        for (Map.Entry<String, String> entry : adminData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}