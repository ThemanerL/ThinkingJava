package algorithms.leecode.parimary.string;

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
    boolean solution = new IsAnagram().solution("aa", "bb");
    System.out.println(solution);
  }

  public boolean solution(String s, String t) {
    char[] chars = s.toCharArray();
    char[] chars1 = t.toCharArray();
    int result = 0;
    int chatInt1 = 0;
    for (char c : chars) {
      result = result ^ c;
      chatInt1 += c;
    }

    int chatInt2 = 0;
    for (char c : chars1) {
      result = result ^ c;
      chatInt2 += c;
    }
    return chatInt1 == chatInt2 && result == 0;
  }
}
