package thinkingjava.chapter11.practice;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author 李重辰
 * @date 2018/11/11 19:07
 */
public class P14 {
  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    ListIterator<Integer> iterator = linkedList.listIterator();
    int length = 10;
    for (int i = 1; i < length; i++) {
      iterator.add(i);
      //插入完第偶数个元素后,游标向前移动一位.
      if(i%2==0){
        iterator.previous();
      }
    }
    for (int i :linkedList) {
      System.out.println(i);
    }
  }
}
