package thinkingjava.typeinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用泛型类语法，存储了一个类引用。
 *
 * @author 李重辰
 * @date 2019/12/15 17:56
 */
public class FilledList<T> {
  private Class<T> type;

  private FilledList(Class<T> type) {
    this.type = type;
  }

  public static void main(String[] args) {
    FilledList<CountedInteger> fl = new FilledList<>(CountedInteger.class);
    System.out.println(fl.create(15));
  }

  private List<T> create(int nElements) {
    List<T> result = new ArrayList<>();
    try {
      for (int i = 0; i < nElements; i++) {
        result.add(type.newInstance());
      }
    } catch (IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
    }
    return result;
  }
}

class CountedInteger {
  private static long counter;
  private final long id = counter++;

  @Override
  public String toString() {
    return Long.toString(id);
  }
}
