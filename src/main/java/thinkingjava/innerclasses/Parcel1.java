package thinkingjava.innerclasses;

/**
 * @author 李重辰
 * @date 2018/10/20 10:52
 */
public class Parcel1 {
  public static void main(String[] args) {
    Parcel1 parcel1 = new Parcel1();
    parcel1.ship("Tasmainia");
  }

  public void ship(String dest) {
    Contents contents = new Contents();
    Destination d = new Destination(dest);
    System.out.println(d.readLabel());
  }

  class Contents {
    private int i = 11;

    public int value() {
      return i;
    }
  }

  class Destination {
    private String label;

    Destination(String whereTo) {
      label = whereTo;
    }

    String readLabel() {
      return label;
    }
  }
}
