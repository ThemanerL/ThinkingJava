package thinkingjava.chapter08;

import java.util.Random;

/**
 * @author 李重辰
 * @date 2018/10/1 21:49
 */
public class Shapes {
  private static RandomShapeGenerator generator = new RandomShapeGenerator();

  public static void main(String[] args) {
    Shape[] s = new Shape[9];
    Shape s1 = new Triangle();
    for (int i = 0; i < s.length; i++) {
      s[i] = generator.next();
    }
    for (Shape shp : s) {
      shp.draw();
      shp.printName();
    }
  }
}

class RandomShapeGenerator {
  private Random rand = new Random(System.currentTimeMillis());

  Shape next() {
    switch (rand.nextInt(3)) {
      case 0:
        return new Circle();
      case 1:
        return new Square();
      case 2:
        return new Triangle();
      default:
        return null;
    }
  }
}
