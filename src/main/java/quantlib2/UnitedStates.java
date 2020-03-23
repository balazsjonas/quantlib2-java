package quantlib2;

import java.time.DayOfWeek;
import java.time.Month;

public abstract class UnitedStates extends WesternCalendar {
  // a few rules used by multiple calendars

  static boolean isWashingtonBirthday(int d, Month m, int y, DayOfWeek w) {
    if (y >= 1971) {
      // third Monday in February
      return (d >= 15 && d <= 21) && w == Monday && m == February;
    } else {
      // February 22nd, possily adjusted
      return (d == 22 || (d == 23 && w == Monday)
          || (d == 21 && w == Friday)) && m == February;
    }
  }

  static boolean isMemorialDay(int d, Month m, int y, DayOfWeek w) {
    if (y >= 1971) {
      // last Monday in May
      return d >= 25 && w == Monday && m == May;
    } else {
      // May 30th, possibly adjusted
      return (d == 30 || (d == 31 && w == Monday)
          || (d == 29 && w == Friday)) && m == May;
    }
  }

  static boolean isLaborDay(int d, Month m, int y, DayOfWeek w) {
    // first Monday in September
    return d <= 7 && w == Monday && m == September;
  }

  static boolean isColumbusDay(int d, Month m, int y, DayOfWeek w) {
    // second Monday in October
    return (d >= 8 && d <= 14) && w == Monday && m == October
        && y >= 1971;
  }

  static boolean isVeteransDay(int d, Month m, int y, DayOfWeek w) {
    if (y <= 1970 || y >= 1978) {
      // November 11th, adjusted
      return (d == 11 || (d == 12 && w == Monday) ||
          (d == 10 && w == Friday)) && m == November;
    } else {
      // fourth Monday in October
      return (d >= 22 && d <= 28) && w == Monday && m == October;
    }
  }

  static boolean isVeteransDayNoSaturday(int d, Month m, int y, DayOfWeek w) {
    if (y <= 1970 || y >= 1978) {
      // November 11th, adjusted, but no Saturday to Friday
      return (d == 11 || (d == 12 && w == Monday)) && m == November;
    } else {
      // fourth Monday in October
      return (d >= 22 && d <= 28) && w == Monday && m == October;
    }
  }
}


