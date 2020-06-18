package multithread;

/**
 * @author 李重辰
 * @date 2020/6/17 10:03
 */
public class CreateThreadByThreadFactory {
  public static void main(String[] args) {
    UserThreadFactory factory = new UserThreadFactory("localHost");
    Thread thread;
    for (int i = 0; i < 20; i++) {
      // 注意，当使用线程工厂时，虽然调用了十次new MyRunnable()但是实际上只创建了一个对象
//      thread = factory.newThread(new MyRunnable());
//      thread = factory.newThread(() -> new MyRunnable());
//      thread = factory.newThread(MyRunnable::new);
      thread = factory.newThread(new Runnable() {
        @Override
        public void run() {
          new MyRunnable();
        }
      });
      thread.start();
    }
  }
}

/**
 * 线程类
 */
class MyRunnable implements Runnable {

  public MyRunnable() {
    System.out.println("The constructor is called");
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    try {
      Thread.sleep(100);
      System.out.println(name + hashCode());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
