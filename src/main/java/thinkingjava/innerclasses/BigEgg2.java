package thinkingjava.innerclasses;

/**
 * 外围类继承外围类，内部类继承内部类
 *
 * @author 李重辰
 * @date 2018/11/2 14:55
 */
public class BigEgg2 extends Egg2 {
  public BigEgg2() {
    insertYolk(new Yolk());
  }

  public static void main(String[] args) {
    Egg2 egg2 = new BigEgg2();
    egg2.g();
  }

  public class Yolk extends Egg2.Yolk {
    public Yolk() {
      System.out.println("BigEgg2.Yolk");
    }

    @Override
    public void f() {
      System.out.println("BigEgg2.Yolk.f");
    }
  }

}

class Egg2 {
  private Yolk y = new Yolk();

  public Egg2() {
    System.out.println("new Egg2()");
  }

  public void insertYolk(Yolk y) {
    this.y = y;
  }

  public void g() {
    y.f();
  }

  public class Yolk {
    public Yolk() {
      System.out.println("BigEgg2.Yolk");
    }

    public void f() {
      System.out.println("BigEgg2.Yolk.f");
    }
  }
}