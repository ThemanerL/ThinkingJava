package thinkingjava.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author 李重辰
 * @date 2019/12/19 18:08
 */
public class SimpleDynamicProxy {
  public static void consumer(Interface in){
    in.doSomething();
    in.somethingElse("banana");
  }

  public static void main(String[] args) {
    RealObject real = new RealObject();
    consumer(real);
    Interface proxy = (Interface) Proxy.newProxyInstance(
        Interface.class.getClassLoader(),
        new Class[]{Interface.class},
        new DynamicProxyHandler(real)
    );
    consumer(proxy);
  }
}

class DynamicProxyHandler implements InvocationHandler {
  private Object proxied;

  public DynamicProxyHandler(Object proxied) {
    this.proxied = proxied;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("**** proxy: " + proxy.getClass() + ",method: " + method + ",args: " + Arrays.toString(args));
    return method.invoke(proxied, args);
  }
}
