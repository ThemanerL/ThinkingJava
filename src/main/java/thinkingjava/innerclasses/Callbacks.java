package thinkingjava.innerclasses;

interface Incrementable {
  /**
   * 增长
   */
  void increment();
}

/**
 * Java中的闭包与回调，具体在第22章用的比较多。
 * 闭包是一个可调用的对象，它记录了一些信息，这些信息来自于创建它的作用域。
 * 内部类是面向对象的闭包。因为它不仅包含外围类对象（创建内部类的作用域）的信息，还自动拥有一个指向此外围类对象的引用，
 * 在此作用域内，内部类有权操作所有的成员，包括private成员。
 *
 * @author 李重辰
 * @date 2018/11/1 10:32
 */
public class Callbacks {
  public static void main(String[] args) {
    Callee1 c1 = new Callee1();
    Callee2 c2 = new Callee2();
    MyIncrement.f(c2);
    Caller caller1 = new Caller(c1);
    Caller caller2 = new Caller(c2.getCallbackReference());
    caller1.go();
    caller1.go();
    caller2.go();
    caller2.go();

  }
}

class Callee1 implements Incrementable {
  private int i = 0;

  @Override
  public void increment() {
    i++;
    System.out.println(i);
  }
}

class MyIncrement {
  static void f(MyIncrement myIncrement) {
    myIncrement.increment();
  }

  public void increment() {
    System.out.println("Other operation");
  }
}

/**
 * Callee2继承自MyIncrement，MyIncrement已经有了一个不同的increment()方法，并且与Incrementable接口期望的increment()方法
 * 完全不相关。所以如果Callee2继承了MyIncrement，就不能为了Incrementable的用途而覆盖increment()方法，于是只能使用内部类
 * 独立的实现Incrementable接口
 * <p>
 * 第73行到81行实现了接口与接口的实现完全的独立。
 */
class Callee2 extends MyIncrement {
  private int i = 0;

  @Override
  public void increment() {
    super.increment();
    i++;
    System.out.println(i);
  }

  Incrementable getCallbackReference() {
    return new Closure();
  }

  /**
   * 内部类实现了Incrmentable，以提供一个返回Gallee2的钩子“hook”——而且这是一个安全的钩子，无论谁获得此类的引用，
   * 都只能调用increment()，没有其他功能。
   */
  private class Closure implements Incrementable {
    @Override
    public void increment() {
      Callee2.this.increment();
    }
  }
}

class Caller {
  private Incrementable callbackReference;

  public Caller(Incrementable callbackReference) {
    this.callbackReference = callbackReference;
  }

  void go() {
    callbackReference.increment();
  }
}
