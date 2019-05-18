package thinkingjava.thread.producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李重辰
 * @date 2019/4/27 10:52
 */
public class LockProducerAndConsumer {

  public static void main(String[] args) {
    Container container = new Container(4);
    ProducerStudent producer = new ProducerStudent(container);
    ProducerStudent consumer = new ProducerStudent(container, 10);
    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 3, 10, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.DiscardOldestPolicy());
    threadPool.execute(producer::putPen);
    threadPool.execute(consumer::getPen);
    threadPool.shutdown();
    try {
      Thread.sleep(2000);
      System.out.println("增加了：" + container.getPutTimes() + " 次\t减少了：" + container.getGetTimes() + " 次");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class ProducerStudent {
  private static int loopTimes = 10;
  private Container container;

  ProducerStudent(Container container, int loopTimes) {
    this.container = container;
    ProducerStudent.loopTimes = loopTimes;
  }

  ProducerStudent(Container container) {
    this.container = container;
  }

  void getPen() {
    for (int i = 0; i < loopTimes; i++) {
      container.remove();
    }
  }

  void putPen() {
    for (int i = 0; i < loopTimes; i++) {
      container.add();
    }
  }
}

class Container {
  private static int pen = 0, putTimes, getTimes;
  private Lock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();
  private int size;

  Container(int size) {
    this.size = size;
  }

  int getPutTimes() {
    return putTimes;
  }

  int getGetTimes() {
    return getTimes;
  }

  void add() {
    lock.lock();
    putTimes++;
    try {
      while (pen == size) {
        condition.await();
      }
      pen++;
      System.out.println("新增了" + pen);
      condition.signalAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  void remove() {
    lock.lock();
    getTimes++;
    try {
      while (pen == 0) {
        condition.await();
      }
      System.out.println("减少了" + pen--);
      condition.signalAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}