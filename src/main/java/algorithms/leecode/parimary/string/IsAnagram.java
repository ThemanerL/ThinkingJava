package algorithms.leecode.parimary.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>有效的字母异位词</h1>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author 李重辰
 * @date 2019/9/2 20:50
 */
public class IsAnagram {

  public static void main(String[] args) {
    boolean solution = new IsAnagram().solution("xaaddy", "xbbccy");
    System.out.println(solution);
  }

  public boolean solution(String s, String t) {
    char[] chars = s.toCharArray();
    char[] chars1 = t.toCharArray();
    Set<Character> set = new HashSet<>();
    int result = 0;
    int chatInt1 = 0;
    for (char c : chars) {
      result = result ^ c;
      chatInt1 += c;
      set.add(c);
    }

    int chatInt2 = 0;
    for (char c : chars1) {
      result = result ^ c;
      chatInt2 += c;
      if (!set.contains(c)) {
        return false;
      }
    }
    return chatInt1 == chatInt2 && result == 0;
  }

  public boolean solutionOne(String s, String t){
    if (s.length()!=t.length()){
      return false;
    }
    char[] chars1 = s.toCharArray();
    char[] chars2 = t.toCharArray();
    Arrays.sort(chars1);
    Arrays.sort(chars2);
    return Arrays.equals(chars1, chars2);
  }

  public boolean solutionTwo(String s, String t){
    if (s.length()!=t.length()){
      return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }
}
