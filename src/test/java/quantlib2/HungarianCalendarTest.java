package quantlib2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;

public class HungarianCalendarTest {

  @Test
  void holidays() {
    Calendar calendar = new Hungary();
    assertFalse(calendar.isBusinessDay(LocalDate.of(2020, Month.JANUARY, 1)));
    assertTrue(calendar.isBusinessDay(LocalDate.of(2020, Month.JANUARY, 2)));
    assertFalse(calendar.isBusinessDay(LocalDate.of(2020, Month.JANUARY, 4))); // Saturday
    assertFalse(calendar.isBusinessDay(LocalDate.of(2020, Month.JANUARY, 5))); // Sunday
    assertFalse(calendar.isBusinessDay(LocalDate.of(2019, Month.MARCH, 15))); // Friday

    assertFalse(calendar.isBusinessDay(LocalDate.of(2020, Month.APRIL, 10))); // Good Friday
    assertFalse(calendar.isBusinessDay(LocalDate.of(2020, Month.APRIL, 13))); //Easter Monday
    assertFalse(calendar.isBusinessDay(LocalDate.of(2020, Month.MAY, 1)));
    assertFalse(calendar.isBusinessDay(LocalDate.of(2020, Month.JUNE, 1))); // Whit Monday
    assertFalse(calendar.isBusinessDay(LocalDate.of(2020, Month.AUGUST, 20)));
    assertFalse(calendar.isBusinessDay(LocalDate.of(2020, Month.OCTOBER, 23)));
    assertFalse(calendar.isBusinessDay(LocalDate.of(2020, Month.NOVEMBER, 1)));
    assertFalse(calendar.isBusinessDay(LocalDate.of(2020, Month.DECEMBER, 25)));
    assertFalse(calendar.isBusinessDay(LocalDate.of(2020, Month.DECEMBER, 26)));

  }

}
