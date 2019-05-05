package thinkingjava.thread;

/**
 * 线程1 执行add方法num++ 线程1睡眠，线程2开始执行num++ 线程2睡眠
 * 线程1 唤醒，num已经为2 输出，线程2 唤醒，num已经为2输出
 * @author 李重辰
 * @date 2019/4/21 16:08
 */
public class NonSync implements Runnable {
  private Timer timer = new Timer();
  public static void main(String[] args) {
    NonSync nonSync = new NonSync();
    Thread thread1 = new Thread(nonSync);
    Thread thread2 = new Thread(nonSync);

    thread1.setName("线程1");
    thread2.setName("线程2");
    thread1.start();
    thread2.start();
  }

  @Override
  public void run() {
    timer.add(Thread.currentThread().getName());
  }
}

class Timer{
  private static int timer = 0;
  void add(String name){
    timer++;
    try {
      Thread.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(name + ", You are di " + timer + "\tge user timer's thread");
  }
}