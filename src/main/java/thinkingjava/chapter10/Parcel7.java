package thinkingjava.chapter10;

/**
 * 创建一个继承自Contents的匿名类的对象。
 *
 * @author 李重辰
 * @date 2018/10/24 21:15
 */
public class Parcel7 {
  private Contents contents() {
    return new Contents() {
      private int i = 11;

      @Override
      public int value() {
        return i;
      }
    };
  }

  public static void main(String[] args) {
    Parcel7 parcel7 = new Parcel7();
    Contents contents = parcel7.contents();
    System.out.println(contents.value());
  }
}
