package thinkingjava.objectsholding.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author 李重辰
 * @date 2018/11/14 21:49
 */
public class P17 {
  public static void main(String[] args) {
    HashMap<String, Gerbil> gerbilHashMap = new HashMap<>(16);
    Gerbil gerbi0 =  new Gerbil(0);
    Gerbil gerbi1 =  new Gerbil(1);
    Gerbil gerbi2 =  new Gerbil(2);
    Gerbil gerbi3 =  new Gerbil(3);
    Gerbil gerbi4 =  new Gerbil(4);

    gerbilHashMap.put("gerbi0", gerbi0);
    gerbilHashMap.put("gerbi1", gerbi1);
    gerbilHashMap.put("gerbi2", gerbi2);
    gerbilHashMap.put("gerbi3", gerbi3);
    gerbilHashMap.put("gerbi4", gerbi4);
    for (String s : gerbilHashMap.keySet()) {
      Gerbil gerbi = gerbilHashMap.get(s);
      System.out.println(s + ": " + gerbi);
      gerbi.hop();
    }
    System.out.println();

    LinkedHashMap<String, Gerbil> linkedHashMap = new LinkedHashMap<>();
    String[] sortKey =gerbilHashMap.keySet().toArray(new String[0]);
    Arrays.sort(sortKey);
    for (String obj:sortKey) {
      linkedHashMap.put(obj, gerbilHashMap.get(obj));
    }

    for (String e:linkedHashMap.keySet()) {
      System.out.println(e +  ": " + linkedHashMap.get(e));
    }
  }
}
