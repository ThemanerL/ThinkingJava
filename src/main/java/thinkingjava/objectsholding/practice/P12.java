package thinkingjava.objectsholding.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 创建并组装一个List<Integer> 然后创建第二个具有相同尺寸的List<Integer>,并使用ListIterator读取第一个List中的元素,
 * 然后再将它们反序插入到第二个list中.
 *
 * @author 李重辰
 * @date 2018/11/10 21:18
 */
public class P12 {
  public static void main(String[] args) {
    int initIntegerListLength = 5;
    List<Integer> integerList = new ArrayList<>();
    for (int i = 0; i < initIntegerListLength; i++) {
      integerList.add(i);
    }

    List<Integer> integerList1 = new ArrayList<>();
    ListIterator<Integer> iterator = integerList.listIterator();
    ListIterator<Integer> iterator1 = integerList1.listIterator();
    // 先将游标指向iterator的末位
    while (iterator.hasNext()) {
      iterator.next();
    }
    while (iterator.hasPrevious()) {
      iterator1.add(iterator.previous());
    }
    for (int i1 : integerList1) {
      System.out.println(i1);
    }
  }
}
