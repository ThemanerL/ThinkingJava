package thinkingjava.generics;

/**
 * @author 李重辰
 * @date 2019/12/25 19:46
 */
public class CountedObject {
  private static long counter = 0;
  private final long id = counter++;

  public long id() {
    return id;
  }

  @Override
  public String toString() {
    return "{\"CountedObject\":{" +
        "\"id\":" + id +
        "}}";
  }
}
