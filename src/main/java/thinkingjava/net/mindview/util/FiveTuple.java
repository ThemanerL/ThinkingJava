package thinkingjava.net.mindview.util;

/**
 * @author 李重辰
 * @date 2019/12/24 17:31
 */
public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
  public final E fifth;

  @Override
  public String toString() {
    return "{\"FiveTuple\":{" +
        "\"first\":" + first +
        ", \"second\":" + second +
        ", \"third\":" + third +
        ", \"fourth\":" + fourth +
        ", \"fifth\":" + fifth +
        "}}";
  }

  public FiveTuple(A first, B second, C third, D fourth, E fifth) {
    super(first, second, third, fourth);
    this.fifth = fifth;
  }
}
