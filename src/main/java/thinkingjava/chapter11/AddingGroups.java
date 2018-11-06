package thinkingjava.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author 李重辰
 * @date 2018/11/2 21:14
 */
public class AddingGroups {
  public static void main(String[] args) {
    Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    Integer[] moreInts = {6, 7, 8, 9, 10};
    collection.addAll(Arrays.asList(moreInts));
    //允许的速度明显更快，但是不能以这种方式构建集合
    Collections.addAll(collection, 11, 12, 13, 14, 15);
    Collections.addAll(collection, moreInts);
    System.out.println(collection);
  }
}
