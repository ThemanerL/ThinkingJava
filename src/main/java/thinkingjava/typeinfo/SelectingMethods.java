package thinkingjava.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface SomeMethods {
  void boring1();

  void boring2();

  void interesting(String arg);

  void nothing();
}

/**
 * Looking for particular methods in a dynamic proxy.
 *
 * @author 李重辰
 * @date 2019/12/20 7:18
 */
class SelectingMethods {
  public static void main(String[] args) {
    SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(SelectingMethods.class.getClassLoader(), new Class[]{SomeMethods.class}, new MethodsSelector(new Implementation()));
    proxy.boring1();
    proxy.boring2();
    proxy.interesting("love?");
    proxy.nothing();
  }
}

class MethodsSelector implements InvocationHandler {
  private Object proxied;

  public MethodsSelector(Object proxied) {
    this.proxied = proxied;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String methodName = "interesting";
    if (method.getName().equals(methodName)) {
      System.out.println("Proxy detected the interesting method");
    }
    return method.invoke(proxied, args);
  }
}

class Implementation implements SomeMethods {
  @Override
  public void boring1() {
    System.out.println("Implementation.boring1");
  }

  @Override
  public void boring2() {
    System.out.println("Implementation.boring2");
  }

  @Override
  public void interesting(String arg) {
    System.out.println("Implementation.interesting. arg: " + arg);
  }

  @Override
  public void nothing() {
    System.out.println("Implementation.nothing");
  }
}