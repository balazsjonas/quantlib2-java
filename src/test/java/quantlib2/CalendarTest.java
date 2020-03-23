package quantlib2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

  @Test
  void testUKSettlement() {

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

  @Disabled
  @Test
  void testGermanySettlement() {
    fail("not implemented");
  }

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


  @Test
  void testUSSettlement() {

    List<LocalDate> expectedHol = new ArrayList<>();

    expectedHol.add(Date(1, January, 2004));
    expectedHol.add(Date(19, January, 2004));
    expectedHol.add(Date(16, February, 2004));
    expectedHol.add(Date(31, May, 2004));
    expectedHol.add(Date(5, July, 2004));
    expectedHol.add(Date(6, September, 2004));
    expectedHol.add(Date(11, October, 2004));
    expectedHol.add(Date(11, November, 2004));
    expectedHol.add(Date(25, November, 2004));
    expectedHol.add(Date(24, December, 2004));

    expectedHol.add(Date(31, December, 2004));
    expectedHol.add(Date(17, January, 2005));
    expectedHol.add(Date(21, February, 2005));
    expectedHol.add(Date(30, May, 2005));
    expectedHol.add(Date(4, July, 2005));
    expectedHol.add(Date(5, September, 2005));
    expectedHol.add(Date(10, October, 2005));
    expectedHol.add(Date(11, November, 2005));
    expectedHol.add(Date(24, November, 2005));
    expectedHol.add(Date(26, December, 2005));

    Calendar calendar = new UnitedStatesSettlement();
    List<LocalDate> hol = calendar.holidayList(Date(1, January, 2004),
        Date(31, December, 2005));

    assertEquals(expectedHol.size(), hol.size(), "size");
    for (int i = 0; i < hol.size(); i++) {
      assertThat(hol.get(i)).isEqualTo(expectedHol.get(i));
    }

    // before Uniform Monday Holiday Act
    expectedHol = new ArrayList<>();
    expectedHol.add(Date(2, January, 1961));
    expectedHol.add(Date(22, February, 1961));
    expectedHol.add(Date(30, May, 1961));
    expectedHol.add(Date(4, July, 1961));
    expectedHol.add(Date(4, September, 1961));
    expectedHol.add(Date(10, November, 1961));
    expectedHol.add(Date(23, November, 1961));
    expectedHol.add(Date(25, December, 1961));

    hol = calendar.holidayList(Date(1, January, 1961),
        Date(31, December, 1961));

    assertEquals(expectedHol.size(), hol.size(), "size");
    for (int i = 0; i < hol.size(); i++) {
      assertThat(hol.get(i)).isEqualTo(expectedHol.get(i));
    }
  }

  @Test
  void testUSGovernmentBondMarket() {
    List<LocalDate> expectedHol = new ArrayList<>();
    expectedHol.add(Date(1,January,2004));
    expectedHol.add(Date(19,January,2004));
    expectedHol.add(Date(16,February,2004));
    expectedHol.add(Date(9,April,2004));
    expectedHol.add(Date(31,May,2004));
    expectedHol.add(Date(11,June,2004)); // Reagan's funeral
    expectedHol.add(Date(5,July,2004));
    expectedHol.add(Date(6,September,2004));
    expectedHol.add(Date(11,October,2004));
    expectedHol.add(Date(11,November,2004));
    expectedHol.add(Date(25,November,2004));
    expectedHol.add(Date(24,December,2004));

    Calendar calendar = new UnitedStatesGovernmentBond();
    List<LocalDate> hol = calendar.holidayList(Date(1,January,2004),
        Date(31,December,2004));

    assertEquals(expectedHol.size(), hol.size(), "size");
    for (int i = 0; i < hol.size(); i++) {
      assertThat(hol.get(i)).isEqualTo(expectedHol.get(i));
    }
  }

  @Test
  void testUSNewYorkStockExchange() {

    List<LocalDate> expectedHol = new ArrayList<>();
    expectedHol.add(Date(1, January, 2004));
    expectedHol.add(Date(19, January, 2004));
    expectedHol.add(Date(16, February, 2004));
    expectedHol.add(Date(9, April, 2004));
    expectedHol.add(Date(31, May, 2004));
    expectedHol.add(Date(11, June, 2004));
    expectedHol.add(Date(5, July, 2004));
    expectedHol.add(Date(6, September, 2004));
    expectedHol.add(Date(25, November, 2004));
    expectedHol.add(Date(24, December, 2004));

    expectedHol.add(Date(17, January, 2005));
    expectedHol.add(Date(21, February, 2005));
    expectedHol.add(Date(25, March, 2005));
    expectedHol.add(Date(30, May, 2005));
    expectedHol.add(Date(4, July, 2005));
    expectedHol.add(Date(5, September, 2005));
    expectedHol.add(Date(24, November, 2005));
    expectedHol.add(Date(26, December, 2005));

    expectedHol.add(Date(2, January, 2006));
    expectedHol.add(Date(16, January, 2006));
    expectedHol.add(Date(20, February, 2006));
    expectedHol.add(Date(14, April, 2006));
    expectedHol.add(Date(29, May, 2006));
    expectedHol.add(Date(4, July, 2006));
    expectedHol.add(Date(4, September, 2006));
    expectedHol.add(Date(23, November, 2006));
    expectedHol.add(Date(25, December, 2006));

    Calendar calendar = new UnitedStatesNyse();
    List<LocalDate> hol = calendar.holidayList(Date(1, January, 2004),
        Date(31, December, 2006));

    assertEquals(expectedHol.size(), hol.size(), "size");
    for (int i = 0; i < hol.size(); i++) {
      assertThat(hol.get(i)).isEqualTo(expectedHol.get(i));
    }

    List<LocalDate> histClose = new ArrayList<>();
    histClose.add(Date(30, October, 2012));  // Hurricane Sandy
    histClose.add(Date(29, October, 2012));  // Hurricane Sandy
    histClose.add(Date(11, June, 2004));     // Reagan's funeral
    histClose.add(Date(14, September, 2001));// September 11, 2001
    histClose.add(Date(13, September, 2001));// September 11, 2001
    histClose.add(Date(12, September, 2001));// September 11, 2001
    histClose.add(Date(11, September, 2001));// September 11, 2001
    histClose.add(Date(27, April, 1994));    // Nixon's funeral.
    histClose.add(Date(27, September, 1985));// Hurricane Gloria
    histClose.add(Date(14, July, 1977));     // 1977 Blackout
    histClose.add(Date(25, January, 1973));  // Johnson's funeral.
    histClose.add(Date(28, December, 1972)); // Truman's funeral
    histClose.add(Date(21, July, 1969));     // Lunar exploration nat. day
    histClose.add(Date(31, March, 1969));    // Eisenhower's funeral
    histClose.add(Date(10, February, 1969)); // heavy snow
    histClose.add(Date(5, July, 1968));      // Day after Independence Day
    histClose.add(Date(9, April, 1968));     // Mourning for MLK
    histClose.add(Date(24, December, 1965)); // Christmas Eve
    histClose.add(Date(25, November, 1963)); // Kennedy's funeral
    histClose.add(Date(29, May, 1961));      // Day before Decoration Day
    histClose.add(Date(26, December, 1958)); // Day after Christmas
    histClose.add(Date(24, December, 1956)); // Christmas Eve
    histClose.add(Date(24, December, 1954)); // Christmas Eve
    // June 12-Dec. 31, 1968
    // Four day week (closed on Wednesdays) - Paperwork Crisis
    histClose.add(Date(12, Jun, 1968));
    histClose.add(Date(19, Jun, 1968));
    histClose.add(Date(26, Jun, 1968));
    histClose.add(Date(3, Jul, 1968));
    histClose.add(Date(10, Jul, 1968));
    histClose.add(Date(17, Jul, 1968));
    histClose.add(Date(20, Nov, 1968));
    histClose.add(Date(27, Nov, 1968));
    histClose.add(Date(4, Dec, 1968));
    histClose.add(Date(11, Dec, 1968));
    histClose.add(Date(18, Dec, 1968));
    // Presidential election days
    histClose.add(Date(4, Nov, 1980));
    histClose.add(Date(2, Nov, 1976));
    histClose.add(Date(7, Nov, 1972));
    histClose.add(Date(5, Nov, 1968));
    histClose.add(Date(3, Nov, 1964));

    for (int i = 0; i < histClose.size(); i++) {
      assertTrue(calendar.isHoliday(histClose.get(i)), histClose.get(i) +
          " should be holdiay (historical close)");
    }
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

  protected static final Month Jan = Month.JANUARY;
  protected static final Month Feb = Month.FEBRUARY;
  protected static final Month Mar = Month.MARCH;
  protected static final Month Apr = Month.APRIL;

  protected static final Month Jun = Month.JUNE;
  protected static final Month Jul = Month.JULY;
  protected static final Month Aug = Month.AUGUST;
  protected static final Month Sep = Month.SEPTEMBER;
  protected static final Month Oct = Month.OCTOBER;
  protected static final Month Nov = Month.NOVEMBER;
  protected static final Month Dec = Month.DECEMBER;
}
