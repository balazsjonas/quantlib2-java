package quantlib2;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CashFlowsTest {

  static List<CashFlow> leg = new ArrayList<>();
  static LocalDate today = LocalDate.now();

  @BeforeEach
  void setUp() {
    SavedSettings backup;

    Settings.instance().setEvaluationDate(today);

    for (int i = 0; i < 3; i++) {
      leg.add(new SimpleCashFlow(1, today.plusDays(i)));
    }
  }

  @Test
  void testSettings() {
    // case 1: don't include reference-date payments, no override at
    //         today's date
    Settings.instance().setIncludeReferenceDateEvents(false);
    Settings.instance().setIncludeTodaysCashFlows(Optional.empty());
    CHECK_INCLUSION(0, 0, false);
    CHECK_INCLUSION(0, 1, false);

    CHECK_INCLUSION(1, 0, true);
    CHECK_INCLUSION(1, 1, false);
    CHECK_INCLUSION(1, 2, false);

    CHECK_INCLUSION(2, 1, true);
    CHECK_INCLUSION(2, 2, false);
    CHECK_INCLUSION(2, 3, false);

  }

  static void CHECK_INCLUSION(int n, int days, boolean expected) {
    assertThat(leg.get(n).hasOccurred(today.plusDays(days))).isEqualTo(expected);
  }
}
