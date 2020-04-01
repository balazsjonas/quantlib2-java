package quantlib2;

import java.time.LocalDate;

public class SimpleCashFlow extends CashFlow {

  private final double amount;
  private final LocalDate date;

  public SimpleCashFlow(double amount, LocalDate date) {
    this.amount = amount;
    this.date = date;
  }

  @Override
  public double amount() {
    return amount;
  }

  @Override
  public LocalDate date() {
    return date;
  }
}
