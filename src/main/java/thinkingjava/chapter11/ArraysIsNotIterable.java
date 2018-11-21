package thinkingjava.chapter11;

import java.util.*;

/**
 * foreach 可以用于数组或其他任何Iterable,但是这并不意味着数组肯定也是一个Iterable,而任何自动包装也不会自动发生;
 * @author 李重辰
 * @date 2018/11/21 13:01
 */
public class ArraysIsNotIterable {
  private static <T> void test(Iterable<T> ib){
    for (T t:ib){
      System.out.println(t + " ");
    }
  }

  public static void main(String[] args) {
    test(Arrays.asList(1, 2, 3));
    String[] strings = {"A", "B", "C"};
    test(Arrays.asList(strings));
    List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    List<String> list2 = new ArrayList<>(Arrays.asList("a", "b", "c","d"));
    List<Dictionary> d = new ArrayList<>();
    for (Iterator<Integer> i = list1.iterator(); i.hasNext();){
      for (Iterator<String> j = list2.iterator(); j.hasNext();){
        d.add(new Dictionary(i.next(), j.next()));
      }
    }
    System.out.println(d);

  }
}
class Dictionary{
  private int index = 0;
  private String c = null;

  public Dictionary(int index, String c) {
    this.index = index;
    this.c = c;
  }

  @Override
  public String toString() {
    return "Dictionary{" +
        "index=" + index +
        ", c='" + c + '\'' +
        '}';
  }
}

