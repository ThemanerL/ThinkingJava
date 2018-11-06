package thinkingjava.chapter10;

/**
 * 在第12行和第16行之间加括号是因为，不能直接将语句裸露在类中，必须使用类或者方法块包裹起来。
 * 初始化块的代码被加入到子类构造器之前，父类构造器之后。所以if语句不能作为字段初始化动作的一部分来执行
 *
 * @author 李重辰
 * @date 2018/10/29 19:53
 */
public class Parcel10 {
  private Destination destination(final String dest, final float price) {
    return new Destination() {
      private int cost;

      {
        int i = 100;
        cost = Math.round(price);
        if (cost < i) {
          System.out.println("Over budget!");
        }
      }

      private String label = dest;

      @Override
      public String readLabel() {
        return label;
      }
    };
  }

  public static void main(String[] args) {
    Parcel10 parcel10 = new Parcel10();
    Destination destination = parcel10.destination("ThemanerL", 45.124F);
  }
}
