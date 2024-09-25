import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Duration;

public class TokioAndNewYork {
    public static void main(String[] args) {
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        ZoneId newYorkZone = ZoneId.of("America/New_York");

        ZonedDateTime tokyoTime = ZonedDateTime.now(tokyoZone);
        ZonedDateTime newYorkTime = ZonedDateTime.now(newYorkZone);

        Duration duration = Duration.between(newYorkTime, tokyoTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        System.out.println("Tokio va Nyu-York orasida " + hours + " soat " + minutes + " minut farq bor.");
    }
}
