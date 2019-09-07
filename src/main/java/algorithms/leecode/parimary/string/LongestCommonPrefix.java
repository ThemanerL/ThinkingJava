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

  }

  public String solution(String[] strs) {

    int minLength = 255;
    for (int i = 0; i < strs.length; i++) {
      minLength = Math.min(strs[i].length(), minLength);
    }

    char[] prefix;
    for (int i = 0; i < minLength; i++) {
      for (int j = 0; j < strs.length; j++) {
//        if (strs[j].charAt(i))
      }
    }
    return "";
  }
}
