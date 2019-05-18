package thinkingjava.exception;

/**
 * printStackTrace()方法显示的将是原来异常抛出点的调用栈信息，而并非重新抛出点的信息。要想更新这个信息，可以调用
 * fillStackTrace()方法，这将返回一个Throwable对象，它是通过把当前调用栈信息填入原来那个异常对象而建立的。
 *
 * @author 李重辰
 * @date 2018/12/3 20:56
 */
public class Rethrowing {
  public static void f() throws Exception {
    System.out.println("originating the exception in f()");
    throw new Exception("Throw from f()");
  }

  public static void g() throws Exception {
    try {
      f();
    } catch (Exception e) {
      System.out.println("Inside g(), e.printStackTrace()");
      e.printStackTrace(System.out);
      throw e;
    }
  }

  public static void h() throws Exception {
    try {
      f();
    } catch (Exception e) {
      System.out.println("Inside h(), e.printStackTrace()");
      e.printStackTrace(System.out);
      throw (Exception) e.fillInStackTrace();
    }
  }

  public static void main(String[] args) {
    try {
      g();
    } catch (Exception e) {
      System.out.println("main: printStackTrace()");
      e.printStackTrace(System.out);
    }
    System.out.println("-------------------------------------");
    try {
      h();
    } catch (Exception e) {
      System.out.println("main: printStackTrace()");
      e.printStackTrace(System.out);
    }
  }
}
