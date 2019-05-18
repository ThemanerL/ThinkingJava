package thinkingjava.exception;

/**
 * @author 李重辰
 * @date 2018/11/24 12:00
 */
public class InheritingException {
  public static void main(String[] args) {
    InheritingException sed = new InheritingException();
    try {
      sed.f();
    } catch (SimpleException e) {
      System.out.println("Caught it!");
    }
  }

  public void f() throws SimpleException {
    System.out.println("InheritingException.f");
    throw new SimpleException();
  }
}

class SimpleException extends Exception {

}