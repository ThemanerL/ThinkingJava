package thinkingjava.exception;

import java.util.logging.Logger;

/**
 * @author 李重辰
 * @date 2018/11/29 18:23
 */
public class ExtraFeatures {
  public static void f() throws MyTwoException {
    System.out.println("Throwing MyTwoException from f()");
    throw new MyTwoException();
  }

  public static void g() throws MyTwoException {
    System.out.println("Throwing MyTwoException from g()");
    throw new MyTwoException("Originated in g()");
  }

  public static void h() throws MyTwoException {
    System.out.println("Throwing MyTwoException from h()");
    throw new MyTwoException("Originated in h()", 47);
  }

  public static void main(String[] args) {
    try{
      f();
    }
    catch (MyTwoException e) {
      e.printStackTrace(System.out);
    }try {
      g();
    } catch(MyTwoException e) {
      e.printStackTrace(System.out);
    }
    try {
      h();
    } catch(MyTwoException e) {
      e.printStackTrace(System.out);
      System.out.println("e.val() = " + e.val());
    }
  }
}

class MyTwoException extends Exception{
  Logger logger = Logger.getLogger(MyTwoException.class.getName());
  private int x;

  public MyTwoException() {
    logger.severe(super.getMessage());
  }

  public MyTwoException(String message) {
    super(message);
    logger.severe(super.getMessage());

  }

  public MyTwoException(String message, int x) {
    super(message);
    logger.severe(super.getMessage());
    this.x = x;
  }

  public int val(){
    return x;
  }

  @Override
  public String getMessage(){
    return "Detail Message: " + x + " " + super.getMessage();
  }
}
