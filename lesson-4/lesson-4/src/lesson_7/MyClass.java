package lesson_7;

import java.io.Serializable;

class MyClass implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient String transientField;

    private String nonTransientField;

    public MyClass(String transientField, String nonTransientField) {
        this.transientField = transientField;
        this.nonTransientField = nonTransientField;
    }

    public String getTransientField() {
        return transientField;
    }

    public String getNonTransientField() {
        return nonTransientField;
    }
}
