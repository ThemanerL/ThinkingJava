package thinkingjava.exception.practice;

import thinkingjava.exception.LoggingException2;

/**
 * @author 李重辰
 * @date 2018/11/29 16:55
 */
public class P3 {
  public static void main(String[] args) {
    // P4
    try {
      throw new MyException("测试带有字符串的构造器");
    } catch (Exception e) {
      e.printStackTrace();
      LoggingException2.logException(e);
    }
    // p5
    int[] ints = {6, 7, 8, 9, 10};
    int index = ints.length + 1;
    while (true) {
      try {
        System.out.println(ints[index--]);
      } catch (Exception e) {
        System.out.println(e);
        LoggingException2.logException(e);
        continue;
      }
      break;
    }
  }
}

class MyException extends Exception {
  public MyException(String message) {
    super(message);
    f(message);
  }

  void f(String message) {
    System.out.println(message + "__");
  }
}
