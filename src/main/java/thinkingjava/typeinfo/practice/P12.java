package thinkingjava.typeinfo.practice;

import thinkingjava.generics.coffee.Coffee;
import thinkingjava.generics.coffee.CoffeeGenerator;
import thinkingjava.net.mindview.util.TypeCounter;

/**
 * Use TypeCounter with the CoffeeGenerator.java class in the Generics chapter
 * 将TypeCounter与Generics章节中的CoffeeGenerator一起使用。
 *
 * @author 李重辰
 * @date 2019/12/21 14:18
 */
public class P12 {
  public static void main(String[] args) {
    CoffeeGenerator coffees = new CoffeeGenerator(12);
    TypeCounter counter = new TypeCounter(Coffee.class);
    // 只要实现了Iterator接口就可以使用foreach遍历
    for (Coffee c : coffees) {
      counter.count(c);
    }
    System.out.println(counter);
  }
}
