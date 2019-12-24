package thinkingjava.net.mindview.util;

/**
 * @author 李重辰
 * @date 2019/12/24 17:24
 */
public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
  public final D fourth;

  public FourTuple(A first, B second, C third, D fourth) {
    super(first, second, third);
    this.fourth = fourth;
  }

  @Override
  public String toString() {
    return "{\"FourTuple\":{" +
        "\"first\":" + first +
        ", \"second\":" + second +
        ", \"third\":" + third +
        ", \"fourth\":" + fourth +
        "}}";
  }
}
