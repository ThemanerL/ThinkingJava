package thinkingjava.objectsholding;

import java.util.*;

/**
 * @author 李重辰
 * @date 2018/11/22 13:29
 */
public class MultiIterableClass extends IterableClass {
  public static void main(String[] args) {
    MultiIterableClass strings = new MultiIterableClass();
    for (String s : strings.reversed()) {
      System.out.println(s + " ");
    }
    System.out.println();
    for (String s : strings.randomized()) {
      System.out.println(s + " ");
    }
    System.out.println();
    for (String s : strings) {
      System.out.println(s + " ");
    }
  }

  private Iterable<String> reversed() {
    return () -> new Iterator<String>() {
      int current = words.length - 1;

      @Override
      public boolean hasNext() {
        return current > -1;
      }

      @Override
      public String next() {
        return words[current--];
      }
    };
  }

  private Iterable<String> randomized() {
    return () -> {
      List<String> shuffled = new ArrayList<>(Arrays.asList(words));
      Collections.shuffle(shuffled, new Random(System.currentTimeMillis()));
      return shuffled.iterator();
    };
  }
}
