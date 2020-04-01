package quantlib2;

import java.time.LocalDate;

public class SimpleEvent extends Event {

  private LocalDate date;

  public SimpleEvent(LocalDate date) {
    this.date = date;
  }

  @Override
  public LocalDate date() {
    return date;
  }
}
