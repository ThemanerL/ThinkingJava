package thinkingjava.generics;

import org.jetbrains.annotations.NotNull;

/**
 * @author 李重辰
 * @date 2020/1/10 17:21
 */
public class ComparablePet implements Comparable<ComparablePet> {
  @Override
  public int compareTo(@NotNull ComparablePet o) {
    return 0;
  }
}
/// 一旦Comparable确定了ComparablePet参数，那么其他任何实现类都不能与ComparablePet之外的任何对象进行比较
//class Cat extends ComparablePet implements Comparable<Cat> {
//  @Override
//  public int compareTo(@NotNull Cat o) {
//    return 0;
//  }
//}
