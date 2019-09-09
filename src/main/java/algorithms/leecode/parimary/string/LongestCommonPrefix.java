package algorithms.leecode.parimary.string;

/**
 * <h1>最长公共前缀</h1>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author 李重辰
 * @date 2019/9/7 10:52
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] strs = {"aca", "cba"};
    String s = new LongestCommonPrefix().solution(strs);
    System.out.println(s);
  }

  /**
   * 初级算法 时间复杂度O(n^2)
   *
   * @param strs
   * @return
   */
  public String solution(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    int minLength = Integer.MAX_VALUE;
    for (String str : strs) {
      minLength = Math.min(str.length(), minLength);
    }
    StringBuilder sb = new StringBuilder();
    char temp;
    for (int i = 0, j; i < minLength; i++) {
      j = 0;
      temp = strs[j].charAt(i);
      for (; j < strs.length; j++) {
        if (temp != strs[j].charAt(i)) {
          return sb.toString();
        }
        if (j == strs.length - 1) {
          sb.append(temp);
        }
      }
    }
    return sb.toString();
  }

}
