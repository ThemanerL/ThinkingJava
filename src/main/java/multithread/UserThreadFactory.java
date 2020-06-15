package multithread;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 李重辰
 * @date 2020/6/15 22:07
 */
public class UserThreadFactory implements ThreadFactory {
  private final String namePrefix;
  private final AtomicInteger nextId = new AtomicInteger(1);

  /**
   * 定义线程组名称，在jstack问题排查时，非常有帮助
   *
   * @param whatFeatureOfGroup 建议使用机房编号等
   */
  public UserThreadFactory(String whatFeatureOfGroup) {
    this.namePrefix = "From User ThreadFactory's " + whatFeatureOfGroup + "-Worker-";
  }

  @Override
  public Thread newThread(@NotNull Runnable r) {
    return new Thread(() -> {
      String name = namePrefix + nextId.getAndIncrement();
      Thread thread = new Thread(null, r, name, 0, false);
      System.out.println(thread.getName());
    });
  }
}
