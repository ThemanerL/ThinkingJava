package thinkingjava.typeinfo;

import thinkingjava.typeinfo.interfacea.FaceA;

/**
 * @author 李重辰
 * @date 2019/12/20 19:25
 */
public class InterfaceViolation {
  public static void main(String[] args) {
    FaceA a = new ClassB();
    a.f();
    System.out.println(a.getClass().getName());
    if (a instanceof ClassB) {
      ClassB b = (ClassB)a;
      b.g();
    }
  }
}

class ClassB implements FaceA {
  @Override
  public void f() {
    System.out.println("ClassB.f");
  }

  public void g() {
    System.out.println("ClassB.g");
  }
}
