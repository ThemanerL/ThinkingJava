package thinkingjava.chapter10;

/**
 * @author 李重辰
 * @date 2018/10/22 10:54
 */
public class DotThis {
  void f() {
    System.out.println("DotThis.f");
  }

  private class Inner {
    private DotThis outer() {
      return DotThis.this;
    }
  }

  private Inner inner() {
    return new Inner();
  }

  public static void main(String[] args) {
    DotThis dt = new DotThis();
    DotThis.Inner dti = dt.inner();
    dti.outer().f();
  }
}
