package quantlib2;

import java.time.LocalDate;

public class GermanyFrankfurtStockExchange extends WesternCalendar {

  @Override
  public String name() {
    return "Frankfurt stock exchange";
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
        || (d == 1 && m == January)
        // Good Friday
        || (dd == em-3)
        // Easter Monday
        || (dd == em)
        // Labour Day
        || (d == 1 && m == May)
        // Christmas' Eve
        || (d == 24 && m == December)
        // Christmas
        || (d == 25 && m == December)
        // Christmas Day
        || (d == 26 && m == December)
        // New Year's Eve
        || (d == 31 && m == December))
      return false;
    return true;
  }
}
