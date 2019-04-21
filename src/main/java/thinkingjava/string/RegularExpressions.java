package thinkingjava.string;

import java.util.Arrays;

/**
 * '\w'代表一个单词字符
 * '\W'代表一个非单词字符
 * @author 李重辰
 * @date 2019/4/15 12:29
 */
public class RegularExpressions {
  public static void main(String[] args) {
    System.out.print("-1234".matches("-?\\d+")+"\t");
    System.out.print("1234".matches("-?\\d+")+"\t");
    System.out.print("+1234".matches("-?\\d+")+"\t");
    System.out.println("+1234".matches("(-?|\\+)\\d+"));
    split(" ");
    split("\\W+");
    split("n\\W+");
  }


  public static void split(String regex) {
    String knights =
        "Then, when you have found the shrubbery, you must " +
            "cut down the mightiest tree in the forest... " +
            "with... a herring!";
    System.out.println(
        Arrays.toString(knights.split(regex)));
  }
}
