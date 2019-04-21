package thinkingjava.innerclasses;

/**
 * 通过实例初始化，达到为匿名内部类创建一个构造器的效果
 * 在此处不要求变量i一定是final的。因为i被传递给匿名类的基类的构造器，它并不会在匿名类内部被直接使用
 * 此时应对注意，如果这个变量在匿名类内部被直接使用就一定要使用final关键字修饰
 *
 * @author 李重辰
 * @date 2018/10/24 21:51
 */
public class AnonymousConstructor {
  private static Base getBase(int i) {
    return new Base(i) {
      {
        System.out.println("Inside instance initializer");
      }

      @Override
      public void f() {
        System.out.println("AnonymousConstructor.f：");
      }
    };
  }

  public static void main(String[] args) {
    Base base = getBase(88);
    base.f();
  }
}

abstract class Base {
  /**
   * 抽象类的方法也必须使用javadoc注释
   *
   * @param i
   */
  Base(int i) {
    System.out.println("Base constructor, i = " + i);
  }

  /**
   * 抽象类的方法也必须使用javadoc注释
   */
  public abstract void f();
}