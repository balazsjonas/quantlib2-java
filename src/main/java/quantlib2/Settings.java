package quantlib2;

import java.time.LocalDate;
import java.util.Optional;

public class Settings {

  private static Settings instance;
  private DateProxy evaluationDate_ = new DateProxy();
  private boolean includeReferenceDateEvents_;
  private Optional<Boolean> includeTodaysCashFlows_;
  private boolean enforcesTodaysHistoricFixings_;

  private Settings() {

  }

  public static Settings instance() {
    if (instance == null) {
      instance = new Settings();
    }
    return instance;
  }

  public DateProxy evaluationDate() {
    return evaluationDate_;
  }

  public void setEvaluationDate(LocalDate date) {
    evaluationDate_ = new DateProxy(date);
  }

  public boolean isEnforcesTodaysHistoricFixings_() {
    return enforcesTodaysHistoricFixings_;
  }

  public boolean isIncludeReferenceDateEvents_() {
    return includeReferenceDateEvents_;
  }

  public Optional<Boolean> getIncludeTodaysCashFlows_() {
    return includeTodaysCashFlows_;
  }

  public boolean includeReferenceDateEvents() {
    return includeReferenceDateEvents_;
  }
  public void setIncludeReferenceDateEvents(boolean includeReferenceDateEvents) {
    this.includeReferenceDateEvents_ = includeReferenceDateEvents;
  }
  public void setIncludeTodaysCashFlows(Optional<Boolean> includeTodaysCashFlows) {
    this.includeTodaysCashFlows_ = includeTodaysCashFlows;
  }

  public Optional<Boolean> includeTodaysCashFlows() {
    return includeTodaysCashFlows_;
  }

  public boolean enforcesTodaysHistoricFixings() {
    return enforcesTodaysHistoricFixings_;
  }


  static class DateProxy extends ObservableValue<LocalDate> {

    public DateProxy() {
    }

    public DateProxy(LocalDate value) {
      super(value);
    }
  }


}
