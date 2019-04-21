package thinkingjava.objectsholding;

import java.util.*;

/**
 * foreach 可以用于数组或其他任何Iterable,但是这并不意味着数组肯定也是一个Iterable,而任何自动包装也不会自动发生;
 *
 * @author 李重辰
 * @date 2018/11/21 13:01
 */
public class ArraysIsNotIterable {
  private static <T> void test(Iterable<T> ib) {
    for (T t : ib) {
      System.out.println(t + " ");
    }
  }

  public static void main(String[] args) {
    test(Arrays.asList(1, 2, 3));
    String[] strings = {"A", "B", "C"};
    test(Arrays.asList(strings));
  }
}


