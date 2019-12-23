package thinkingjava.typeinfo;

/**
 * 代理模式的简单示例
 *
 * @author 李重辰
 * @date 2019/12/19 17:37
 */
public class SimpleProxyDemo {
  public static void consumer(Interface in) {
    in.doSomething();
    in.somethingElse("banana");
  }

  public static void main(String[] args) {
    consumer(new RealObject());
    SimpleProxy proxy = new SimpleProxy(new RealObject());
    consumer(proxy);
  }
}

interface Interface {
  /**
   * 输出方法的名字
   */
  void doSomething();

  /**
   * 做点事
   *
   * @param arg /
   */
  void somethingElse(String arg);
}

class RealObject implements Interface {

  @Override
  public void doSomething() {
    System.out.println("doSomething");
  }

  @Override
  public void somethingElse(String arg) {
    System.out.println("somethingElse " + arg);
  }
}

class SimpleProxy implements Interface {
  private Interface proxied;

  public SimpleProxy(Interface proxied) {
    this.proxied = proxied;
  }

  @Override
  public void doSomething() {
    long start = System.nanoTime();
    System.out.println("SimpleProxy doSomething");
    proxied.doSomething();
    System.out.println("调用历时" + (System.nanoTime() - start));
  }

  @Override
  public void somethingElse(String arg) {
    long start = System.nanoTime();
    System.out.println("SimpleProxy somethingElse " + arg);
    proxied.somethingElse(arg);
    System.out.println("调用历时" + (System.nanoTime() - start));
  }
}