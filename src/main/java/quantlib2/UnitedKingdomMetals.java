package quantlib2;

import java.time.LocalDate;

public class UnitedKingdomMetals extends WesternCalendar {

  @Override
  public String name() {
    return null;
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
        // New Year's Day (possibly moved to Monday)
        || ((d == 1 || ((d == 2 || d == 3) && w == Monday)) &&
        m == January)
        // Good Friday
        || (dd == em - 3)
        // Easter Monday
        || (dd == em)
        // first Monday of May (Early May Bank Holiday)
        // moved to May 8th in 1995 and 2020 for V.E. day
        || (d <= 7 && w == Monday && m == May && y != 1995 && y != 2020)
        || (d == 8 && m == May && (y == 1995 || y == 2020))
        // last Monday of May (Spring Bank Holiday)
        || (d >= 25 && w == Monday && m == May && y != 2002 && y != 2012)
        // last Monday of August (Summer Bank Holiday)
        || (d >= 25 && w == Monday && m == August)
        // Christmas (possibly moved to Monday or Tuesday)
        || ((d == 25 || (d == 27 && (w == Monday || w == Tuesday)))
        && m == December)
        // Boxing Day (possibly moved to Monday or Tuesday)
        || ((d == 26 || (d == 28 && (w == Monday || w == Tuesday)))
        && m == December)
        // June 3rd, 2002 only (Golden Jubilee Bank Holiday)
        // June 4rd, 2002 only (special Spring Bank Holiday)
        || ((d == 3 || d == 4) && m == June && y == 2002)
        // April 29th, 2011 only (Royal Wedding Bank Holiday)
        || (d == 29 && m == April && y == 2011)
        // June 4th, 2012 only (Diamond Jubilee Bank Holiday)
        // June 5th, 2012 only (Special Spring Bank Holiday)
        || ((d == 4 || d == 5) && m == June && y == 2012)
        // December 31st, 1999 only
        || (d == 31 && m == December && y == 1999)) {
      return false;
    }
    return true;

  }
}
