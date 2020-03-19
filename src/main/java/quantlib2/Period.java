package quantlib2;


import com.google.common.base.Preconditions;
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
    Preconditions.checkArgument(n != 0, "cannot be divied by zero");
    if(length%n==0) {
      return new Period(length/n, units);
    }
    TimeUnit units = this.units;
    int length = this.length;

    switch (units) {
      case Years:
        length *=12;
        units = TimeUnit.Months;
        break;
      case Weeks:
        length*=7;
        units = TimeUnit.Days;
        break;
    }
    Preconditions.checkArgument(length%n==0, this+" cannot be divided by "+ n);
    return new Period(length/n, units);
  }

  public Period plus(Period other) {
    if (length == 0) {
      return other;
    }
    if (units == other.units) {
      return new Period(length + other.length, units);
    }
    switch (units) {
      case Years:
        switch (other.units) {
          case Months:
            return new Period(length * 12 + other.length, TimeUnit.Months);
          case Weeks:
          case Days:
            throw new IllegalArgumentException("Impossible addition");
          default:
            throw new IllegalArgumentException("Unknown time unit");
        }
      case Months:
        switch (other.units) {
          case Years:
            return new Period(length + 12 * other.length, TimeUnit.Months);
          case Weeks:
          case Days:
            throw new IllegalArgumentException("Impossible addition");
          default:
            throw new IllegalArgumentException("Unknown time unit");
        }
      case Weeks:
        switch (other.units) {
          case Days:
            return new Period(length * 7 + other.length, TimeUnit.Days);
          case Years:
          case Months:
            throw new IllegalArgumentException("Impossible addition");
          default:
            throw new IllegalArgumentException("Unknown time unit");
        }
      case Days:
        switch (other.units) {
          case Weeks:
            return new Period(length + other.length * 7, TimeUnit.Days);
          case Years:
          case Months:
            throw new IllegalArgumentException("Impossible addition");
          default:
            throw new IllegalArgumentException("Unknown time unit");
        }
    }
    return this;
  }

  public Period minus(Period other) {
    return this.plus(new Period(-other.length, other.units));
  }

  public Period normalize() {
    throw new UnsupportedOperationException();
  }
}
