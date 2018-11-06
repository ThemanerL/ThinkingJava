package thinkingjava.chapter11;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 因为这个类只使用了Collection方法，因此任何继承自Collection的类的对象的可以正常工作
 *
 * @author 李重辰
 * @date 2018/11/2 20:48
 */
public class SimpleCollection {
  public static void main(String[] args) {
    Collection<Integer> integerCollection = new ArrayList<Integer>();
    int j = 10;
    for (int i = 0; i < j; i++) {
      integerCollection.add(i);
    }
    for (Integer i : integerCollection) {
      System.out.println(i + ". ");
    }
  }
}
