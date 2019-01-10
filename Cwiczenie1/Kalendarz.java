import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Kalendarz {
   private static final SimpleDateFormat MONTH_FORMAT = new SimpleDateFormat("MMMM");
   private static final SimpleDateFormat DAY_OF_WEEK_FORMAT = new SimpleDateFormat("EEEE");
   private static final SimpleDateFormat MY_DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

   public static void main(String[] args) {


      GregorianCalendar cal = new GregorianCalendar(2012, Calendar.JANUARY, 1);
      for (int j = 0; j < 24; j++) {
         Date date = cal.getTime();
         System.out.println("Date: " + MY_DATE_FORMAT.format(date));
         int year = cal.get(Calendar.YEAR);
         System.out.println("year := " + year);
         int month = cal.get(Calendar.MONTH);
         System.out.printf("month number: %d, month name: %s%n", month, MONTH_FORMAT.format(date));
         int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
         System.out.printf("day of week: %d, day of week string: %s%n", dayOfWeek, DAY_OF_WEEK_FORMAT.format(date));

         int maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
         System.out.println("maxDaysInMonth := " + maxDaysInMonth);
         cal.add(Calendar.MONTH, 1);
         System.out.println();
      }

      System.out.println("Today!");
      cal = new GregorianCalendar(); // today!
      Date date = cal.getTime();
      System.out.println("Date: " + MY_DATE_FORMAT.format(date));
      int year = cal.get(Calendar.YEAR);
      System.out.println("year := " + year);
      int month = cal.get(Calendar.MONTH);
      System.out.printf("month number: %d, month name: %s%n", month, MONTH_FORMAT.format(date));
      int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
      System.out.printf("day of week: %d, day of week string: %s%n", dayOfWeek, DAY_OF_WEEK_FORMAT.format(date));

      int maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
      System.out.println("maxDaysInMonth := " + maxDaysInMonth);
      cal.add(Calendar.MONTH, 1);


   }
}