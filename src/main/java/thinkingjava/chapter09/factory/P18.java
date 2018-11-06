package thinkingjava.chapter09.factory;

/**
 * @author 李重辰
 * @date 2018/10/18 18:18
 */
public class P18 {
  public static void main(String[] args) {
    System.out.println(new UnicycleFactory().getCycleInstance().getPerimeter());
    System.out.println(new BicycleFactory().getCycleInstance().getPerimeter());
    System.out.println(new TricycleFactory().getCycleInstance().getPerimeter());
  }
}

interface Cycle {
  /**
   * 获取perimeter的值
   *
   * @return 返回它的值
   */
  int getPerimeter();
}

class Unicycle implements Cycle {
  @Override
  public int getPerimeter() {
    return 1;
  }
}

class Bicycle implements Cycle {
  @Override
  public int getPerimeter() {
    return 2;
  }
}

class Tricycle implements Cycle {
  @Override
  public int getPerimeter() {
    return 3;
  }
}

interface Factory {
  /**
   * 创建Cycle实例
   *
   * @return Cycle
   */
  Cycle getCycleInstance();
}

class UnicycleFactory implements Factory {
  @Override
  public Cycle getCycleInstance() {
    return new Unicycle();
  }
}

class BicycleFactory implements Factory {
  @Override
  public Cycle getCycleInstance() {
    return new Bicycle();
  }
}

class TricycleFactory implements Factory {
  @Override
  public Cycle getCycleInstance() {
    return new Tricycle();
  }
}