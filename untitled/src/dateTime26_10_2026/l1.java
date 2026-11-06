//FineTech
//Banking
//Multi region SaaS application
//Spring Boot & hibernate / JPA Entities
//Flight tickests
//Distributed system
package dateTime;
//localDate
//LocalTime
//LocalDateTime
//ZonedDateTIme

import java.time.LocalDate;

public class l1 {
    public static void main(String[] args) {
        LocalDate now=LocalDate.now();
//        System.out.println("today date "+now);
//        int day=now.getDayOfMonth();
//        System.out.println(day);
//        Month month1=now.getMonth();
//        System.out.println(month1);
//        int year=now.getYear();
//        System.out.println(year);
//        LocalDate custom=LocalDate.of(2026,12,30);
//        System.out.println(custom);
//        int day= custom.getDayOfMonth();
//        int month=custom.getMonthValue();
//        int year=custom.getYear();
//        System.out.println(day);
        System.out.println(now);
        LocalDate yes=now.minusDays(1);
        System.out.println(yes);
        LocalDate pastDAte=now.minusMonths(100);
        System.out.println("100 months before  "+pastDAte);
    }
}
