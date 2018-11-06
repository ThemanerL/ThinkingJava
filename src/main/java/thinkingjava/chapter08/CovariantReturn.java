package thinkingjava.chapter08;

/**
 * @author 李重辰
 * @date 2018/10/5 18:35
 */
public class CovariantReturn {
  public static void main(String[] args) {
    Mill m = new Mill();
    Grain g = new Grain();
    System.out.println(g);
    m = new WheatMill();
    g = m.process();
    System.out.println(g);
  }
}

class Grain {
  @Override
  public String toString() {
    return "Grain.instance initializer";
  }
}

class Wheat extends Grain {
  @Override
  public String toString() {
    return "Wheat.toString";
  }
}

class Mill {
  Grain process() {
    return new Grain();
  }
}

class WheatMill extends Mill {
  @Override
  Wheat process() {
    return new Wheat();
  }
}