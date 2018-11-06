package thinkingjava.chapter11;

import java.util.ArrayList;

/**
 * 可以将Apple的子类型添加到保存Apple对象的容器中
 *
 * @author 李重辰
 * @date 2018/11/2 20:13
 */
public class GenericsUpcasting {
  public static void main(String[] args) {
    ArrayList<Apple> apples = new ArrayList<>();
    apples.add(new GrannySmith());
    apples.add(new Fuji());
    apples.add(new Gala());
    apples.add(new Braeburn());
    for (Apple a : apples) {
      System.out.println(a);
    }
  }
}

class GrannySmith extends Apple {
}

class Gala extends Apple {
}

class Fuji extends Apple {
}

class Braeburn extends Apple {
}