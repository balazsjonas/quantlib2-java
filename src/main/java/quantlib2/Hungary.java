package quantlib2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Hungary extends WesternCalendar {

  @Override
  public String name() {
    return "Hungary";
  }

  @Override
  public boolean isBusinessDay(LocalDate date) {
    var w = date.getDayOfWeek();
    var d = date.getDayOfMonth();
    var dd = date.getDayOfYear();
    var m = date.getMonth();
    var y = date.getYear();
    var em = easterMonday(y);
    if (isWeekend(w)
        // Good Friday (since 2017)
        || (dd == em - 3 && y >= 2017)
        // Easter Monday
        || (dd == em)
        // Whit Monday
        || (dd == em + 49)
        // New Year's Day
        || (d == 1 && m == January)
        // National Day
        || (d == 15 && m == March)
        // Labour Day
        || (d == 1 && m == May)
        // Constitution Day
        || (d == 20 && m == August)
        // Republic Day
        || (d == 23 && m == October)
        // All Saints Day
        || (d == 1 && m == November)
        // Christmas
        || (d == 25 && m == December)
        // 2nd Day of Christmas
        || (d == 26 && m == December))
      return false;
    return true;


  }
}
