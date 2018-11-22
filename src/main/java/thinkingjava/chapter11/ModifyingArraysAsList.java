package thinkingjava.chapter11;

import java.util.*;

/**
 * List<Integer> list = new ArrayList<>(Arrays.asList(ia));
 * 与
 * List<Integer> list1 = Arrays.asList(ia);
 * 这两种方式创建的ArrayList不一样。
 * 第一种情况下，Arrays.asList()的输出被传递给了ArrayList的构造器，这将创建一个引用ia元
 * 素的ArrayList，因此打乱这些引用不会修改数组。
 * 但是。如果直接使用Arrays.asList(ia)的结果，这种打乱就会操作到数组本身。
 * Arrays.asList产生的List对象会使用底层数组作为物理实现，只要你执行的操作会修改这个List，并且你不想原来的数组被修改，
 * 那么你就应该在另一个容器中创建一个副本
 *
 * @author 李重辰
 * @date 2018/11/22 15:28
 */
public class ModifyingArraysAsList {

  public static void main(String[] args) {
    Random rand = new Random(System.currentTimeMillis());
    Integer[] ia = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    List<Integer> list = new ArrayList<>(Arrays.asList(ia));
    System.out.println("Before: " + list);
    Collections.shuffle(list);
    System.out.println("After: " + list);
    System.out.println("Array: " + Arrays.toString(ia));
    System.out.println();

    List<Integer> list1 = Arrays.asList(ia);
    System.out.println("Before shuffling: " + list1);
    Collections.shuffle(list1);
    System.out.println("After: " + list1);
    System.out.println("Array: " + Arrays.toString(ia));
  }
}
