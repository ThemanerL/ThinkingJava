package thinkingjava.innerclasses.controller;

/**
 * 控制框架。
 * 应用程序框架就是被设计用来解决某类特定问题的一个类或者一组类。运用某个应用程序框架，通常是继承一个或多个类，并覆盖某些
 * 方法。在覆盖后的方法中，编码定制应用程序框架提供的通用解决方案，以解决你的特定问题（是设计模式中模板方法的一个例子）
 *
 * @author 李重辰
 * @date 2018/11/1 14:48
 */
public abstract class AbstractEvent {
  protected final long delayTime;
  private long eventTime;

  public AbstractEvent(long delayTime) {
    this.delayTime = delayTime;
  }

  /**
   * nanoTime返回纳秒，只能用来计算时间差
   * Start获取当前时间然后加上一个延迟时间，生成触发事件的时间
   */
  public void start() {
    eventTime = System.nanoTime() + delayTime;
  }

  public boolean ready() {
    return System.nanoTime() >= eventTime;
  }

  /**
   * 具体的行为
   */
  public abstract void action();
}
