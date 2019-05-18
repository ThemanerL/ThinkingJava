package thinkingjava.reusing;

/**
 * 注释序号为代码执行顺序
 *
 * @author 李重辰
 * @date 2018/9/30 16:38
 */
public class Beetle extends Insect {
  /**
   * 3
   */
  private static int x2 = printInit("Static Beetle.x2 initialized");
  /**
   * 9
   */
  private int k = printInit("Beetle.k initialized");

  /**
   * 10
   */
  public Beetle() {
    System.out.println("k = " + k);
    System.out.println("j = " + j);
  }

  public static void main(String[] args) {
    // 4
    System.out.println("Beetle constructor");

    // 11           5
    Beetle b = new Beetle();

    // 第一个实体的创建或者对static成员的访问都有可能引起加载
    Insect.printInit("asd");

  }
}

class Insect {

  /**
   * 1
   */
  private static int x1 = printInit("Static Insect.x1 initialized");
  /**
   * 7
   */
  int j;
  /**
   * 6
   */
  private int i = 9;

  /**
   * 8
   */
  Insect() {
    System.out.println("i = " + i + " , j = " + j);
    j = 39;
  }

  /**
   * 2 加载
   */
  static int printInit(String s) {
    System.out.println(s);
    return 47;
  }
}
