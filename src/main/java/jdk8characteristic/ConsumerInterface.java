package jdk8characteristic;

/**
 * 自定义函数接口
 *
 * @author 李重辰
 * @date 2019/5/10 21:03
 */
@FunctionalInterface
public interface ConsumerInterface<T> {

  /**
   * 函数式接口是只有唯一方法的接口
   *
   * @param t /
   */
  void accept(T t);
}
