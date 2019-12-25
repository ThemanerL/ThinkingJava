package thinkingjava.generics;

/**
 * @author 李重辰
 * @date 2019/12/25 18:00
 */
public class GenericMethods {
  public <T, F, D> void f(T x, F f, D d) {
    System.out.println(x.getClass().getName());
    System.out.println(f.getClass().getName());
    System.out.println(d.getClass().getName());
  }

  public static void main(String[] args) {
    GenericMethods gm = new GenericMethods();
    gm.f("", 1.0, 8);
    gm.f(1, 'S', false);
    gm.f(gm, "string", true);
  }
}
