package thinkingjava.interfaces;

/**
 * 注意，CanFight接口与ActionCharacter类中的fight()方法的特征签名是一样的，而且，在Hero中并没有提供fight()的定义。可以扩展
 * 接口，但是得到的只是另一个接口。当想要创建时，所有的定义必须都存在。即使Hero没有显示地提供fight()的定义，其定义也因
 * ActionCharacter而来，这样就使得创建Hero对象成功了可能。
 * <p>
 * 如果要创建不带任何方法定义和成员变量的基类，那么就应该选择接口而不是抽象类。如果知道某事物应该成为一个基类，那么第一选择应该是使它成为一个接口。
 *
 * @author 李重辰
 * @date 2018/10/11 19:48
 */
public class Adventure {
  private static void t(CanFight x) {
    x.fight();
  }

  private static void u(CanSwim x) {
    x.swim();
  }

  private static void v(CanFly x) {
    x.fly();
  }

  private static void w(ActionCharacter x) {
    x.fight();
  }

  public static void main(String[] args) {
    Hero h = new Hero();
    t(h);
    u(h);
    v(h);
    w(h);
  }
}

interface CanFight extends CanClimb {
  /**
   * 打
   */
  void fight();
}

interface CanSwim {
  /**
   * 游
   */
  void swim();
}

interface CanFly extends CanFight, CanSwim {
  /**
   * 飞
   */
  void fly();
}

interface CanClimb {
  /**
   * 爬
   */
  void climb();
}

class ActionCharacter {
  public void fight() {
  }
}

class Hero extends ActionCharacter implements CanFly, CanFight, CanSwim, CanClimb {
  @Override
  public void swim() {

  }

  @Override
  public void fly() {

  }

  @Override
  public void climb() {

  }
}