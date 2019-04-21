package thinkingjava.innerclasses;

/**
 * 内部类的构造器必须链接到指向其外围类对象的引用。指向外围类对象的“秘密的”引用必须被初始化。
 *
 * @author 李重辰
 * @date 2018/11/2 11:31
 */
public class InheritInner extends WithInner.Inner {
  /**
   * 当要生成一个构造器时，默认的构造器并不算好，而且不能只是传递一个指向外围类对象的引用。
   * <p>
   * 此处的Super指的市当前类对象的基类，市InheritInner类的基类是WithInner.Inner
   * 而这个基类市WithInner类的内部类，对于内部类的初始化必须通过外围类对象来初始化。非静态的内部类是经由外围类对象创建的
   *
   * @param withInner
   */
  InheritInner(WithInner withInner) {
    withInner.super();
  }

  public static void main(String[] args) {
    WithInner withInner = new WithInner();
    InheritInner inheritInner = new InheritInner(withInner);
  }

}

class WithInner {
  class Inner {
  }
}
