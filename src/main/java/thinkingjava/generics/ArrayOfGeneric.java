package thinkingjava.generics;

/**
 * @author 李重辰
 * @date 2019/12/27 19:46
 */
public class ArrayOfGeneric {
  static final int SIZE = 100;
  static Generic<Integer>[] gia;

  public static void main(String[] args) {
    /// 会产生ClassCastException, 因为Object[SIZE]只是在编译器被转为Generic<Integer>[]，在运行时它依然是一个Object数组。
//    gia = (Generic<Integer>[]) new Object[SIZE];
    gia = (Generic<Integer>[]) new Generic[SIZE];
    System.out.println(gia.getClass().getSimpleName());
    gia[0] = new Generic<>();
  }
}
