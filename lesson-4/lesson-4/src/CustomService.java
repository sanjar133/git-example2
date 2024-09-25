import java.util.ArrayList;

public class CustomService {
    /**
     *
     */
    public ArrayList<String> usernames = new ArrayList<>();

    private static boolean hasAdded;
    private static CustomService customService;

    public static CustomService getInstance() {
        if (customService == null) { // agar bu qo'yilmasa har gal threadlar bloklanadi
            synchronized (CustomService.class) {
                if (customService == null) {
                    customService = new CustomService();
                    if (!hasAdded) {
                        hasAdded = true;
                        customService.usernames.add("ali");
                    }
                }
            }
        }
        return customService;
    }
}
