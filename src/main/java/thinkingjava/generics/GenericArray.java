package thinkingjava.generics;

/**
 * @author 李重辰
 * @date 2019/12/27 20:10
 */
public class GenericArray<T> {
  private T[] array;

  public GenericArray(int size) {
    array = (T[]) new Object[size];
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
    GenericArray<Integer> gai = new GenericArray<>(10);
    /// 按这个方式处理出报异常 java.lang.ClassCastException 这是因为我们使用泛型声明的数组，在运行时其实是一个Object数组，Object是不能强转到Integer的
    // 根本原因还是类型的继承关系问题，Integer[] 并不是 Object[] 的子类。虽然，Integer 继承自 Object, 但 Integer[] 的直接父类是 Object。
    // 即所有数组类型的直接父类都是 Object，可以通过反射来验证。
//     Integer[] rep = gai.rep();
    Object[] rep = gai.rep();
  }
}
