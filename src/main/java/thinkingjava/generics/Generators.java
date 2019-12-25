package thinkingjava.generics;

import thinkingjava.generics.coffee.Coffee;
import thinkingjava.generics.coffee.CoffeeGenerator;
import thinkingjava.net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 李重辰
 * @date 2019/12/25 19:02
 */
public class Generators {

  public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
    for (int i = 0; i < n; i++) {
      coll.add(gen.next());
    }
    return coll;
  }

  public static void main(String[] args) {
    Collection<Coffee> coffee = fill(new ArrayList<>(), new CoffeeGenerator(), 5);
    for (Coffee c : coffee) {
      System.out.println(c);
    }

    Collection<Integer> numbers = fill(new ArrayList<>(), new Fibonacci(), 4);
    for (int i : numbers) {
      System.out.println(i);
    }
  }
}
