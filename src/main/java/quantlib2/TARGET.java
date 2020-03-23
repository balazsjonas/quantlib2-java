package quantlib2;

import java.time.LocalDate;

public class TARGET extends WesternCalendar {

  @Override
  public String name() {
    return "TARGET";
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
        // New Year's Day
        || (d == 1  && m == January)
        // Good Friday
        || (dd == em-3 && y >= 2000)
        // Easter Monday
        || (dd == em && y >= 2000)
        // Labour Day
        || (d == 1  && m == May && y >= 2000)
        // Christmas
        || (d == 25 && m == December)
        // Day of Goodwill
        || (d == 26 && m == December && y >= 2000)
        // December 31st, 1998, 1999, and 2001 only
        || (d == 31 && m == December &&
        (y == 1998 || y == 1999 || y == 2001)))
      return false;
    return true;
  }
}
