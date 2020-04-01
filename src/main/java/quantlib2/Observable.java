package quantlib2;

import java.util.Collections;
import java.util.Set;

public class Observable {

  private ObservableSettings settings_;
  private Set<Observer> observers_;

  public Observable() {
    this.settings_ = ObservableSettings.getInstance();
  }

  public Observable(Observable other) {
    throw new UnsupportedOperationException();
  }

  public void unregisterObserver(Observer observer) {
    // TODO return int?
    if (settings_.updatesDeferred()) {
      settings_.unregisterDeferredObserver(Collections.singleton(observer));
    }
    observers_.remove(observer);

  }

  public void notifyObservers() {
    if (!settings_.updatesEnabled()) {
      // if updates are only deferred, flag this for later notification
      // these are held centrally by the settings singleton
      settings_.registerDeferredObservers(observers_);
    } else if (observers_.size() > 0) {
      boolean successful = true;
      for (var iterator = observers_.iterator(); iterator.hasNext(); ) {
        try {
          iterator.next().update();
        } catch (Exception e) {
          successful = false;
        }
      }
      if (!successful) {
        throw new RuntimeException("could not notify one or more observers");
      }
    }

  }

}
