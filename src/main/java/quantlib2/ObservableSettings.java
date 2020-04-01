package quantlib2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ObservableSettings {

  private static ObservableSettings instance;
  private boolean updatesEnabled_, updatesDeferred_;
  private Set<Observer> deferredObservers_ = new HashSet<>();

  private ObservableSettings() {
    this.updatesEnabled_ = true;
    this.updatesDeferred_ = false;
  }

  @Deprecated
  public static ObservableSettings instance() {
    return getInstance();
  }
  public static ObservableSettings getInstance() {
    if (instance == null) {
      instance = new ObservableSettings();
    }
    return instance;
  }

  public void disableUpdates(boolean deferred) {
    updatesEnabled_ = false;
    updatesDeferred_ = deferred;
  }

  public final void disableUpdates() {
    this.disableUpdates(false);
  }

  public boolean updatesEnabled() {
    return updatesEnabled_;
  }

  public boolean updatesDeferred() {
    return updatesDeferred_;
  }

  public void registerDeferredObservers(Collection<Observer> observers) {
    deferredObservers_.addAll(observers);
  }

  public void unregisterDeferredObserver(Collection<Observer> observers) {
    deferredObservers_.removeAll(observers);

  }


}
