package thinkingjava.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程1 执行add方法num++ 线程1睡眠，线程2开始执行num++ 线程2睡眠
 * 线程1 唤醒，num已经为2 输出，线程2 唤醒，num已经为2输出
 *
 * @author 李重辰
 * @date 2019/4/21 16:08
 */
public class NonSync implements Runnable {
  private Timer timer = new Timer();

  public static void main(String[] args) {
    NonSync nonSync = new NonSync();
    ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), new ThreadPoolExecutor.DiscardOldestPolicy());
    pool.execute(nonSync);
    pool.execute(nonSync);
    pool.shutdown();
  }

  @Override
  public void run() {
    timer.add(Thread.currentThread().getName());
  }
}

class Timer {
  private static int timer = 0;

  void add(String name) {
    timer++;
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(name + ", You are di " + timer + "\tge user timer's thread");
  }
}