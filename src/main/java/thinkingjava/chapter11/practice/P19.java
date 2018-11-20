package thinkingjava.chapter11.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author 李重辰
 * @date 2018/11/19 10:55
 */
public class P19 {
  public static void main(String[] args) {
    HashSet<Gerbil> hashSet = new HashSet<>(Arrays.asList(new Gerbil(78), new Gerbil(3), new Gerbil(4), new Gerbil(7)));
    System.out.println(hashSet);
    for (Gerbil g:hashSet) {
      g.hop();
    }
    System.out.println("----------------");
    Gerbil[] strings = hashSet.toArray(new Gerbil[0]);
    Arrays.sort(strings);
    LinkedHashSet<Gerbil> linkedHashSet = new LinkedHashSet<>(Arrays.asList(strings));
    for (Gerbil g:linkedHashSet) {
      g.hop();
    }
  }
}
