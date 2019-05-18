package thinkingjava.innerclasses;

/**
 * @author 李重辰
 * @date 2018/10/22 10:54
 */
public class DotThis {
  public static void main(String[] args) {
    DotThis dt = new DotThis();
    DotThis.Inner dti = dt.inner();
    dti.outer().f();
  }

  void f() {
    System.out.println("DotThis.f");
  }

  private Inner inner() {
    return new Inner();
  }

  private class Inner {
    private DotThis outer() {
      return DotThis.this;
    }
  }
}
