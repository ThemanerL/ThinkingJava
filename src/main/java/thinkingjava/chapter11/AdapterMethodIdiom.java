package thinkingjava.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author 李重辰
 * @date 2018/11/21 17:55
 */
public class AdapterMethodIdiom {
  public static void main(String[] args) {
    ReversibleArrayList<String> strings = new ReversibleArrayList<>(Arrays.asList(("To be or not to be").split(" ")));
    for (String s : strings) {
      System.out.println(s + " ");
    }
    System.out.println();
    for (String s : strings.reversed()) {
      System.out.println(s + " ");
    }
  }
}

class ReversibleArrayList<T> extends ArrayList<T> {
  public ReversibleArrayList(Collection<? extends T> c) {
    super(c);
  }

  public Iterable<T> reversed() {
    return () -> new Iterator<T>() {
      int current = size() - 1;

      @Override
      public boolean hasNext() {
        return current > -1;
      }

      @Override
      public T next() {
        return get(current--);
      }
    };
  }
}