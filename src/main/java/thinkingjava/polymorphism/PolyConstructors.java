package thinkingjava.polymorphism;

/**
 * Question:在一个构造器的内部调用正在构造的对象的某个动态绑定方法?
 * <p>
 * 初始化过程
 * 1)将分配给对象的存储空间初始化为二进制的0
 * 2)调用基类的构造器,调用被覆盖后的draw()方法,(要在调用RoundGlyph构造器之前),此时的radius的值为0
 * 3)按照声明的顺序调用成员的初始化方法
 * 4)调用导出类的构造器主体
 * <p>
 * 由此引申出编写构造器的原则:"用尽可能的方法使对象进入正常状态;尽量避免调用其他方法",
 * 在构造器中唯一能安全调用的是基类中的final方法(也适用于private方法,他们自动属于final方法),这些方法不能被覆盖所以是安全的
 *
 * @author 李重辰
 * @date 2018/10/5 12:54
 */
public class PolyConstructors {
  public static void main(String[] args) {
    new RoundGlyph(5);
  }
}

class Glyph {
  void draw() {
    System.out.println("Glyph.draw");
  }

  public Glyph() {
    System.out.println("Before Glyph.draw");
    draw();
    System.out.println("After Glyph.draw");
  }
}

class RoundGlyph extends Glyph {
  private int radius = 1;

  RoundGlyph(int r) {
    radius = r;
    System.out.println("RoundGlyph.RoundGlyph.radius = " + radius);
  }

  @Override
  void draw() {
    System.out.println("RoundGlyph.draw.radius = " + radius);
  }
}