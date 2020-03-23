package quantlib2;

import java.time.LocalDate;

public class UnitedStatesNyse extends UnitedStates {

  @Override
  public String name() {
    return "UnitedStates NYSE";
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
        // Washington's birthday (third Monday in February)
        || isWashingtonBirthday(d, m, y, w)
        // Good Friday
        || (dd == em - 3)
        // Memorial Day (last Monday in May)
        || isMemorialDay(d, m, y, w)
        // Independence Day (Monday if Sunday or Friday if Saturday)
        || ((d == 4 || (d == 5 && w == Monday) ||
        (d == 3 && w == Friday)) && m == July)
        // Labor Day (first Monday in September)
        || isLaborDay(d, m, y, w)
        // Thanksgiving Day (fourth Thursday in November)
        || ((d >= 22 && d <= 28) && w == Thursday && m == November)
        // Christmas (Monday if Sunday or Friday if Saturday)
        || ((d == 25 || (d == 26 && w == Monday) ||
        (d == 24 && w == Friday)) && m == December)
    ) {
      return false;
    }

    if (y >= 1998 && (d >= 15 && d <= 21) && w == Monday && m == January)
    // Martin Luther King's birthday (third Monday in January)
    {
      return false;
    }

    if ((y <= 1968 || (y <= 1980 && y % 4 == 0)) && m == November
        && d <= 7 && w == Tuesday)
    // Presidential election days
    {
      return false;
    }

    // Special closings
    if (// President Bush's Funeral
        (y == 2018 && m == December && d == 5)
            // Hurricane Sandy
            || (y == 2012 && m == October && (d == 29 || d == 30))
            // President Ford's funeral
            || (y == 2007 && m == January && d == 2)
            // President Reagan's funeral
            || (y == 2004 && m == June && d == 11)
            // September 11-14, 2001
            || (y == 2001 && m == September && (11 <= d && d <= 14))
            // President Nixon's funeral
            || (y == 1994 && m == April && d == 27)
            // Hurricane Gloria
            || (y == 1985 && m == September && d == 27)
            // 1977 Blackout
            || (y == 1977 && m == July && d == 14)
            // Funeral of former President Lyndon B. Johnson.
            || (y == 1973 && m == January && d == 25)
            // Funeral of former President Harry S. Truman
            || (y == 1972 && m == December && d == 28)
            // National Day of Participation for the lunar exploration.
            || (y == 1969 && m == July && d == 21)
            // Funeral of former President Eisenhower.
            || (y == 1969 && m == March && d == 31)
            // Closed all day - heavy snow.
            || (y == 1969 && m == February && d == 10)
            // Day after Independence Day.
            || (y == 1968 && m == July && d == 5)
            // June 12-Dec. 31, 1968
            // Four day week (closed on Wednesdays) - Paperwork Crisis
            || (y == 1968 && dd >= 163 && w == Wednesday)
            // Day of mourning for Martin Luther King Jr.
            || (y == 1968 && m == April && d == 9)
            // Funeral of President Kennedy
            || (y == 1963 && m == November && d == 25)
            // Day before Decoration Day
            || (y == 1961 && m == May && d == 29)
            // Day after Christmas
            || (y == 1958 && m == December && d == 26)
            // Christmas Eve
            || ((y == 1954 || y == 1956 || y == 1965)
            && m == December && d == 24)
    ) {
      return false;
    }

    return true;
  }
}
