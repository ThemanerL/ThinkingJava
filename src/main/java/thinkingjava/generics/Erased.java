package thinkingjava.generics;

/**
 * @author 李重辰
 * @date 2019/12/27 7:53
 */
public class Erased<T> {
  private final int SIZE = 100;

  public void f(Object arg) {
    T[] array = (T[]) new Object[SIZE];
  }
}
