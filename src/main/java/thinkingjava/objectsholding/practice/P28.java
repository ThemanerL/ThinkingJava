package thinkingjava.objectsholding.practice;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author 李重辰
 * @date 2018/11/19 14:09
 */
public class P28 {
  public static void main(String[] args) {
    Random rand = new Random(System.currentTimeMillis());
    PriorityQueue<Double> doubles = new PriorityQueue<>();
    int queueLength = 20;
    for (int i = 0; i < queueLength; i++) {
      doubles.offer(rand.nextDouble() * queueLength);
    }
    while (!doubles.isEmpty()) {
      System.out.println(doubles.poll());
    }
  }
}