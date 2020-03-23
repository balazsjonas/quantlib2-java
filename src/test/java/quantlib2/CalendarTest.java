package quantlib2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalendarTest {


  @Disabled
  @Test
  void testRussia() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testBrazil() {
    fail("not implemented");
  }

  //    @Disabled@Test void testItalySettlement() {fail("not implemented");}
  @Disabled
  @Test
  void testItalyExchange() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testUKSettlement() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testUKExchange() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testUKMetals() {
    fail("not implemented");
  }

  //    @Disabled@Test void testGermanySettlement() {fail("not implemented");}
  @Disabled
  @Test
  void testGermanyFrankfurt() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testGermanyXetra() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testGermanyEurex() {
    fail("not implemented");
  }


  @Test
  void testTARGET() {

    List<LocalDate> expectedHol = new ArrayList<>();
    expectedHol.add(Date(1, January, 1999));
    expectedHol.add(Date(31, December, 1999));

    expectedHol.add(Date(21, April, 2000));
    expectedHol.add(Date(24, April, 2000));
    expectedHol.add(Date(1, May, 2000));
    expectedHol.add(Date(25, December, 2000));
    expectedHol.add(Date(26, December, 2000));

    expectedHol.add(Date(1, January, 2001));
    expectedHol.add(Date(13, April, 2001));
    expectedHol.add(Date(16, April, 2001));
    expectedHol.add(Date(1, May, 2001));
    expectedHol.add(Date(25, December, 2001));
    expectedHol.add(Date(26, December, 2001));
    expectedHol.add(Date(31, December, 2001));

    expectedHol.add(Date(1, January, 2002));
    expectedHol.add(Date(29, March, 2002));
    expectedHol.add(Date(1, April, 2002));
    expectedHol.add(Date(1, May, 2002));
    expectedHol.add(Date(25, December, 2002));
    expectedHol.add(Date(26, December, 2002));

    expectedHol.add(Date(1, January, 2003));
    expectedHol.add(Date(18, April, 2003));
    expectedHol.add(Date(21, April, 2003));
    expectedHol.add(Date(1, May, 2003));
    expectedHol.add(Date(25, December, 2003));
    expectedHol.add(Date(26, December, 2003));

    expectedHol.add(Date(1, January, 2004));
    expectedHol.add(Date(9, April, 2004));
    expectedHol.add(Date(12, April, 2004));

    expectedHol.add(Date(25, March, 2005));
    expectedHol.add(Date(28, March, 2005));
    expectedHol.add(Date(26, December, 2005));

    expectedHol.add(Date(14, April, 2006));
    expectedHol.add(Date(17, April, 2006));
    expectedHol.add(Date(1, May, 2006));
    expectedHol.add(Date(25, December, 2006));
    expectedHol.add(Date(26, December, 2006));

    Calendar calendar = new TARGET();
    List<LocalDate> hol = calendar.holidayList(Date(1, January, 1999),
        Date(31, December, 2006));

    assertEquals(expectedHol.size(), hol.size(), "size");
    for (int i = 0; i < hol.size(); i++) {
      assertThat(hol.get(i)).isEqualTo(expectedHol.get(i));
    }

  }

  @Disabled
  @Test
  void testUSSettlement() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testUSGovernmentBondMarket() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testUSNewYorkStockExchange() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testSouthKoreanSettlement() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testKoreaStockExchange() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testChinaSSE() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testChinaIB() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testModifiedCalendars() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testJointCalendars() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testBespokeCalendars() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testEndOfMonth() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testBusinessDaysBetween() {
    fail("not implemented");
  }

  @Disabled
  @Test
  void testIntradayAddHolidays() {
    fail("not implemented");
  }

  public static LocalDate Date(int day, Month month, int year) {
    return LocalDate.of(year, month, day);
  }

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
}
