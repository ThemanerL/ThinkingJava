package thinkingjava.interfaces.practice;

/**
 * out: 0
 * 1
 * 在父类构造器调用print的时候（这时候其实已经传递了类型信息，所以会自己去找子类对象），i的值还没有被初始化。所以输出0
 * 在调用子类的print时，i的值已经被初始化为1，所以输出1
 *
 * @author 李重辰
 * @date 2018/10/9 15:07
 */
public class P2 {
  public static void main(String[] args) {
    Child child = new Child();
    child.print();
  }
}

abstract class AbstractFather {
  /**
   * 第九章第二个练习题
   */
  abstract void print();

  AbstractFather() {
    print();
  }
}

class Child extends AbstractFather {
  int i = 1;

  @Override
  void print() {
    System.out.println(i);
  }
}