package quantlib2;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public abstract class Calendar {

  private Set<LocalDate> addedHolidays = new HashSet<>();
  private Set<LocalDate> removedHolidays = new HashSet<>();

  protected Calendar() {

  }

  public abstract String name();

  public abstract boolean isBusinessDay(LocalDate date);

  /**
   * @return the set of added holidays for the given calendar
   */
  public Set<LocalDate> addedHolidays() {
    throw new UnsupportedOperationException();
  }
}
