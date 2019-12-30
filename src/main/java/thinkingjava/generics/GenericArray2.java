package thinkingjava.generics;

/**
 * @author 李重辰
 * @date 2019/12/30 9:14
 */
public class GenericArray2<T> {
  private Object[] array;

  public GenericArray2(int size) {
    array = new Object[size];
  }

  public void put(int index, T item) {
    array[index] = item;
  }

  @SuppressWarnings("unchecked")
  public T get(int index) {
    return (T) array[index];
  }

  @SuppressWarnings("unchecked")
  public T[] rep() {
    return (T[]) array;
  }

  public static void main(String[] args) {
    GenericArray2<Integer> gai = new GenericArray2<>(10);
    for (int i = 0; i < gai.array.length; i++) {
      gai.put(i, i);
    }
    for (int i = 0; i < gai.array.length; i++) {
      System.out.println(gai.get(i) + " ");
    }
    System.out.println();
    try {
      // 将Object[] 转化为Integer[] 还是不行的。将Object转化为Integer是可以的。
      Integer[] ia = gai.rep();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
