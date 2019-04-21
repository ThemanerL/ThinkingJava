package thinkingjava.exception;

/**
 * 永远不必对清理前一个异常对象而担心，或者说为异常对象的清理而担心。他们都是用New在堆上创建的对象，所以垃圾回收器会来处理
 * @author 李重辰
 * @date 2018/12/3 22:12
 */
public class RethrowNew {
  public static void f() throws OneException{
    System.out.println("originating the exception in f()");
    throw new OneException("thrown from f()");
  }

  public static void main(String[] args) {
    try{
      try{
        f();
      }catch (OneException e){
        System.out.println("Caught in inner try, e.printStackTrace()");
        e.printStackTrace(System.out);
        throw new TwoException("from inner try");
      }
    }catch (TwoException e){
      System.out.println("Caught in outer try, e.printStackTrace()");
      e.printStackTrace(System.out);
    }
  }
}

class OneException extends Exception{
  OneException(String message){
    super(message);
  }
}

class TwoException extends Exception{
  TwoException(String message) {
    super(message);
  }
}