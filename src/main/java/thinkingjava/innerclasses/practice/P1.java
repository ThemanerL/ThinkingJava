package thinkingjava.innerclasses.practice;

/**
 * @author 李重辰
 * @date 2018/10/20 12:20
 */
public class P1 {
  public static void main(String[] args) {
    Outer outer = new Outer();
    Outer.Inner inner = outer.getInner();
  }
}

class Outer {
  Inner getInner() {
    return new Inner();
  }

  class Inner {

  }
}
