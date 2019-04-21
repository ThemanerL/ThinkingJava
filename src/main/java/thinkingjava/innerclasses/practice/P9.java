package thinkingjava.innerclasses.practice;

/**
 * 2018/10/29修改，这次使用匿名内部类
 *
 * @author 李重辰
 * @date 2018/10/22 20:07
 */
public class P9 {
  private P9interface getInstance() {
    return new P9interface() {
      @Override
      public void print() {
        System.out.println("P9Inner.print");
      }
    };
  }

  public static void main(String[] args) {
    P9 p9 = new P9();
    p9.getInstance().print();
  }
}

interface P9interface {
  /**
   * 接口中的类必须用javadoc注释
   */
  void print();
}
