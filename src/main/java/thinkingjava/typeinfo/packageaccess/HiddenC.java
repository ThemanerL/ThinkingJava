package thinkingjava.typeinfo.packageaccess;

import thinkingjava.typeinfo.interfacea.FaceA;

/**
 * 在当前包中唯一的public类只有hiddenC，在被调用时会产生A接口类型的对象。
 * 注意：即使你从makeA()返回的是C类型，你在包的外部仍然不能使用A以外的任何方法，因为你不能在包的外部命名C。
 *
 * @author 李重辰
 * @date 2019/12/20 19:29
 */
public class HiddenC {
  public static FaceA makeFaceA() {
    return new ClassC();
  }
}

class ClassC implements FaceA {
  @Override
  public void f() {
    System.out.println("public ClassC.f");
  }

  public void g() {
    System.out.println("public ClassC.g");
  }

  void u() {
    System.out.println("package ClassC.u()");
  }

  protected void v() {
    System.out.println("protected ClassC.v");
  }

  private void w() {
    System.out.println("private ClassC.w");
  }
}