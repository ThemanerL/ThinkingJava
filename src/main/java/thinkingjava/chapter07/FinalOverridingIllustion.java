package thinkingjava.chapter07;

/**
 * 这会引起混淆，因为如果你试图覆盖一个Private方法（隐式是final），似乎是奏效的，而且编译器也不会给出任何错误信息，
 * 使用@Override解决混淆问题
 *
 * @author 李重辰
 * @date 2018/9/30 10:46
 */
public class FinalOverridingIllustion {
  public static void main(String[] args) {
    OverridingPrivate2 op2 = new OverridingPrivate2();
    op2.f();
    op2.g();
    OverridingPrivate op = op2;
    // 下两行代由于基类的f和g方法都是私有的，虽然被op2继承但是无法访问。
    // 此处只能访问子类的f()g()。
    ((OverridingPrivate2) op).f();
    ((OverridingPrivate2) op).g();
    WithFinals withFinals = op2;
    ((OverridingPrivate2) withFinals).f();
    ((OverridingPrivate2) withFinals).g();
  }
}

class WithFinals {
  private final void f() {
    System.out.println("WithFinals.f()");
  }

  private void g() {
    System.out.println("WithFinal.g()");
  }
}

/**
 * 此类中的f() g()并没有覆盖父类中的f()g(),
 * 所有的private方法隐式的是final的。由于无法访问到private对象，所以也就无法覆盖它。
 * 他只是与父类中的这两个方法具有相同的名称而已。
 */
class OverridingPrivate extends WithFinals {
  private final void f() {
    System.out.println("OverridingPrivate.f()");
  }

  private void g() {
    System.out.println("OverridingPrivate.g()");
  }
}

/**
 * 如果在导出类中以相同的名称生成一个public protected或friendly权限的方法，只是生成了一个新的方法而已。
 * 此类中的f()g()也没有覆盖父类的该方法，生成了一个新的方法。
 */
class OverridingPrivate2 extends OverridingPrivate {
  public final void f() {
    System.out.println("OverridingPrivate2.f()");
  }

  public void g() {
    System.out.println("OverridingPrivate2.g()");
  }
}