package thinkingjava.interfaces.practice;

/**
 * @author 李重辰
 * @date 2018/10/12 12:02
 */
public class P14 extends AbstractBirdService implements Bird {
  private void fly14(Flyable f) {
    f.highAltitudeFly();
    f.lowAltitudeFly();
  }

  private void run14(Runnable r) {
    r.walk();
    r.run();
  }

  private void eat14(Eatable e) {
    e.eat();
    e.drink();
  }

  private void bird14(Bird b) {
    b.takeOff();
  }

  public static void main(String[] args) {
    P14 p = new P14();
    p.bird14(p);
    p.eat14(p);
    p.fly14(p);
    p.run14(p);
  }
}


interface Flyable {
  /**
   * 低空飞行
   */
  void lowAltitudeFly();

  /**
   * 高空飞行
   */
  void highAltitudeFly();
}

interface Runnable {
  /**
   * 走
   */
  void walk();

  /**
   * 跑
   */
  void run();
}

interface Eatable {
  /**
   * 吃
   */
  void eat();

  /**
   * 喝
   */
  void drink();
}

interface Bird extends Runnable, Eatable, Flyable {
  /**
   * 起飞
   */
  void takeOff();
}

/**
 * 抽象类中不一定要有抽象方法，但是哪怕抽象类中的所有方法都已经实现了，抽象类依然不能被实例化
 */
abstract class AbstractBirdService implements Bird {
  @Override
  public void lowAltitudeFly() {
    System.out.println("Flyable.lowAltitudeFly");
  }

  @Override
  public void highAltitudeFly() {
    System.out.println("Flyable.lowAltitudeFly");
  }

  @Override
  public void walk() {
    System.out.println("Runnable.walk");
  }

  @Override
  public void run() {
    System.out.println("Runnable.run");
  }

  @Override
  public void eat() {
    System.out.println("Eatable.eat");
  }

  @Override
  public void drink() {
    System.out.println("Eatable.drink");
  }

  @Override
  public void takeOff() {
    System.out.println("Bird.takeOff");
  }

}