package thinkingjava.chapter11.practice;

import java.util.*;

/**
 * @author 李重辰
 * @date 2018/11/5 20:17
 */
public class P4 {
  public static void main(String[] args) {
    int stringLength = 8;
    for (String s:Generate.nameGenerator(new String[stringLength])) {
      System.out.println(s);
    }
    System.out.println(Generate.nameGenerator(new ArrayList<>()));
    System.out.println(Generate.nameGenerator(new LinkedList<>()));
    System.out.println(Generate.nameGenerator(new HashSet<>()));
    System.out.println(Generate.nameGenerator(new LinkedHashSet<>()));
    System.out.println(Generate.nameGenerator(new TreeSet<>()));
  }
}

class Generate {
  static private String[] originChar = {"My", "name", "is", "Li", "The", "Man", "er!"};
  static private int next = 0;

  static private String next() {
    String str = originChar[next];
    next = (next + 1) % originChar.length;
    return str;
  }

  static String[] nameGenerator(String[] strings){
    for (int i = 0; i < strings.length; i++) {
      strings[i] = next();
    }
    return strings;
  }

  static Collection nameGenerator(Collection<String> collection){
    int j = 10;
    for (int i = 0; i < j; i++) {
      collection.add(next());
    }
    return collection;
  }

}
