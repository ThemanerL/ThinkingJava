package thinkingjava.typeinfo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author 李重辰
 * @date 2019/12/14 10:49
 */
public class Shapes {
  public static void main(String[] args) throws ClassNotFoundException {
    List<AbstractShape> shapeList = Arrays.asList(
        new Circle(), new Square(), new Triangle()
    );
    for (AbstractShape shape : shapeList) {
      shape.draw();
      rotate(shape);
    }
    // 运行时类型信息，可以使得在程序运行时发现和使用类型信息。编译阶段他们只是Shape来说，他只是一个AbstractShape的一个对象。
    // 在运行时，所有的类型转化会可进行正确性检查。这也是RTTI名字的含义，在运行时，识别一个对象的类型。
    AbstractShape shape = new Rhomboid();
    Circle circle = (Circle) shape;
    circle.draw();
    /// practice 8
    System.out.println("递归打印类的继承体系中的所有类");
    Shapes.printClass(Class.forName("thinkingjava.typeinfo.Rhomboid"));
  }

  private static void rotate(AbstractShape shape) {
    String simpleName = shape.getClass().getSimpleName();
    String canonicalName = shape.getClass().getCanonicalName();
    System.out.println("canonicalName: " + canonicalName);
    if (!(shape instanceof Circle)) {
      System.out.println(simpleName + " Rotate success!");
    }
  }

  private static void printClass(Class<?> object) {
    if (object == null) {
      return;
    }
    /// practice 9
    Field[] declaredFields = object.getDeclaredFields();
    for (Field f : declaredFields) {
      System.out.println(f.getName());
    }
    System.out.println();
    System.out.println(object.getName());
    for (Class<?> k : object.getInterfaces()) {
      System.out.println("InterFace: " + k.getName());
      printClass(k.getSuperclass());
    }
    printClass(object.getSuperclass());
  }
}

abstract class AbstractShape implements Observer {
  void draw() {
    System.out.println(this + ".draw()");
  }

  /**
   * 强制子类重写
   */
  @Override
  abstract public String toString();

  @Override
  public void update(Observable o, Object arg) {

  }
}

class Circle extends AbstractShape {

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}

class Square extends AbstractShape {
  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}

class Triangle extends AbstractShape {
  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}

class Rhomboid extends AbstractShape implements Runnable, Serializable {

  static final long serialVersionUID = 43L;

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }

  @Override
  public void run() {

  }
}
