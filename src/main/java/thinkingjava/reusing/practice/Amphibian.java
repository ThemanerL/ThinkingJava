package thinkingjava.reusing.practice;

/**
 * @author 李重辰
 * @date 2018/9/29 19:49
 */
public class Amphibian {
  protected void printName(Amphibian amphibian) {
    System.out.println("My name is ：" + amphibian.getClass().getSimpleName() + " from father");
  }
}

class Frog extends Amphibian {

  @Override
  public void printName(Amphibian amphibian) {
    System.out.println("My name is ：" + amphibian.getClass().getSimpleName() + " from child");
  }

  public static void main(String[] args) {
    Frog frog = new Frog();
    Amphibian a = new Amphibian();
    a.printName(frog);
  }
}