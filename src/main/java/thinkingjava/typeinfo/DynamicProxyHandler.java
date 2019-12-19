package thinkingjava.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 李重辰
 * @date 2019/12/19 18:08
 */
public class DynamicProxyHandler implements InvocationHandler {
  private Object peoxied;

  public DynamicProxyHandler(Object peoxied) {
    this.peoxied = peoxied;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("**** proxy: " + proxy.getClass() + ",method: " + method + ",args: " + Arrays.toString(args));
    return method.invoke(proxy, args);
  }
}
// TODO: 2019/12/19 18:11
