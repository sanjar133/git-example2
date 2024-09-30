import java.util.UUID;

public class Human {
    private UUID id;
    private String name;
    private String age;

    public void UUID() {
        this.id = UUID.randomUUID();
    }
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
    public Human() {
        this.id = UUID.randomUUID();
    }
    public Human(UUID id, String name, String age) {
        this();
        this.name = name;
        this.age = age;
    }
}
