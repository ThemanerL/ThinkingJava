package thinkingjava.innerclasses.practice;

/**
 * @author 李重辰
 * @date 2018/10/22 15:03
 */
public class P2 {
  private String str;

  public P2(String str) {
    this.str = str;
  }

  public class Inner {
    @Override
    public String toString() {
      return "p2{" +
          "str='" + str + '\'' +
          '}';
    }
  }

  @Override
  public String toString() {
    return "p2{" +
        "str='" + str + '\'' +
        '}';
  }
}
