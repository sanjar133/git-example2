import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LocalTime timee = LocalTime.now().plusMinutes(2);
        while (LocalTime.now().isBefore(timee)) {
            LocalTime time = LocalTime.now().plusSeconds(3);
            System.out.println("qizil");
            while (LocalTime.now().isBefore(time)) ;
            LocalTime time1 = LocalTime.now().plusSeconds(1);
            System.out.println("sariq");
            while (LocalTime.now().isBefore(time1)) ;
            LocalTime time2 = LocalTime.now().plusSeconds(4);
            System.out.println("yashil");
            while (LocalTime.now().isBefore(time2));
        }

//        System.out.println(now);
//        ZoneId.getAvailableZoneIds().forEach(s ->
//                System.out.println(s));
//        LocalTime time = LocalTime.now();
//        String format = f.format(time);
//        System.out.println(format);
//        LocalTime parse = LocalTime.parse("15:00:20");
//        LocalTime parse1 = LocalTime.parse("hello world, now hour is 16 and minute is 00 ", f);
//        System.out.println(parse1);
//        LocalTime localTime = LocalTime.of(16, 20);
//        System.out.println(parse);


//        System.out.println(endTime);
//        Date date = new Date(1531541324600l);


//        for (String availableID : TimeZone.getAvailableIDs()) {
//            System.out.println(availableID);
//        }

//        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow"));
//
//        Calendar instance1 = Calendar.getInstance(Locale.UK);
//        System.out.println(instance1);


//        Calendar calendar = new GregorianCalendar();
//        System.out.println(calendar.get(Calendar.YEAR));
//        System.out.println(calendar.get(Calendar.MONTH));
//        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }

}