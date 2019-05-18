package thinkingjava.initialization;

/**
 * @author 李重辰
 * @date 2018/9/22
 */
public class Flower {
  private int petalCount = 0;
  private String s = "null";

  Flower(int petals) {
    petalCount = petals;
    System.out.println("Constructor w/ int arg only,petalCount= " + petalCount);
  }

  Flower(String ss) {
    System.out.println("Constructor w/ String arg only, s=" + ss);
    s = ss;
  }

  Flower(String s, int petals) {
    this(petals);
//        this(s);一次只能调用一个构造器
    this.s = s;
    System.out.println("String & int args");
  }

  Flower() {
    this("hi", 47);
    System.out.println("default constructor (no args)");
  }

  public static void main(String[] args) {
    Flower x = new Flower();
    x.print();
  }

  void print() {
    System.out.println("petalCount = " + petalCount + "s = " + s);
  }
}
