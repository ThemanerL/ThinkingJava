package thinkingjava.innerclasses;

interface Destination {
  /**
   * 读取label的值
   *
   * @return String
   */
  String readLabel();
}

interface Contents {
  /**
   * 接口内方法必须注释
   *
   * @return int
   */
  int value();
}

/**
 * private内部类给类的设计者提供一种途径，通过这种方式可以完全阻止任何依赖于类型的编码，并且完全隐藏了实现的细节。
 * 从客户端程序员的角度来看，由于不能访问任何新增加的、原本不属于公共接口的方法，所以扩展接口是没有价值的。这给了
 * 编译器可以生成更高效的代码的机会
 *
 * @author 李重辰
 * @date 2018/10/22 12:20
 */
class Parcel4 {
  Destination destination(String s) {
    return new DestniationDimpl(s);
  }

  Contents contents() {
    return new ContentsDimpl();
  }

  /**
   * 该类市private，所以除了Parcel4，没有人能访问它。
   */
  private class ContentsDimpl implements Contents {
    private int i = 11;

    @Override
    public int value() {
      return i;
    }
  }

  /**
   * 这个类是protected的，所以只有Parcel4及其子类，以及同一个包中的类能访问它
   */
  protected class DestniationDimpl implements Destination {
    private String label;

    private DestniationDimpl(String whereTo) {
      label = whereTo;
    }

    @Override
    public String readLabel() {
      return label;
    }
  }
}

class TestParcel {
  public static void main(String[] args) {
    Parcel4 parcel4 = new Parcel4();
    Contents contents = parcel4.contents();
    Destination destination = parcel4.destination("Tasmania");
  }
}