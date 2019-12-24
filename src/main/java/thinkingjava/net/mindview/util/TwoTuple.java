package thinkingjava.net.mindview.util;

/**
 * 2维元祖
 * 一个持有想要返回的多个对象，被称为元祖。元祖是将一组对象直接打包存储于其中的一个单一对象。
 * 这个容器对象允许赌气其中元素，但是不允许向其中存放新的对象。
 *
 * @author 李重辰
 * @date 2019/12/24 16:59
 */
public class TwoTuple<A, B> {
  public final A first;
  public final B second;

  public TwoTuple(A first, B second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public String toString() {
    return "{\"TowTuple\":{" +
        "\"first\":" + first +
        ", \"second\":" + second +
        "}}";
  }
}
