package thinkingjava.string;

import java.util.Arrays;

/**
 * @author 李重辰
 * @date 2019/12/7 16:25
 */
public class Splitting {
  static String knights = "Then, when you have found the shrubbery, you must cut down the mightiest tree in the forest... with... a herring!";

  public static void split(String regex) {
    System.out.println(Arrays.asList(knights.split(regex)));
  }

  public static void main(String[] args) {
    split(" ");
    split("\\W+");
    split("n\\W+");
  }
}
