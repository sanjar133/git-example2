import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Sardor", 19);
        User user2 = new User(1, "Sardor", 19);


        System.out.println(user1.equals(user2));
        System.out.println(user2.equals(user1));

        Student st = new Student(1);

        System.out.println(user1.hashCode() == user2.hashCode());
        System.out.println(user1.hashCode() == st.hashCode());
        System.out.println(user1.equals(st));

        Map<String, String > stringStringMap = new HashMap<>(100);
        System.out.println("v: " + stringStringMap.put("A", "B"));
        System.out.println("v: " + stringStringMap.put("A", "C"));
        System.out.println("v: " + stringStringMap.put("A", "O"));
        System.out.println("v: " + stringStringMap.put("K", "O"));

        System.out.println(stringStringMap);
        System.out.println(" ========================== ");

        MyHashMap<String, String> hashMap = new MyHashMap<>();
        hashMap.put("good", "yaxshi");
        hashMap.put("bad", "yomon");
        System.out.println(hashMap.put("bad", "dabdala"));

        hashMap.print();
    }
}