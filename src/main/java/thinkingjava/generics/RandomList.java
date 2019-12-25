package thinkingjava.generics;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author 李重辰
 * @date 2019/12/25 7:41
 */
public class RandomList<T> {
  private ArrayList<T> storage = new ArrayList<>();
  private Random random = new Random(System.currentTimeMillis());

  public void add(T item) {
    storage.add(item);
  }

  public T select() {
    return storage.get(random.nextInt(storage.size()));
  }
}
