package thinkingjava.generics;

import java.lang.reflect.Array;

/**
 * 当我们把类型标记Class<T>传递到构造器中，我们就可以创建需要的实际类型的数组。
 *
 * @author 李重辰
 * @date 2019/12/30 10:43
 */
public class GenericArrayWithTypeToken<T> {
  private T[] array;

  @SuppressWarnings("unchecked")
  public GenericArrayWithTypeToken(Class<T> type, int size) {
    array = (T[]) Array.newInstance(type, size);
  }

  public void put(int index, T item) {
    array[index] = item;
  }

  public T get(int index) {
    return array[index];
  }

  public T[] rep() {
    return array;
  }

  public static void main(String[] args) {
    GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 20);
    Integer[] integers = gai.rep();
  }
}
