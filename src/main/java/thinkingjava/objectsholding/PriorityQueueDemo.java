package thinkingjava.objectsholding;

import java.util.*;

/**
 * @author 李重辰
 * @date 2018/11/19 12:44
 */
public class PriorityQueueDemo {
  public static void main(String[] args) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    Random rand = new Random(System.currentTimeMillis());
    int qLength = 10;
    for (int i = 0; i < qLength; i++) {
      priorityQueue.offer(rand.nextInt(i + qLength));
    }
    QueueDemo.printQ(priorityQueue);

    List<Integer> list = Arrays.asList(25, 22, 12, 54, 54, 65, 213, 11, 9, 12, 32, 65, 734, 1);

    priorityQueue = new PriorityQueue<>(list);
    QueueDemo.printQ(priorityQueue);
    priorityQueue = new PriorityQueue<>(list.size(), Collections.reverseOrder());
    priorityQueue.addAll(list);
    QueueDemo.printQ(priorityQueue);

    String sentence = "My name is Joey,Joey";
    List<String> strings = Arrays.asList(sentence.split(" "));
    PriorityQueue<String> stringQueue = new PriorityQueue<>(strings);
    QueueDemo.printQ(stringQueue);
    stringQueue = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
    stringQueue.addAll(strings);
    QueueDemo.printQ(stringQueue);

    Set<Character> set = new HashSet<>();
    for (char c : sentence.toCharArray()) {
      set.add(c);
    }
    PriorityQueue<Character> characterPriorityQueue = new PriorityQueue<>(set);
    QueueDemo.printQ(characterPriorityQueue);
  }
}
