package dateTime26_10_2026;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
//Enter meeting date (yyyy-MM-dd): 2026-11-10
//Enter meeting time (HH:mm): 14:30
//Enter meeting duration in minutes: 90
//
//Choose an option:
//        1. Display meeting date and time
//2. Display meeting end time
//3. Display meeting time in another zone
//4. Check whether the meeting is in the future
//5. Exit
//
//Enter choice: 2
//
//Meeting starts at: 10 Nov 2026, 02:30 PM
//Meeting ends at:   10 Nov 2026, 04:00 PM



public class MeetingTimeAssistant {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter meeting date (yyyy-MM-dd): ");
        String d = sc.next();

        System.out.print("Enter meeting time (HH:mm): ");
        String t = sc.next();

        System.out.print("Enter meeting duration in minutes: ");
        int duration = sc.nextInt();

        LocalDate date = LocalDate.parse(d);
        LocalTime time = LocalTime.parse(t);

        LocalDateTime meeting = LocalDateTime.of(date, time);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");

        int choice;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display meeting date and time");
            System.out.println("2. Display meeting end time");
            System.out.println("3. Display meeting time in another zone");
            System.out.println("4. Check whether the meeting is in the future");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Meeting date and time: "
                            + meeting.format(formatter));
                    break;

                case 2:
                    LocalDateTime endTime = meeting.plusMinutes(duration);

                    System.out.println("Meeting starts at: "
                            + meeting.format(formatter));

                    System.out.println("Meeting ends at:   "
                            + endTime.format(formatter));
                    break;

                case 3:
                    System.out.print(
                            "Enter target time zone (e.g. Asia/Kolkata, Europe/London): ");
                    String zone = sc.next();

                    ZonedDateTime zonedMeeting =
                            meeting.atZone(ZoneId.systemDefault())
                                    .withZoneSameInstant(ZoneId.of(zone));

                    System.out.println("Meeting time in " + zone + ": "
                            + zonedMeeting.format(formatter));
                    break;

                case 4:
                    LocalDateTime now = LocalDateTime.now();

                    if (meeting.isAfter(now)) {
                        System.out.println("The meeting is in the future.");
                    } else {
                        System.out.println(
                                "The meeting is not in the future.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}

