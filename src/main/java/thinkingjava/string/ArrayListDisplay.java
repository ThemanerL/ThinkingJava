package thinkingjava.string;

import thinkingjava.generics.coffee.Coffee;
import thinkingjava.generics.coffee.CoffeeGenerator;

import java.util.ArrayList;

/**
 * @author 李重辰
 * @date 2019/12/3 10:54Coffee.java
 */
public class ArrayListDisplay {

  public static void main(String[] args) {
    ArrayList<Coffee> coffees = new ArrayList<>();
    int loop = 10;
    for (Coffee c : new CoffeeGenerator(loop)) {
      coffees.add(c);
    }
    System.out.println(coffees);
  }

}
