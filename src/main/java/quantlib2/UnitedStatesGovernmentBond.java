package quantlib2;

import java.time.LocalDate;

public class UnitedStatesGovernmentBond extends UnitedStates {

  @Override
  public String name() {
    return "UnitedStates Government bond";
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
        // Martin Luther King's birthday (third Monday in January)
        || ((d >= 15 && d <= 21) && w == Monday && m == January
        && y >= 1983)
        // Washington's birthday (third Monday in February)
        || isWashingtonBirthday(d, m, y, w)
        // Good Friday (2015 was half day due to NFP report)
        || (dd == em - 3 && y != 2015)
        // Memorial Day (last Monday in May)
        || isMemorialDay(d, m, y, w)
        // Independence Day (Monday if Sunday or Friday if Saturday)
        || ((d == 4 || (d == 5 && w == Monday) ||
        (d == 3 && w == Friday)) && m == July)
        // Labor Day (first Monday in September)
        || isLaborDay(d, m, y, w)
        // Columbus Day (second Monday in October)
        || isColumbusDay(d, m, y, w)
        // Veteran's Day (Monday if Sunday)
        || isVeteransDayNoSaturday(d, m, y, w)
        // Thanksgiving Day (fourth Thursday in November)
        || ((d >= 22 && d <= 28) && w == Thursday && m == November)
        // Christmas (Monday if Sunday or Friday if Saturday)
        || ((d == 25 || (d == 26 && w == Monday) ||
        (d == 24 && w == Friday)) && m == December)) {
      return false;
    }

    // Special closings
    if (// President Bush's Funeral
        (y == 2018 && m == December && d == 5)
            // Hurricane Sandy
            || (y == 2012 && m == October && (d == 30))
            // President Reagan's funeral
            || (y == 2004 && m == June && d == 11)
    ) {
      return false;
    }

    return true;
  }
}
