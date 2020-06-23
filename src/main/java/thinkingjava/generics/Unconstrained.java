package thinkingjava.generics;

/**
 * @author 李重辰
 * @date 2020/6/22 20:21
 */
public class Unconstrained {
  public static void main(String[] args) {
    BasicOther b = new BasicOther();
    BasicOther b2 = new BasicOther();
    b.set(new Other());
    Other other = b.get();
    b.f();
  }
}

class Other {
}

class BasicOther extends BasicHolder<Other> {
}