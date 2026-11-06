package dateTime;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class localti {
    public static void main(String[] args) {
        LocalTime now= LocalTime.now();
//        System.out.println(now);
//
//        LocalTime customTime=LocalTime.of(11,32,30);
//        System.out.println(customTime);

        System.out.println(now);
        LocalDateTime custumDate=LocalDateTime.parse("2026-10-26T13:48");
        System.out.println(custumDate);
    }
}
