package thinkingjava.typeinfo;

import thinkingjava.net.mindview.util.Null;

/**
 * @author 李重辰
 * @date 2019/12/20 10:38
 */
class Person {
  public final String first;
  public final String last;
  public final String address;

  @Override
  public String toString() {
    return "{\"Person\":{" +
        "\"first\":\"" + first + '\"' +
        ", \"last\":\"" + last + '\"' +
        ", \"address\":\"" + address + '\"' +
        "}}";
  }

  public Person(String first, String last, String address) {
    this.first = first;
    this.last = last;
    this.address = address;
  }

  /**
   * 当将该方法的作用域范围指定为public时，IDEA 今警告“Referencing subclass NonRegisteredUser from superclass User initializer might lead to class loading deadlock”
   * 据悉，编译器提出的死锁情况只可能出现在多线程情况下。 https://stackoverflow.com/questions/48009445/what-does-class-loading-deadlock-mean-here
   */
  private static class NullPerson extends Person implements Null {

    @Override
    public String toString() {
      return "\"NullPerson\"";
    }

    public NullPerson() {
      super("None", "None", "None");
    }
  }

  /**
   * 通常，空对象都是单例。因此这里可以将其作为静态final实例创建。
   */
  public static final Person NULL = new NullPerson();
}