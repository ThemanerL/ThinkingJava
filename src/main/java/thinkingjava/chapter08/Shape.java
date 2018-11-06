package thinkingjava.chapter08;

/**
 * @author 李重辰
 * @date 2018/10/1 21:37
 */
public class Shape {
  public void draw() {
  }

  public void erase() {
  }

  public void printName() {
    System.out.println("这个类被" + this.getClass().getSimpleName() + "继承了");
  }
}

class Circle extends Shape {
  @Override
  public void draw() {
    System.out.println("Circle.draw");
  }

  @Override
  public void erase() {
    System.out.println("Circle.erase");
  }

  public void wheels() {
    System.out.println("Circle.wheels");
  }
}

class Square extends Shape {

  @Override
  public void draw() {
    System.out.println("Square.draw");
  }

  @Override
  public void erase() {
    System.out.println("Square.erase");
  }
}

class Triangle extends Shape {
  @Override
  public void draw() {
    System.out.println("Triangle.draw");
  }

  @Override
  public void erase() {
    System.out.println("Triangle.erase");
  }

}