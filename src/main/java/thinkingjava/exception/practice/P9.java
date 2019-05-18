package thinkingjava.exception.practice;

/**
 * @author 李重辰
 * @date 2018/11/29 20:38
 */
public class P9 {
  public static void main(String[] args) {
    P9 p9 = new P9();
    try {
      p9.f();
    } catch (ExBaseException e) {
      System.out.println("Catch、ExBaseException：" + e);
    } catch (Exception e) {
      System.out.println("Catch、Exception：" + e);
    }
  }

  private void f() throws E1, E2, E3 {
    throw new E1();

  }

}

class ExBaseException extends Exception {
}

class E1 extends ExBaseException {
}

class E2 extends ExBaseException {
}

class E3 extends ExBaseException {
}