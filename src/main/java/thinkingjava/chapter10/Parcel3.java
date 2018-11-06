package thinkingjava.chapter10;

/**
 * 在拥有外部类对象之前市不可能创建内部类对象的，这是因为内部类对象会暗暗地链接到创建它的外部类对象上，但是如果你
 * 创建的是嵌套类（静态内部类），那么它就不需要对外部类对象的引用
 *
 * @author 李重辰
 * @date 2018/10/22 11:38
 */
public class Parcel3 {
  static private class Contents {
    private int i = 11;

    private Contents(int i) {
      this.i = i;
    }

    private int value() {
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

  public static void main(String[] args) {
    Parcel3 parcel3 = new Parcel3();
    //Parcel3.Contents contents = new Contents(18);也可以
    Parcel3.Contents contents = new Contents(18);
    System.out.println(contents.value());
    Parcel3.Destination destination = parcel3.new Destination("Tasmania");
  }
}
