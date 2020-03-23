package quantlib2;

import java.time.LocalDate;

public class UnitedStatesSettlement extends UnitedStates {

  @Override
  public String name() {
    throw new UnsupportedOperationException();
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
        // New Year's Day (possibly moved to Monday if on Sunday)
        || ((d == 1 || (d == 2 && w == Monday)) && m == January)
        // (or to Friday if on Saturday)
        || (d == 31 && w == Friday && m == December)
        // Martin Luther King's birthday (third Monday in January)
        || ((d >= 15 && d <= 21) && w == Monday && m == January
        && y >= 1983)
        // Washington's birthday (third Monday in February)
        || isWashingtonBirthday(d, m, y, w)
        // Memorial Day (last Monday in May)
        || isMemorialDay(d, m, y, w)
        // Independence Day (Monday if Sunday or Friday if Saturday)
        || ((d == 4 || (d == 5 && w == Monday) ||
        (d == 3 && w == Friday)) && m == July)
        // Labor Day (first Monday in September)
        || isLaborDay(d, m, y, w)
        // Columbus Day (second Monday in October)
        || isColumbusDay(d, m, y, w)
        // Veteran's Day (Monday if Sunday or Friday if Saturday)
        || isVeteransDay(d, m, y, w)
        // Thanksgiving Day (fourth Thursday in November)
        || ((d >= 22 && d <= 28) && w == Thursday && m == November)
        // Christmas (Monday if Sunday or Friday if Saturday)
        || ((d == 25 || (d == 26 && w == Monday) ||
        (d == 24 && w == Friday)) && m == December)) {
      return false;
    }
    return true;
  }
}
