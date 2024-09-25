package model;

import java.util.HashMap;
import java.util.Map;

public class Doctor {
    private Map<String, String> doctorData;

    public Doctor() {
        this.doctorData = new HashMap<>();
    }

    public void addData(String key, String value) {
        doctorData.put(key, value);
    }

    public String getData(String key) {
        return doctorData.get(key);
    }

    public void removeData(String key) {
        doctorData.remove(key);
    }

    public void displayAllData() {
        System.out.println("Doctor Data:");
        for (Map.Entry<String, String> entry : doctorData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}