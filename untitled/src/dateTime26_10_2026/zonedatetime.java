package dateTime;
import java.time.*;
import java.util.Scanner;
import java.util.Set;

public class zonedatetime {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ZonedDateTime now=ZonedDateTime.now();
        System.out.println(now);
        Set<String> availablezone=ZoneId.getAvailableZoneIds();
//        availablezone.forEach(System.out::println);
        String s=sc.nextLine();
        try{
            ZoneId zone=ZoneId.of(s);
            ZonedDateTime currentTime=ZonedDateTime.now(zone);
            System.out.println("timezone: " +zone);
            System.out.println(currentTime);
        }
        catch (java.time.DateTimeException e){
            System.out.println("Invalid zonr id");
        }
        
    }
}
