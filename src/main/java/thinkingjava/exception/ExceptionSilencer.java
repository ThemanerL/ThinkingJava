package thinkingjava.exception;

/**
 * @author 李重辰
 * @date 2019/4/14 13:22
 */
public class ExceptionSilencer {
  public static void main(String[] args) {
    try {
      System.out.println(10 / 0);
    } finally {
      // Using ‘return’ inside the finally block
      // will silence any thrown exception.
      return;
    }
  }
}
