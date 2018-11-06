package thinkingjava.chapter11;
import java.util.ArrayList;

/**
 * 这是一个没有加泛型信息的错误示例
 *
 * @author 李重辰
 * @date 2018/11/2 18:18
 */
public class ApplesOrange {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    ArrayList apples = new ArrayList();
    int j = 3;
    for (int i = 0; i < j; i++) {
      apples.add(new Apple());
    }
    apples.add(new Orange());
    for (Object a : apples) {
      System.out.println(((Apple) a).id());
    }
  }
}

class AppleGenerics {
  public static void main(String[] args) {
    ArrayList<Apple> apples = new ArrayList<Apple>();
    int j = 3;
    for (int i = 0; i < j; i++) {
      apples.add(new Apple());
    }
    for (Object a : apples) {
      System.out.println(((Apple) a).id());
    }
  }
}

class Apple {
  private static long counter;
  private final long id = counter++;

  long id() {
    return id;
  }
}

class Orange {
}
