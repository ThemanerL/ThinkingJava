package thinkingjava.chapter11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author 李重辰
 * @date 2018/11/19 11:43
 */
public class QueueDemo {
  static void printQ(Queue queue){
    while (queue.peek()!=null){
      System.out.print(queue.remove() + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    Random rand = new Random(System.currentTimeMillis());
    int qLength = 10;
    for (int i = 0; i < qLength; i++) {
      queue.offer(rand.nextInt(i + qLength));
    }
    printQ(queue);
    Queue<Character> characters = new LinkedList<>();
    for(char c: "My name is Li zhong chen".toCharArray()){
      characters.offer(c);
    }
    printQ(characters);
  }
}
