package thinkingjava.interfaces;

interface I1 {
  /**
   * 接口内的方法必须要有javadoc声明
   */
  void f();
}

interface I2 {
  /**
   * 接口内的方法必须要有javadoc声明
   *
   * @param i int参数
   * @return 返回int型
   */
  int f(int i);
}

interface I3 {
  /**
   * 接口内的方法必须要有javadoc声明
   *
   * @return 返回int
   */
  int f();
}

/**
 * 重载方法仅通过返回类型是区分不开的。在打算组合的不同接口中使用相同的方法名通常会引起代码可读性的混乱，要尽量避免
 *
 * @author 李重辰
 * @date 2018/10/12 12:34
 */
public class InterfaceCollision {
}

class C1 {
  public int f() {
    return 1;
  }
}

class C2 implements I1, I2 {
  @Override
  public void f() {

  }

  @Override
  public int f(int i) {
    return 1;
  }
}

class C3 extends C1 implements I2 {
  @Override
  public int f(int i) {
    return 1;
  }
}

class C4 extends C1 implements I3 {
  @Override
  public int f() {
    return 1;
  }
}

///**
// * 重载方法仅通过返回类型是区分不开的。
// * 在打算组合的不同接口中使用相同的方法名通常会引起代码可读性的混乱，要尽量避免
// */
//class C5 extends C1 implements I1{
//    public void f() {
//
//    }
//
//    @Override
//    public int f() {
//
//    }
//}
//
//interface I4 extends I1,I3{
//
//}