package thinkingjava.access;

/**
 * @author 李重辰
 * @date 2018/9/27 9:39
 */
public class Lunch {
  public static void main(String[] args) {
    One.o1.f();
  }

  void test() {
    Soup priv2 = Soup.makeSoup();
    Sandwich f1 = new Sandwich();
    Soup.access().f();
  }
}

class Soup {
  private static Soup ps1 = new Soup();

  private Soup() {
  }

  /**
   * 类本身不是public的，所以类的方法用public修饰是没有意义的。因为类只能由同一个包的其他类访问，
   * 而同一个包的其他类访问这个类的方法是不需要public的，默认的friendly即可。
   *
   * @return Soup
   */
  public static Soup makeSoup() {
    return new Soup();
  }

  public static Soup access() {
    return ps1;
  }

  public void f() {
    System.out.println("Soup.f()");
  }
}

class Sandwich {
  void f() {
    new Lunch();
  }
}

class One {
  protected static One o1 = new One();

  private One() {
  }

  protected void f() {
    System.out.println("From One.f()");
  }
}