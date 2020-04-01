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

    boolean includeReferenceDateEvents = Settings.instance().includeReferenceDateEvents();
    Optional<Boolean> includeTodaysCashFlows = Settings.instance().includeTodaysCashFlows();

    if (!includeReferenceDateEvents) {
      if (includeTodaysCashFlows.isEmpty() || !includeTodaysCashFlows.get()) {
        if (date().isEqual(refDate)) {
          return false;
        }
        if (date().isAfter(refDate)) {
          return true;
        }
        if (date().isBefore(refDate)) {
          return false;
        }
      }
    } else {
      if (includeTodaysCashFlows.isEmpty()) {
        if (date().isAfter(refDate) || date().isEqual(refDate)) {
          return true;
        } else {
          return false;
        }
      }
      if (includeTodaysCashFlows.isPresent() && includeTodaysCashFlows.get()) {
        if (date().isBefore(refDate)) {
          return false;
        } else {
          return true;
        }
      }
      if (includeTodaysCashFlows.isPresent() && !includeTodaysCashFlows.get()) {
        if (date().isBefore(refDate)) {
          return false;
        }
        if (date().isAfter(refDate)) {
          return true;
        }
        var today = Settings.instance().evaluationDate().value();
        if (refDate.isEqual(today)) {
          return false;
        }else {
          return true;
        }
      }
    }
    // easy and quick handling of most cases
    if (refDate != null) {
      LocalDate cf = date();
      if (refDate.isBefore(cf)) {
        return false;
      }
      if (cf.isBefore(refDate)) {
        return true;
      }
    }

    if (refDate == null || refDate.isEqual(Settings.instance().evaluationDate().value())) {
      // today's date; we override the bool with the one
      // specified in the settings (if any)
      Optional<Boolean> includeToday = Settings.instance().includeTodaysCashFlows();
      if (includeToday.isPresent()) {
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
