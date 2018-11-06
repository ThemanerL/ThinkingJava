package thinkingjava.chapter11.practice;

/**
 * @author 李重辰
 * @date 2018/11/5 20:17
 */
public class P4 {
}

class Generate {
  private String[] originChar = {"My", "name", "is", "Li", "The", "Man", "er!"};
  private int next = 0;

  String next() {
    String str = originChar[next];
    next = (next + 1) % originChar.length;
    return str;
  }

}
