package thinkingjava.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 李重辰
 * @date 2019/4/21 19:28
 */
public class DeadLock {

  public static void main(String[] args) {
    String goods = "goods";
    String money = "money";
    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 2, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.DiscardOldestPolicy());
    poolExecutor.execute(() -> {
      synchronized (goods) {
        System.out.println(Thread.currentThread().getName() + "拿到货");
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (money) {
          System.out.println(Thread.currentThread().getName() + "拿到钱");
        }
      }
    });
    poolExecutor.execute(() -> {
      synchronized (money) {
        System.out.println(Thread.currentThread().getName() + "拿到钱");
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (goods) {
          System.out.println(Thread.currentThread().getName() + "拿到货");
        }
      }
    });

  }
}

