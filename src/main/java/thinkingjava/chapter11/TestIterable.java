package thinkingjava.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author 李重辰
 * @date 2018/11/21 23:01
 */
public class TestIterable {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>( );
    for (int i = 0; i < 5; i++) {
      list.add(i);
    }
    Iterator<Integer> it = list.iterator();
    Iterator<Integer> it1 = list.iterator();
    while (it.hasNext()){
      it.next();
      it.remove();
    }
    while (it1.hasNext()){
      System.out.println(it.next());
    }
    for (int i = 0; i < 5; i++) {
      list.add(i);
    }
    for (int i = 4; 0 == i; i--) {
      list.remove(i);
    }
    System.out.println();
  }
}
