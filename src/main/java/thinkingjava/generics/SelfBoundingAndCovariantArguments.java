package thinkingjava.generics;

/**
 * 与@GenericsAndReturnTypes对照着看
 * 在使用自限定类型时，在导出类中只有一个方法，并且这个方法接受导出类型而不是基类型作为参数；
 * <p>
 * 编译器将不能识别将基类型当做参数传递给
 *
 * @author 李重辰
 * @date 2020/6/23 22:38
 */
public class SelfBoundingAndCovariantArguments {
  void test(Setter s1, Setter s2, SelfBoundSetter sbs) {
    s1.set(s2);
    /// error
//    s1.set(sbs);
  }
}

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
  void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {
}