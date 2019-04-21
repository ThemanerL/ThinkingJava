package thinkingjava.polymorphism;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @author 李重辰
 * @date 2018/10/1 21:49
 */
public class Shapes {
  private static RandomShapeGenerator generator = RandomShapeGenerator.getInstance;

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

    System.out.println("________________");
    new Shapes().chapterElevenP31();
  }

  private void chapterElevenP31(){
    RandomShapeGenerator generator1 = new RandomShapeGenerator(8);
    for (Object s:generator1) {
      System.out.print(s.getClass().getSimpleName() + " ");
    }
  }
}

/**
 * 2018/11/21 修改,增加适配Iterable,支持生成多个对象
 */
class RandomShapeGenerator implements Iterable {
  private Random rand = new Random(System.currentTimeMillis());
  private int count = 0;
  private Set<Shape> shapes = null;
  static RandomShapeGenerator getInstance = new RandomShapeGenerator();

  private RandomShapeGenerator() {
  }

  RandomShapeGenerator(int count) {
    this.count = count;
    shapes = getShapes();
  }

  private Set<Shape> getShapes(){
    Set<Shape> set = new HashSet<>();
    for (int i = 0; i < count; i++) {
      set.add(next());
    }
    return set;
  }

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

  @Override
  public Iterator<Shape> iterator() {
    return new Iterator<Shape>() {
      int index = 0;
      @Override
      public boolean hasNext() {
        return index < count;
      }

      @Override
      public Shape next() {
        return (Shape)shapes.toArray()[index++];
      }
    };
  }
}
