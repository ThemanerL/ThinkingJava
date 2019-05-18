package thinkingjava.innerclasses;

/**
 * 如果你想要创建某些公共代码，使得他们可以被某个接口的所有不同实现所共用。使用接口内部的嵌套类会很方便。
 * <p>
 * 嵌套类可以作为接口的一部分，你放到接口中的任何类都自动的是public和static的。因为类是static的。
 * 只是将类置于接口的命名空间内，这并不违反接口的规则。也可以在内部类中实现外围接口
 *
 * @author 李重辰
 * @date 2018/10/30 21:19
 */
public interface ClassInterface {
  /**
   * 接口中的方法必须使用javadoc注释
   */
  void howdy();

  class Test implements ClassInterface {
    public static void main(String[] args) {
      new Test().howdy();
    }

    /**
     * Practice21
     *
     * @param classInterface 一个ClassInterface实例
     */
    static void printHowdy(ClassInterface classInterface) {
      classInterface.howdy();
    }

    @Override
    public void howdy() {
      System.out.println("Test.howdy");
    }
  }
}

class Practice20 implements ClassInterface {
  public static void main(String[] args) {
    ClassInterface classInterface = new Test();
    classInterface.howdy();
    Test.printHowdy(classInterface);
  }

  @Override
  public void howdy() {
    System.out.println("Practice20.howdy");
  }
}
