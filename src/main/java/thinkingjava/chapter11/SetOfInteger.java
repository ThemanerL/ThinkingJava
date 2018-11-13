package thinkingjava.chapter11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @author 李重辰
 * @date 2018/11/13 11:34
 */
public class SetOfInteger {
  public static void main(String[] args) {
    Random rand = new Random(System.currentTimeMillis());
    Set<Integer> integerSet = new HashSet<>();
    int max = 1000;
    for (int i = 0; i < max; i++) {
      integerSet.add(rand.nextInt(30));
    }
    Iterator<Integer> iterator = integerSet.iterator();
    while (iterator.hasNext()){
      System.out.print(iterator.next()+" ");
    }
  }
}
