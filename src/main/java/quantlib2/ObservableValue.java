package quantlib2;

public class ObservableValue<T> {

  private T value;
  private Observable observable_;

  public ObservableValue() {
    this(null);
  }

  public ObservableValue(T value) {
    observable_ = new Observable();
    this.value = value;
  }

  public T value() {
    return value;
  }
}
