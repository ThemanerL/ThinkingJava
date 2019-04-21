package thinkingjava.exception.practice;

/**
 * @author 李重辰
 * @date 2018/11/29 20:38
 */
public class P9 {
  private void f() throws E1, E2, E3{
    throw new E1();

  }

  public static void main(String[] args) {
    P9 p9 = new P9();
    try {
      p9.f();
    }catch (ExBase e){
      System.out.println("Catch、ExBase：" + e);
    }catch (Exception e){
      System.out.println("Catch、Exception：" + e);
    }
  }

}

class ExBase extends Exception{}

class E1 extends ExBase{}
class E2 extends ExBase{}
class E3 extends ExBase{}