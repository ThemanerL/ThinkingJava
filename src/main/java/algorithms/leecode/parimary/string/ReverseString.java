package algorithms.leecode.parimary.string;

/**
 * <h1>反转字符串</h1>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：['h','e','l','l','o']
 * 输出：['o','l','l','e','h']
 * 示例 2：
 * <p>
 * 输入：['H','a','n','n','a','h']
 * 输出：['h','a','n','n','a','H']
 *
 * @author 李重辰
 * @date 2019/8/28 20:29
 */
public class ReverseString {
  public static void main(String[] args) {
    char[] s = {'h', 'e', 'l', 'l', 'o','k'};
    new ReverseString().solution(s);
    for (char c : s) {
      System.out.println(c);
    }
  }

  private void solution(char[] s) {
    int loopTimes = s.length / 2;
    for (int i = 0; i < loopTimes; i++) {
      char temp = s[i];
      s[i] = s[s.length - 1 - i];
      s[s.length - 1 - i] = temp;
    }
  }
}
