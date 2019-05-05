package thinkingjava.thread.producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 生产者消费者问题 马士兵Demo
 *
 * @author 李重辰
 * @date 2019/4/21 11:45
 */
public class ProducerAndConsumer {
  public static void main(String[] args) {
    Stack stack = new Stack();
    ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.DiscardOldestPolicy());
    executor.execute(new Producer(stack));
    executor.execute(new Consumer(stack));
    executor.shutdown();
  }
}

/**
 * 馒头
 */
class SteamedBread {
  private int number;

  SteamedBread(int number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "SteamedBread{" +
        "number=" + number +
        '}';
  }
}

/**
 * 存放馒头的篮子（栈结构，先进后出）
 */
class Stack {
  private int index = 0;
  private SteamedBread[] arrT = new SteamedBread[6];

  synchronized void push(SteamedBread bread) {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    while (index == arrT.length) {
      try {
        // 正在访问这个方法的线程进入等待
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    this.notifyAll();
    arrT[index++] = bread;
    System.out.println("PUSH " + index);
    System.out.println(Thread.currentThread().getName() + "生产了" + index);
  }

  synchronized void pop() {
    while (index == 0) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    this.notifyAll();

    System.out.println("POP " + index);
    System.out.println(Thread.currentThread().getName() + "消费了" + arrT[--index]);
  }
}

class Producer implements Runnable {
  private Stack stack;

  Producer(Stack stack) {
    this.stack = stack;
  }

  @Override
  public void run() {
    int loop = 12;
    for (int i = 0; i < loop; i++) {
      SteamedBread steamedBread = new SteamedBread(i);
      stack.push(steamedBread);

    }
  }
}

class Consumer implements Runnable {
  private Stack stack;

  Consumer(Stack stack) {
    this.stack = stack;
  }

  @Override
  public void run() {
    int loop = 12;
    for (int i = 0; i < loop; i++) {
      stack.pop();
    }
  }
}