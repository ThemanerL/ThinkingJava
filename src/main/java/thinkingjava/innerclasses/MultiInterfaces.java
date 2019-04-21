package thinkingjava.innerclasses;

/**
 * @author 李重辰
 * @date 2018/10/31 19:52
 */
public class MultiInterfaces {
  static void takesA(InterfaceA a) {
  }

  static void takesB(InterfaceB b) {
  }

  public static void main(String[] args) {
    ClassX x = new ClassX();
    ClassY y = new ClassY();
    takesA(x);
    takesA(y);
    takesB(x);
    takesB(y.makeB());
  }
}

interface InterfaceA {
}

interface InterfaceB {
}

class ClassX implements InterfaceA, InterfaceB {
}

class ClassY implements InterfaceA {
  InterfaceB makeB() {
    //匿名内部类
    return new InterfaceB() {
    };
  }
}
