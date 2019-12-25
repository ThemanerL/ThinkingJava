package thinkingjava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李重辰
 * @date 2019/12/25 18:11
 */
public class GenericVarargs {
  @SuppressWarnings("unchecked")
  public static <T> List<T> makeList(T... args) {
    List<T> result = new ArrayList<>();
    for (T arg : args) {
      result.add(arg);
    }
    return result;
  }

  public static void main(String[] args) {
    List<String> ls = makeList("A");
    System.out.println(ls);
    ls = makeList("A", "B", "C");
    System.out.println(ls);
  }
}
