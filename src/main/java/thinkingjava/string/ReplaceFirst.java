package thinkingjava.string;

import static thinkingjava.string.Splitting.knights;

/**
 * @author 李重辰
 * @date 2019/12/7 17:04
 */
public class ReplaceFirst {
  private static String s = knights;

  public static void main(String[] args) {
    System.out.println(s.replaceFirst("f\\w++", "located"));
    System.out.println(s.replaceAll("shrubbery|tree|herring", "bannana"));
  }
}
