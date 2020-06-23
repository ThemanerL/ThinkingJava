package thinkingjava.generics;

/**
 * @author 李重辰
 * @date 2020/6/22 20:16
 */
public class BasicHolder<T> {
  T element;

  void set(T arg) {
    element = arg;
  }

  T get() {
    return element;
  }

  void f() {
    System.out.println(element.getClass().getSimpleName());
  }
}
