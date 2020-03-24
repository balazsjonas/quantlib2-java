package quantlib2;

public enum BusinessDayConvention {
  // ISDA
  /**
   * Choose the first business day after the given holiday.
   */
  Following,

  /**
   * Choose the first business day after the given holiday unless it belongs to a different month,
   * in which case choose the first business day before the holiday.
   */
  ModifiedFollowing,

  /**
   * Choose the first business day before the given holiday.
   */
  Preceding,

  // NON ISDA
  /**
   * Choose the first business day before the given holiday unless it belongs to a different month,
   * in which case choose the first business day after the holiday.
   */
  ModifiedPreceding,           /*!<  */

  /**
   * Do not adjust.
   */
  Unadjusted,

  /**
   * Choose the first business day after the given holiday unless that day crosses the mid-month
   * (15th) or the end of month, in which case choose the first business day before the holiday.
   */
  HalfMonthModifiedFollowing,

  /**
   * Choose the nearest business day to the given holiday. If both the preceding and following
   * business days are equally far away, default to following business day.
   */
  Nearest
}
