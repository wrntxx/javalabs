import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Task6 {
    public static void main(String[] args) throws Exception {
        LocalDateTime labDateTime = LocalDateTime.of(2023, 11, 11, 16, 30, 0);

        System.out.println("Day of week: " + labDateTime.getDayOfWeek());
        System.out.println("Day of year: " + labDateTime.getDayOfYear());
        System.out.println("Month: " + labDateTime.getMonth());
        System.out.println("Year: " + labDateTime.getYear());
        System.out.println("Hour: " + labDateTime.getHour());
        System.out.println("Minute: " + labDateTime.getMinute());
        System.out.println("Second: " + labDateTime.getSecond());

        System.out.println("Is leap year: " + Year.from(labDateTime).isLeap());

        LocalDateTime currentDateTime = LocalDateTime.now();

        if (currentDateTime.isAfter(labDateTime)) {
            System.out.println("Current time is later than the lab time.");
        } else if (currentDateTime.isBefore(labDateTime)) {
            System.out.println("Current time is earlier than the lab time.");
        } else {
            System.out.println("Current time matches the lab time.");
        }

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println("Before changing time: " + currentDateTime.format(dateFormatter));
        currentDateTime = currentDateTime.plusDays(5).plusHours(2);
        System.out.println("After changing time: " + currentDateTime.format(dateFormatter));
    }
}