package thinkingjava.reusing;

/**
 * 必须注意对基础类以及成员对象清楚方法的调用顺序（假如一个对象要以另一个为基础）
 * 首先完成与类有关的所有特殊工作（可能要求基础类元素仍然可见），然后调用基础类清除方法。
 * "@Override"注解可以防止你在不想重载时意外的进行了重载
 *
 * @author 李重辰
 * @date 2018/9/27 20:01
 */
public class CadSystem extends Shape {
  private final static int LINE_LENGTH = 10;
  private Circle circle;
  private Triangle triangle;
  private Line[] lines = new Line[LINE_LENGTH];

  CadSystem(int i) {
    super(i + 1);
    for (int j = 0; j < LINE_LENGTH; j++) {
      lines[j] = new Line(j, j * j);
    }
    circle = new Circle(1);
    triangle = new Triangle(1);
    System.out.println("Combined constructor");
  }

  public static void main(String[] args) {
    CadSystem x = new CadSystem(47);
    try {
      // Code and excepting handling...
    } finally {
      x.dispose();
    }
  }

  @Override
  void dispose() {
    System.out.println("CadSystem.dispose()");
    triangle.dispose();
    circle.dispose();
    for (int i = 0; i < lines.length; i++) {
      lines[i].dispose();
    }
    super.dispose();
  }
}

class Shape {
  Shape(int i) {
    System.out.println("Shape constructor");
  }

  void dispose() {
    System.out.println("Shape of dispose");
  }
}

class Circle extends Shape {
  Circle(int i) {
    super(i);
    System.out.println("Drawing a Circle");
  }

  @Override
  void dispose() {
    System.out.println("Erasing a Circle");
    super.dispose();
  }
}

class Triangle extends Shape {
  Triangle(int i) {
    super(i);
    System.out.println("Drawing a Triangle");
  }

  @Override
  void dispose() {
    System.out.println("Erasing a Triangle");
    super.dispose();
  }
}

class Line extends Shape {
  private int start, end;

  Line(int start, int end) {
    super(start);
    this.start = start;
    this.end = end;
    System.out.println("Drawing a Line: " + start + ", " + end);
  }

  @Override
  void dispose() {
    System.out.println("Erasing a Line: " + start + ", " + end);
    super.dispose();
  }
}