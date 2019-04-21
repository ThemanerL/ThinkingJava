package thinkingjava.exception;

/**
 * @author 李重辰
 * @date 2018/11/29 20:30
 */
public class ExceptionMethods {
  public static void main(String[] args) {
    try{
      throw new ArrayIndexOutOfBoundsException();
    }catch (Exception e){
      System.out.println("Caught Exception");
      System.out.println("getMessage(): " + e.getMessage());
      System.out.println("getLocalizedMessage(): " + e.getLocalizedMessage());
      System.out.println("toString(): " + e);
      System.out.println("printStackTrace(): ");
      e.printStackTrace(System.out);
    }
  }
}
