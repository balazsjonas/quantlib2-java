package quantlib2;

import java.time.LocalDate;
import java.util.Optional;

public class SavedSettings {
  LocalDate evaluationDate;
  boolean includeReferenceDateEvents_;
  Optional<Boolean> includeTodaysCashFlows_;
  boolean enforcesTodaysHistoricFixings_;

  public SavedSettings() {
    evaluationDate = Settings.instance().evaluationDate().value();
    includeReferenceDateEvents_ = Settings.instance().includeReferenceDateEvents();
   includeTodaysCashFlows_ = Settings.instance().includeTodaysCashFlows();
    enforcesTodaysHistoricFixings_ = Settings.instance().enforcesTodaysHistoricFixings();
  }
}
