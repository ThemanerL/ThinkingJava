package thinkingjava.chapter11.practice;

import java.util.HashMap;

/**
 * @author 李重辰
 * @date 2018/11/14 21:49
 */
public class P17 {
  public static void main(String[] args) {
    HashMap<String, Gerbil> gerbilHashMap = new HashMap<>(16);
    Gerbil gerbil =  new Gerbil(0);
    Gerbil gerbi2 =  new Gerbil(1);
    Gerbil gerbi3 =  new Gerbil(2);
    Gerbil gerbi4 =  new Gerbil(3);
    Gerbil gerbi5 =  new Gerbil(4);

    gerbilHashMap.put(gerbil.getClass().getSimpleName(), gerbil);
    gerbilHashMap.put(gerbi2.getClass().getSimpleName(), gerbi2);
    gerbilHashMap.put(gerbi3.getClass().getSimpleName(), gerbi3);
    gerbilHashMap.put(gerbi4.getClass().getSimpleName(), gerbi4);
    gerbilHashMap.put(gerbi5.getClass().getSimpleName(), gerbi5);

    for (String s : gerbilHashMap.keySet()) {
      System.out.println(s + ": " + gerbilHashMap.get(s));
    }
  }
}
