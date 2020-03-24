package quantlib2;

import static quantlib2.BusinessDayConvention.Following;
import static quantlib2.BusinessDayConvention.HalfMonthModifiedFollowing;
import static quantlib2.BusinessDayConvention.ModifiedFollowing;
import static quantlib2.BusinessDayConvention.ModifiedPreceding;
import static quantlib2.BusinessDayConvention.Nearest;
import static quantlib2.BusinessDayConvention.Preceding;
import static quantlib2.BusinessDayConvention.Unadjusted;

import com.google.common.base.Preconditions;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;


public abstract class Calendar {

  protected static final DayOfWeek Monday = DayOfWeek.MONDAY;
  protected static final DayOfWeek Tuesday = DayOfWeek.TUESDAY;
  protected static final DayOfWeek Wednesday = DayOfWeek.WEDNESDAY;
  protected static final DayOfWeek Thursday = DayOfWeek.THURSDAY;
  protected static final DayOfWeek Friday = DayOfWeek.FRIDAY;
  protected static final DayOfWeek Saturday = DayOfWeek.SATURDAY;
  protected static final DayOfWeek Sunday = DayOfWeek.SUNDAY;

  protected static final Month January = Month.JANUARY;
  protected static final Month February = Month.FEBRUARY;
  protected static final Month March = Month.MARCH;
  protected static final Month April = Month.APRIL;
  protected static final Month May = Month.MAY;
  protected static final Month June = Month.JUNE;
  protected static final Month July = Month.JULY;
  protected static final Month August = Month.AUGUST;
  protected static final Month September = Month.SEPTEMBER;
  protected static final Month October = Month.OCTOBER;
  protected static final Month November = Month.NOVEMBER;
  protected static final Month December = Month.DECEMBER;


  private Set<LocalDate> addedHolidays = new HashSet<>();
  private Set<LocalDate> removedHolidays = new HashSet<>();

  protected Calendar() {

  }

  public abstract String name();

  public abstract boolean isBusinessDay(LocalDate date);

  public final boolean isHoliday(LocalDate date) {
    return !isBusinessDay(date);
  }

  public abstract int easterMonday(int year);

  public boolean isWeekend(@Nonnull LocalDate date) {
    return isWeekend(date.getDayOfWeek());
  }

  public boolean isWeekend(DayOfWeek dayOfWeek) {
    return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
  }

  /**
   * @return the set of added holidays for the given calendar
   */
  public Set<LocalDate> addedHolidays() {
    throw new UnsupportedOperationException();
  }

  public final List<LocalDate> holidayList(LocalDate from, LocalDate to) {
    return holidayList(from, to, false);

  }

  public List<LocalDate> holidayList(LocalDate from, LocalDate to, boolean includeWeekEnds) {
    Preconditions.checkArgument(to.isAfter(from), "from date must be earlier than to date");
    List<LocalDate> result = new ArrayList<>();
    for (LocalDate d = from; !d.isAfter(to); d = incremented(d)) {
      if (isHoliday(d) && (includeWeekEnds || !isWeekend(d))) {
        result.add(d);
      }

    }
    return result;

  }


  public static LocalDate incremented(@Nonnull LocalDate d) {
    return d.plusDays(1);
  }

  public static LocalDate decremented(@Nonnull LocalDate d) {
    return d.minusDays(1);
  }


  public LocalDate endOfMonth(LocalDate date) {
    return adjust(Date.endOfMonth(date), Preceding);
  }

  public LocalDate adjust(LocalDate date, BusinessDayConvention convention) {
    Objects.requireNonNull(date, "null date");

    if (convention == Unadjusted) {
      return date;
    }

    LocalDate d1 = date;
    if (convention == Following || convention == ModifiedFollowing
        || convention == HalfMonthModifiedFollowing) {
      while (isHoliday(d1)) {
        d1 = incremented(d1);
      }
      if (convention == ModifiedFollowing
          || convention == HalfMonthModifiedFollowing) {
        if (d1.getMonth() != date.getMonth()) {
          return adjust(date, Preceding);
        }
        if (convention == HalfMonthModifiedFollowing) {
          if (date.getDayOfMonth() <= 15 && d1.getDayOfMonth() > 15) {
            return adjust(date, Preceding);
          }
        }
      }
    } else if (convention == Preceding || convention == ModifiedPreceding) {
      while (isHoliday(d1)) {
        d1 = decremented(d1);
      }
      if (convention == ModifiedPreceding && d1.getMonth() != date.getMonth()) {
        return adjust(date, Following);
      }
    } else if (convention == Nearest) {
      LocalDate d2 = date;
      while (isHoliday(d1) && isHoliday(d2)) {
        d1 = incremented(d1);
        d2 = decremented(d2);
      }
      if (isHoliday(d1)) {
        return d2;
      } else {
        return d1;
      }
    }
    return d1;
  }

  public final LocalDate adjust(LocalDate date) {
    return adjust(date, Following);

  }

  public boolean isEndOfMonth(LocalDate date) {
    return (date.getMonth() != adjust(incremented(date)).getMonth());
  }
}

class Date {

  private static final int[] MonthLength = {
      31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
  };
  private static final int[] MonthLeapLength = {
      31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
  };

  public static LocalDate endOfMonth(@Nonnull LocalDate date) {
    return date.withDayOfMonth(monthLength(date));
  }

  private static int monthLength(@Nonnull LocalDate date) {
    var month = date.getMonthValue() - 1;
    return date.isLeapYear() ? MonthLeapLength[month] : MonthLength[month];
  }

}
