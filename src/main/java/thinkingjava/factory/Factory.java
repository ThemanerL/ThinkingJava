package thinkingjava.factory;

/**
 * @author 李重辰
 * @date 2019/12/19 11:28
 */
public interface Factory <T> {
  /**
   * 工厂方法可以被多态的调用，从而创建恰当的对象。
   * @return T 使得该方法可以在每种Factory中返回不同的类型。
   */
  T create();
}
