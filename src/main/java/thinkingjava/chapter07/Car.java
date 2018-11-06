package thinkingjava.chapter07;

/**
 * 继承意味着你在使用一个通用类，并为了某种特殊需求而将其特殊化。
 * 用一个“交通工具”对象来构成一部“车”是毫无意义的。因为车并不包含交通工具，它仅是一个交通工具（is-a）关系。
 * “is-a”（是一个）的关系是用继承来表达的，而“has-a”（有一个）的关系则用组合来表达。
 *
 * @author 李重辰
 * @date 2018/9/28 18:10
 */
public class Car {
  private final int wheelNum = 4;
  private Engine engine = new Engine();
  private Wheel[] wheel = new Wheel[wheelNum];
  private Door left = new Door(), right = new Door();

  private Car() {
    for (int i = 0; i < wheelNum; i++) {
      wheel[i] = new Wheel();
    }
  }

  public static void main(String[] args) {
    Car car = new Car();
    car.left.window.rollup();
    car.wheel[0].inflate(76);
    car.engine.service();
  }
}

class Engine {
  void start() {
  }

  void rev() {
  }

  void stop() {
  }

  void service() {
  }
}

class Wheel {
  void inflate(int psi) {
  }
}

class Window {
  void rollup() {
  }

  void rolldown() {
  }
}

class Door {
  Window window = new Window();

  void opem() {
  }

  void close() {
  }
}