public class Developer extends Human {
    private String position;
    private String salary;
    private String level;
    public Developer() {
    }

    public Developer(String name, String age, String position, String salary, String level) {
        super(name, age);
        this.position = position;
        this.salary = salary;
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public String getSalary() {
        return salary;
    }

    public String getLevel() {
        return level;
    }
}
