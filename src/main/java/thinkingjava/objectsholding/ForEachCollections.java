package thinkingjava.objectsholding;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author 李重辰
 * @date 2018/11/20 11:08
 */
public class ForEachCollections {
  public static void main(String[] args) {
    Collection<String> cs = new LinkedList<>();
    Collections.addAll(cs, "Take the long way home".split(" "));
    for (String s:cs){
      System.out.println("'" + s + "' ");
    }
  }
}
