package thinkingjava.innerclasses.practice.p6.p2;

import thinkingjava.innerclasses.practice.p6.p1.InterfaceOne;

/**
 * @author 李重辰
 * @date 2018/10/22 14:45
 */
public class ClassSixTwo {
  public Inner getInstance() {
    return new Inner();
  }

  protected class Inner implements InterfaceOne {
    @Override
    public void printName() {
      System.out.println("Inner.printName");
    }
  }
}
