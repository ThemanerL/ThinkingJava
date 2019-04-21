package thinkingjava.innerclasses;

/**
 * @author 李重辰
 * @date 2018/10/20 12:07
 */
public class Parcel2 {
  class Contents {
    private int i = 11;

    public int value() {
      return i;
    }
  }

  class Destination {
    private String label;

    private Destination(String label) {
      this.label = label;
    }

    private String getLabel() {
      return label;
    }
  }

  private Destination to(String s) {
    return new Destination(s);
  }

  private Contents contents() {
    return new Contents();
  }

  private void ship(String dest) {
    Contents contents = contents();
    Destination d = to(dest);
    System.out.println(d.getLabel());
  }

  public static void main(String[] args) {
    Parcel2 parcel2 = new Parcel2();
    parcel2.ship("Tasmania");
    parcel2.ship("Tasia");
    Parcel2 q = new Parcel2();
    //定义内部类引用
    Parcel2.Contents contents = q.contents();
    Parcel2.Destination destination = q.to("Borneo");
  }
}
