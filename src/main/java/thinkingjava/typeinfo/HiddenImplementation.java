package thinkingjava.typeinfo;

import thinkingjava.typeinfo.interfacea.FaceA;
import thinkingjava.typeinfo.packageaccess.HiddenC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 现在如果试图将其向下转型为C，则将被禁止。因为在包的外部没有让任何C类型可用。
 *
 * @author 李重辰
 * @date 2019/12/20 19:35
 */
public class HiddenImplementation {
  public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    FaceA a = HiddenC.makeFaceA();
    a.f();
    System.out.println(a.getClass().getName());
    callHiddenMethod(a, "g");
    callHiddenMethod(a, "w");
  }

  static void callHiddenMethod(Object a, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Method g = a.getClass().getDeclaredMethod(methodName);
    g.setAccessible(true);
    g.invoke(a);
  }
}