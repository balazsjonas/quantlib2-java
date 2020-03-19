package quantlib2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PeriodTest {

  private static Period OneYear = new Period(1, TimeUnit.Years);
  private static Period SixMonths = Period.ofMonths(6);
  private static Period ThreeMonths = Period.ofMonths(3);

  private static Period TwoWeeks = new Period(2, TimeUnit.Weeks);
  private static Period OneWeek = new Period(1, TimeUnit.Weeks);
  private static Period ThreeDays = new Period(3, TimeUnit.Days);
  private static Period OneDay = new Period(1, TimeUnit.Days);


  @Test
  void testYearsMonthsAlgebraDivision() {
    assertThat(OneYear.div(4)).isEqualTo(ThreeMonths);
    assertThat(OneYear.div(2)).isEqualTo(SixMonths);
  }

  @Test
  void testYearsMonthsAlgebraAddition() {
    assertThat(ThreeMonths.plus(SixMonths)).isEqualTo(Period.ofMonths(9));
    assertThat(ThreeMonths.plus(SixMonths).plus(OneYear)).isEqualTo(Period.ofMonths(21));
  }

  @Disabled
  @Test
  void testYearsMonthsAlgebraNormalize() {
    assertThat(Period.ofMonths(12)).isEqualTo(Period.ofMonths(12));
    assertThat(Period.ofMonths(12).normalize()).isEqualTo(new Period(1, TimeUnit.Years));
  }

  @Test
  void testWeeksDaysAlgebraDivision() {
    assertThat(TwoWeeks.div(2)).isEqualTo(OneWeek);
    assertThat(OneWeek.div(7)).isEqualTo(OneDay);
  }

  @Test
  void testWeeksDaysAlgebraAddition() {
    assertThat(ThreeDays
        .plus(OneDay)).isEqualTo(new Period(4, TimeUnit.Days));
    assertThat(ThreeDays
        .plus(OneDay)
        .plus(OneWeek)).isEqualTo(new Period(11, TimeUnit.Days));

  }

  @Disabled
  @Test
  void testWeeksDaysAlgebraNormalize() {
    assertThat(new Period(7, TimeUnit.Days)).isEqualTo(new Period(7, TimeUnit.Days));
    assertThat(new Period(7, TimeUnit.Days).normalize()).isEqualTo(new Period(1, TimeUnit.Weeks));

  }
}
