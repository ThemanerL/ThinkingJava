package thinkingjava.generics;

/**
 * @author 李重辰
 * @date 2020/6/23 22:07
 */
public class GenericsAndReturnTypes {
  void test(Getter getter) {
    Getter result = getter.get();
    GenericGetter genericGetter = getter.get();
  }

}

interface GenericGetter<T extends GenericGetter<T>> {
  T get();
}

interface Getter extends GenericGetter<Getter> {
}