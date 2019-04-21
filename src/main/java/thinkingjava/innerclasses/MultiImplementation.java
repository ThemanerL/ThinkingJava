package thinkingjava.innerclasses;

/**
 * @author 李重辰
 * @date 2018/10/31 19:59
 */
public class MultiImplementation {
  static private void takesD(ClassD d) {
  }

  static private void takesE(AbstractE e) {
  }

  public static void main(String[] args) {
    ClassZ z = new ClassZ();
    takesD(z);
    takesE(z.makeE());
  }
}

class ClassD {
}

abstract class AbstractE {
}

/**
 * 此处通过内部类实现了多重继承，既继承了D又继承了E
 */
class ClassZ extends ClassD {
  AbstractE makeE() {
    return new AbstractE() {
    };
  }
}
