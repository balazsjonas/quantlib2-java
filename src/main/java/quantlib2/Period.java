package quantlib2;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Period {

  private final int length;
  private final TimeUnit units;

  public Period() {
    length = 0;
    units = TimeUnit.Days;
  }


  public static Period ofMonths(int months) {
    return new Period(months, TimeUnit.Months);
  }


  public Period(Frequency f) {
    throw new UnsupportedOperationException();
  }

  public Frequency frequency() {
    throw new UnsupportedOperationException();
  }

  public Period div(int n) {
    throw new UnsupportedOperationException();
  }

  public Period plus(Period other) {
    throw new UnsupportedOperationException();
  }

  public Period normalize() {
    throw new UnsupportedOperationException();
  }
}
