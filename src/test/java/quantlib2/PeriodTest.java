package quantlib2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PeriodTest {

  private static Period OneYear = new Period(1, TimeUnit.Years);
  private static Period SixMonths = Period.ofMonths(6);
  private static Period ThreeMonths = Period.ofMonths(3);

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

  @Test
  void testYearsMonthsAlgebraNormalize() {
    assertThat(Period.ofMonths(12)).isEqualTo(Period.ofMonths(12));
    assertThat(Period.ofMonths(12).normalize()).isEqualTo(new Period(1, TimeUnit.Years));
  }

  @Test
  void testWeeksDaysAlgebraDivision() {

  }

  @Test
  void testWeeksDaysAlgebraAddition() {

  }

  @Test
  void testWeeksDaysAlgebraNormalize() {

  }
}
