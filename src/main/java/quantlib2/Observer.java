package quantlib2;

import java.util.HashSet;
import java.util.Set;

public abstract class Observer {

  private Set<Observable> observables_ = new HashSet<>();

  public Observer() {

  }

  public Observer(Observer other) {
throw new UnsupportedOperationException();
  }

  public abstract void update();
  public void deepUpdate() {
    throw new UnsupportedOperationException();
  }
  // TODO:
//  // observer interface
//  std::pair<iterator, bool>
//  registerWith(const ext::shared_ptr<Observable>&);
//
//  /*! register with all observables of a given observer. Note
//      that this does not include registering with the observer
//      itself. */
//  void registerWithObservables(const ext::shared_ptr<Observer>&);
//  Size unregisterWith(const ext::shared_ptr<Observable>&);
//  void unregisterWithAll();

}
