package thinkingjava.net.mindview.util;

/**
 * @author Administrator
 */
public interface Generator<T> {
  /**
   * 返回参数化的 T
   *
   * @return T
   */
  T next();
}
