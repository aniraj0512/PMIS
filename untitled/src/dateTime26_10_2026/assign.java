package dateTime;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
public class assign {

    public static class DateExplorer {
        LocalDate date;

        DateExplorer(LocalDate date) {
            this.date = date;
        }

        public void displayMonth() {
            Month month = date.getMonth();
            System.out.println("Month " + month);
        }

        public void displayYear() {
            int year = date.getYear();
            System.out.println("Year " + year);
        }

        public void lookback(int a) {
            System.out.println("Looking back " + a
                    + " months: " + date.minusMonths(a));
        }
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
//        String  s = sc.next();
        System.out.println("Enter the date in format (yyyy mm dd");
        String  s = sc.next();

        LocalDate date =LocalDate.parse(s);

        System.out.println("1. Display Month");
        System.out.println("2. Display Year");
        System.out.println("3. Look back for months");
        System.out.println("4. Exit");
        System.out.println("Select the choice ");

        int choice=sc.nextInt();
        DateExplorer dt=new DateExplorer(date);

        switch (choice) {
            case 1:
                dt.displayMonth();
                break;
            case 2:
                dt.displayYear();
                break;
            case 3:
                System.out.println("Enter number of months");
                int a=sc.nextInt();
                dt.lookback(a);
                break;
            case 4:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice");
        }
        sc.close();

        }
}
