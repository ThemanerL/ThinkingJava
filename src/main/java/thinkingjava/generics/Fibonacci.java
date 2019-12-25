package thinkingjava.generics;

import thinkingjava.net.mindview.util.Generator;

/**
 * @author 李重辰
 * @date 2019/12/25 7:54
 */
public class Fibonacci implements Generator<Integer> {
  private int count = 0;

  private int fib(int n) {
    if (n < 2) {
      return 1;
    }
    return fib(n - 2) + fib(n - 1);
  }

  @Override
  public Integer next() {
    return fib(count++);
  }

  public static void main(String[] args) {
    Fibonacci gen = new Fibonacci();
    for (int i = 0; i < 18; i++) {
      System.out.print(gen.next()+" ");
    }
  }
}
