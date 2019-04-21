package thinkingjava.exception;

/**
 * @author 李重辰
 * @date 2018/11/29 21:32
 */
public class WhoCalled {
  static void f() {
    try {
      throw new Exception();
    } catch (Exception e) {
      for (StackTraceElement s:e.getStackTrace()) {
        System.out.println(s.getMethodName());
      }
    }
  }

  static void g(){
    f();
  }

  static void h(){
    g();
  }

  public static void main(String[] args) {
    f();
    System.out.println("-------------------");
    g();
    System.out.println("-------------------");
  }
}
