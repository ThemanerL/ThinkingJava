package algorithms.leecode.parimary.string;

import java.util.*;

/**
 * <h1>报数</h1>
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.    1
 * 2.    11
 * 3.    21
 * 4.    1211
 * 5.    111221
 * <p>
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 *
 * @author 李重辰
 * @date 2019/9/6 19:17
 */
public class CountAndSay {

  public static void main(String[] args) {
    String gate = new CountAndSay().gate(4);
    System.out.println(gate);
  }

  public String gate(int n) {
    int result = 1;
    for (int i = 1; i < n; i++) {
      result = solution(result);
    }
    return String.valueOf(result);
  }

  public int solution(int n) {
    char[] chars = String.valueOf(n).toCharArray();
    Map<Integer, Integer> map = new LinkedHashMap<>(1);
    StringBuilder builder = new StringBuilder();

    Integer temp = 1;
    for (int i = 0; i < chars.length; i++) {
      Integer aChar = chars[i] - 48;
      map.put(aChar, map.getOrDefault(aChar, 0) + 1);
      if (!aChar.equals(temp) || i == chars.length - 1) {
        builder.append(map.get(aChar));
        builder.append(aChar);
        map.clear();
      }
      temp = aChar;
    }

    return Integer.parseInt(builder.toString());
  }

}
