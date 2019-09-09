package algorithms.leecode.primary.string;

/**
 * <h1>验证回文字符串</h1>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 *
 * @author 李重辰
 * @date 2019/9/3 16:29
 */
public class IsPalindrome {
  public static void main(String[] args) {
    boolean solution = new IsPalindrome().solution("caac");
    System.out.println(solution);
  }

  private boolean solution(String s) {
    String s1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    int length = s1.length();
    for (int i = 0; i < length; i++) {
      if (s1.charAt(i) != s1.charAt(length - 1 - i)) {
        return false;
      }
    }
    return true;
  }
}
