package multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * volatile 指令重排序
 *
 * @author 李重辰
 * @date 2019/8/1 9:31
 */
public class PossibleReordering {
  private static int x = 0, y = 0;
  private static int as = 0, bs = 0;

  public static void main(String[] args) {
    int loopTimes = 15;
    for (int i = 0; i < loopTimes; i++) {
      new PossibleReordering().process();
    }
  }

  private void process() {
    ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.DiscardPolicy());
    pool.execute(() -> {
      as = 1;
      x = bs;
    });
    pool.execute(() -> {
      bs = 1;
      y = as;
    });
    System.out.println("(" + x + "," + y + ")");
    pool.shutdown();
  }
}