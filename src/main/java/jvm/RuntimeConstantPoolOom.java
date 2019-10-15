package jvm;

/**
 * String.intern()返回引用的测试
 *
 * @author 李重辰
 * @date 2019/10/10 22:42
 */
public class RuntimeConstantPoolOom {
  public static void main(String[] args) {
    String str1 = new StringBuilder("计算机").append("软件").toString();
    System.out.println(str1.intern()==str1);

    String str2 = new StringBuilder("ja").append("va").toString();
    System.out.println(str2.intern()==str2);
  }
}
