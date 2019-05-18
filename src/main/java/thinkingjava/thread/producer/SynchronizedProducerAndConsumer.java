package thinkingjava.thread.producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 李重辰
 * @date 2019/4/22 0:24
 */
public class SynchronizedProducerAndConsumer {

  public static void main(String[] args) {
    SynchronizedProducerAndConsumer producerConsumer = new SynchronizedProducerAndConsumer();
    Goods goods = new Goods(20);
    Producer producer = producerConsumer.new Producer(goods);
    Consumer consumer = producerConsumer.new Consumer(goods);
    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
        5, 10, 10, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(1),
        new ThreadPoolExecutor.DiscardOldestPolicy());
    threadPool.execute(producer);
    threadPool.execute(consumer);
    threadPool.shutdown();
  }

  class Producer implements Runnable {
    private Goods goods;

    Producer(Goods goods) {
      this.goods = goods;
    }

    @Override
    public void run() {
      for (int j = 0; j < goods.getLoopTimes(); j++) {
        goods.add();
      }
    }

  }

  class Consumer implements Runnable {
    private Goods goods;

    Consumer(Goods goods) {
      this.goods = goods;
    }

    @Override
    public void run() {
      for (int j = 0; j < goods.getLoopTimes(); j++) {
        goods.buy();
      }
    }
  }
}

class Goods {
  private int i;
  private int loopTimes;

  Goods(int loopTimes) {
    this.loopTimes = loopTimes;
  }

  int getLoopTimes() {
    return loopTimes;
  }

  synchronized void buy() {
    while (i == 0) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("买走了" + --i);
    this.notifyAll();
  }

  synchronized void add() {
    while (i == 5) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("增加了" + i++);
    this.notifyAll();
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
