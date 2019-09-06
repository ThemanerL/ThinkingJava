package algorithms.leecode.parimary.string;

/**
 * <h1>实现 strStr()</h1>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hlello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @author 李重辰
 * @date 2019/9/5 18:08
 */
public class StrStr {

  public int solution(String haystack, String needle) {
    int hLength = haystack.length();
    int nLength = needle.length();
    char[] chars = haystack.toCharArray();
    if (needle.length() == 0) {
      return 0;
    }
    if (needle.length() > hLength) {
      return -1;
    }
    for (int i = 0; i < hLength; i++) {
      // 当某个字符与目标字符匹配后，开始匹配后面的字符
      if (chars[i] == needle.charAt(0)) {
        if (hLength - i < nLength) {
          return -1;
        }
        // 若后面的字符在needle循环完之前，有不匹配的，则继续外层循环
        for (int k = i, j = 0; j < nLength || k < hLength; k++, j++) {
          if (chars[k] != needle.charAt(j)) {
            // 重新从i开始
            break;
          }
          if (j == needle.length() - 1) {
            return i;
          }
        }
      }
    }
    return -1;
  }
}
