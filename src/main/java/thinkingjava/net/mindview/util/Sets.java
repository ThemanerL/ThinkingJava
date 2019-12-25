package thinkingjava.net.mindview.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 李重辰
 * @date 2019/12/25 19:59
 */
public class Sets {

  /**
   * 并集
   *
   * @param a
   * @param b
   * @param <T>
   * @return
   */
  public static <T> Set<T> union(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<>(a);
    result.addAll(b);
    return result;
  }

  /**
   * 交集
   *
   * @param a
   * @param b
   * @param <T>
   * @return
   */
  public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<>(a);
    result.retainAll(b);
    return result;
  }

  /**
   * 子集
   *
   * @param superset
   * @param subset
   * @param <T>
   * @return
   */
  public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
    Set<T> result = new HashSet<>(superset);
    result.retainAll(subset);
    return result;
  }

  /**
   * 补集
   *
   * @param a
   * @param b
   * @param <T>
   * @return
   */
  public static <T> Set<T> complement(Set<T> a, Set<T> b) {
    return difference(union(a, b), intersection(a, b));
  }
}
