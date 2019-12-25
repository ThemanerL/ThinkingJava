package thinkingjava.generics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * @author 李重辰
 * @date 2019/12/25 11:23
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
  private int n;

  public IterableFibonacci(int n) {
    this.n = n;
  }

  @NotNull
  @Override
  public Iterator<Integer> iterator() {
    return new Iterator<Integer>() {
      @Override
      public boolean hasNext() {
        return n > 0;
      }

      @Override
      public Integer next() {
        n--;
        return IterableFibonacci.this.next();
      }
    };
  }

  public static void main(String[] args) {
    for (int i: new IterableFibonacci(18)) {
      System.out.println(i);
    }
  }
}
