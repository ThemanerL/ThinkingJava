package thinkingjava.innerclasses.practice;

interface InterfaceEleven {
  /**
   * 输出方法名字
   */
  void print();
}

/**
 * @author 李重辰
 * @date 2018/10/22 21:38
 */
class P11 {
  InterfaceEleven getInstance() {
    return new Inner();
  }

  private class Inner implements InterfaceEleven {
    @Override
    public void print() {
      System.out.println("Inner.print");
    }
  }
}

class PracticeEleven {
  public static void main(String[] args) {
    P11 p11 = new P11();
    //通过尝试向下转型，说明此内部类被完全隐藏了。
    //InterfaceEleven inner = (Inner)p11.getInstance().print();
  }
}