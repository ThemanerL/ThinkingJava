package thinkingjava.initialization.practice;

enum Currency {
  /**
   * 六种货币
   */
  JPY,
  EUR,
  GBP,
  DEM,
  CHF,
  FRF

}

/**
 * @author 李重辰
 * @date 2018/10/1 19:21
 */

public class P21 {
  private Currency currency;

  private P21(Currency currency) {
    this.currency = currency;
  }

  public static void main(String[] args) {
    for (Currency currency : Currency.values()) {
      System.out.println(currency + " , ordinal() " + currency.ordinal());
    }
    P21 p21 = new P21(Currency.CHF);
    p21.enumSwitch();

  }

  private void enumSwitch() {
    System.out.print("This is ");
    switch (currency) {
      case JPY:
        System.out.print("Japan");
        break;
      case CHF:
        System.out.print("Switzerland");
        break;
      case DEM:
        System.out.print("Germany");
        break;
      case EUR:
        System.out.print("European Union");
        break;
      case FRF:
        System.out.print("France");
        break;
      case GBP:
        System.out.print("England");
        break;
      default:
        System.out.print("WHAT");
    }
    System.out.println("'s currency");

  }
}
