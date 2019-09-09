package algorithms.leecode.primary.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <h1>字符串中的第一个唯一字符</h1>
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author 李重辰
 * @date 2019/9/2 16:46
 */
public class FirstUniqueChar {

  public static void main(String[] args) {
    int solution = new FirstUniqueChar().solutionTwo("dddeccdbba");
    System.out.println(solution);
  }

  private int solution(String s) {
    char[] chars = s.toCharArray();
    Map<Character, Integer> map = new LinkedHashMap<>(32);
    for (char c : chars) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (int i = 0; i < chars.length; i++) {
      if (map.get(chars[i]) == 1) {
        return i;
      }
    }
    return -1;
  }

  public int solutionTwo(String s) {
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (s.indexOf(ch) == s.lastIndexOf(ch)) {
        return i;
      }
    }
    return -1;
  }

}
