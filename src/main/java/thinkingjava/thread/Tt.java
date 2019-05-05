package thinkingjava.thread;

import java.util.concurrent.*;

/**
 * 面试题
 * synchronized只锁定了被标注的方法，该方法只会被一个线程进来。但是，此时main线程继续执行，可以进入到没有被synchronized修饰的方法中。
 * 1）m1进来先睡眠再赋值
 * 1.Thread-1进来m1方法，进入等待状态。
 * 2.main线程进入到m2方法，获取到b的值为100，输出。
 * 3.线程1休眠时间到，唤醒，修改b为1000，输出，END。
 * 2）m1方法先赋值再睡眠
 * 1.Thread-1进来m1方法，修改b的值为1000
 * 2.Thread-1睡眠，main线程进入到m2，获取到b的值为1000，输出
 * 3.Thread-1唤醒，输出b的值1000，END。
 *
 * @author 李重辰
 * @date 2019/4/21 20:23
 */
public class Tt {
  private int b = 100;

  private synchronized void m1() {
    try {
      b = 1000;
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Tt.m1 b=" + b);
  }

  private void m2() {
    b=2000;
    System.out.println("Tt.m2 b=" + b);
  }

  public static void main(String[] args) {
    Tt tt = new Tt();
    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
        3, 3, 10, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(1),
        new ThreadPoolExecutor.DiscardOldestPolicy());
    threadPool.execute(tt::m1);
    tt.m2();
    ReturnThread returnThread = new ReturnThread();
    Future<Integer> submit = threadPool.submit(returnThread);
    try {
      System.out.println(submit.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    threadPool.shutdown();
  }
}

class ReturnThread implements Callable<Integer> {
  @Override
  public Integer call() {
    System.out.println("ReturnThread.call");
    return 1;
  }
}
