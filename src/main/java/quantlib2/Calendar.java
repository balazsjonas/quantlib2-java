package quantlib2;

import com.google.common.base.Preconditions;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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


  private LocalDate incremented(LocalDate d) {
    return d.plusDays(1);
  }


}
