package thinkingjava.exception.practice;

/**
 * @author 李重辰
 * @date 2018/11/29 16:42
 */
public class P1AndP2 {
  public static void main(String[] args) {
    try{
      String a = null;
      System.out.println(a.length());
      /// 练习1
      //throw new Exception("P1.1");
    }catch (Exception e){
      e.printStackTrace(System.out);
    }finally {
      System.out.println("This is finally");
    }
  }
}
