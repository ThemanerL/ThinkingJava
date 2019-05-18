package thinkingjava.innerclasses.practice;

interface Inner {
  /**
   * 练习12
   *
   * @param nameModified 一个String的名字
   */
  void moidfyName(String nameModified);

  /**
   * 返回年龄
   *
   * @return 年龄
   */
  String getAge();
}

/**
 * 2018/10/29修改，这次使用匿名内部类
 *
 * @author 李重辰
 * @date 2018/10/22 16:38
 */
public class P7 {
  private String name;

  public static void main(String[] args) {
    P7 p7 = new P7();
    p7.getInstance().moidfyName("李重辰");
    p7.getInstance().moidfyName("王大头");
    System.out.println(p7.getInstance().getAge());
  }

  private void printName() {
    System.out.println(name);
  }

  private Inner getInstance() {
    return new Inner() {
      private int age = 18;

      @Override
      public String getAge() {
        return Integer.toString(age);
      }

      @Override
      public void moidfyName(String nameModified) {
        P7.this.name = nameModified;
        printName();
      }
    };
  }
}