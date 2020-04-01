package quantlib2;

import java.time.LocalDate;
import java.util.Optional;

public abstract class Event extends Observable {

  public abstract LocalDate date();

  public boolean hasOccurred(LocalDate d, // refDate
      Optional<Boolean> includeRefDate) {
    LocalDate refDate = (d != null ? d : Settings.instance().evaluationDate().value());
    boolean includeRefDateEvent =
        includeRefDate.isPresent() ? includeRefDate.get()
            : Settings.instance().includeReferenceDateEvents();
    if (!includeRefDateEvent) {
      return date().isBefore(refDate);
    } else {
      return date().isBefore(refDate) || date().isEqual(refDate);
    }
  }

  public final boolean hasOccurred(LocalDate refDate) {
    return hasOccurred(refDate, Optional.empty());
  }

  public final boolean hasOccurred() {
    return hasOccurred(null);
  }


}
