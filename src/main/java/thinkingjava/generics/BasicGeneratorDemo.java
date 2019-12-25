package thinkingjava.generics;

import thinkingjava.net.mindview.util.Generator;

/**
 * @author 李重辰
 * @date 2019/12/25 19:48
 */
public class BasicGeneratorDemo {
  public static void main(String[] args) {
    Generator<CountedObject> generator = BaseGenerator.create(CountedObject.class);
    for (int i = 0; i < 5; i++) {
      System.out.println(generator.next());
    }

    Generator<CountedObject> generator1 = new BaseGenerator<>(CountedObject.class);
    for (int i = 0; i < 5; i++) {
      System.out.println(generator1.next());
    }
  }
}
