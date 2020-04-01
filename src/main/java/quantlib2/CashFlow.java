package quantlib2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;

public abstract class CashFlow extends Event implements Comparable<CashFlow> {

  public abstract double amount();

  public LocalDate exCouponDate() {
    return null;
  }

  public boolean tradingExCoupon(LocalDate refDate) {
    LocalDate ecd = exCouponDate();
    if (ecd == null) {
      return false;
    }
    LocalDate ref = refDate != null ? refDate : Settings.instance().evaluationDate().value();

    return !ecd.isAfter(ref);
  }

  public final boolean tradingExCoupon() {
    return tradingExCoupon(null);
  }

  @Override
  public boolean hasOccurred(LocalDate refDate, Optional<Boolean> includeRefDate) {

    // easy and quick handling of most cases
    if(refDate != null) {
      LocalDate cf = date();
      if(refDate.isBefore(cf)) {
        return false;
      }
      if(cf.isBefore(refDate)) {
        return true;
      }
    }

    if(refDate == null || refDate.isEqual(Settings.instance().evaluationDate().value())) {
      // today's date; we override the bool with the one
      // specified in the settings (if any)
      Optional<Boolean> includeToday = Settings.instance().includeTodaysCashFlows();
      if(includeToday.isPresent()) {
        includeRefDate = includeToday;
      }


    }
    return super.hasOccurred(refDate, includeRefDate);
  }

  @Override
  public int compareTo(CashFlow o) {
    return Comparator.comparing(CashFlow::date).compare(this, o);
  }
}
