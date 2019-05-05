package thinkingjava.thread.producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 李重辰
 * @date 2019/4/27 11:54
 */
public class Practice {
  public static void main(String[] args) {
    Bucket bucket = new Bucket(5);
    Buyer buyer = new Buyer(bucket);
    Seller seller = new Seller(bucket);
    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3,3,10, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(2),new ThreadPoolExecutor.DiscardPolicy());
    threadPool.execute(buyer::buyBread);
    threadPool.execute(seller::addBread);
    threadPool.shutdown();
  }
}
class Buyer{
  private Bucket bucket;

  public Buyer(Bucket bucket) {
    this.bucket = bucket;
  }

  void buyBread(){
    int loopTimes = 10;
    for (int i = 0; i < loopTimes; i++) {
      int bread = bucket.getBread();
      System.out.println("买到了" + bread + "号面包");

    }
  }
}

class Seller{
  private Bucket bucket;

  public Seller(Bucket bucket) {
    this.bucket = bucket;
  }

  void addBread(){
    int loopTimes = 10;
    for (int i = 0; i < loopTimes; i++) {
      bucket.putBread(i);
      System.out.println("存入了" + i + "号面包");
    }
  }
}


class Bucket {
  private int[] bread;
  private int index = 0;

  Bucket(int size) {
    bread = new int[size];
  }

  synchronized void putBread(int i) {
    while(index==bread.length-1){
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    bread[index++] = i;
    this.notifyAll();
  }

  synchronized int getBread(){
    while (index==0){
      try{
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    int i = bread[--index];
    this.notifyAll();
    return i;
  }
}
