package thinkingjava.interfaces;

interface Monster {
  /**
   * 威胁
   */
  void menace();
}

interface DangerousMonster extends Monster {
  /**
   * 毁灭
   */
  void destroy();
}

interface Lethal {
  /**
   * 致命、致死
   */
  void kill();
}

/**
 * 吸血鬼
 */
interface Vampire extends DangerousMonster, Lethal {
  /**
   * 吸血鬼在喝血啦
   */
  void drinkBlood();
}

/**
 * 2018/10/29 修改使用匿名类实现DangerousMonster和Vampire
 * <p>
 * 一般情况下，只可以将extends用于单一类，但是可以引用多个基类接口，就像所看到的，只需用逗号将接口名一一分隔开即可。
 *
 * @author 李重辰
 * @date 2018/10/12 11:39
 */
public class HorrorShow {
  static void u(Monster b) {
    b.menace();
  }

  static void v(DangerousMonster d) {
    d.menace();
    d.destroy();
  }

  static void w(Lethal l) {
    l.kill();
  }

  public static void main(String[] args) {
    DangerousMonster barney = new DragonZilla() {
      @Override
      public void menace() {
        System.out.println("HorrorShow.menace");
      }

      @Override
      public void destroy() {
        System.out.println("HorrorShow.destroy");
      }
    };
    u(barney);
    v(barney);
    Vampire vlad = new VeryBadVampire() {
      @Override
      public void menace() {
        System.out.println("HorrorShow.menace");
      }

      @Override
      public void destroy() {
        System.out.println("HorrorShow.destroy");
      }

      @Override
      public void kill() {
        System.out.println("HorrorShow.kill");
      }

      @Override
      public void drinkBlood() {
        System.out.println("HorrorShow.drinkBlood");
      }
    };
    u(vlad);
    u(vlad);
    u(vlad);
  }
}

/**
 * 叫吉拉的龙
 */
class DragonZilla implements DangerousMonster {

  @Override
  public void menace() {

  }

  @Override
  public void destroy() {

  }
}

class VeryBadVampire implements Vampire {
  @Override
  public void menace() {

  }

  @Override
  public void destroy() {

  }

  @Override
  public void kill() {

  }

  @Override
  public void drinkBlood() {

  }
}

