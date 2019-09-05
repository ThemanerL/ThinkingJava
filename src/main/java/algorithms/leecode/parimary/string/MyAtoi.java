package algorithms.leecode.parimary.string;

import org.jetbrains.annotations.Contract;

/**
 * 字符串转换整数 (atoi)
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−2^31) 。
 * 示例 6:
 * <p>
 * 输入: "3.141"
 * 输出: 3
 * 解释: '3'的下一个字符不为数字。
 *
 * @author 李重辰
 * @date 2019/9/3 16:57
 */
public class MyAtoi {

  /**
   * 3.141592647 应当转化为3
   *
   * @param str
   * @return
   */
  @Contract(pure = true)
  public int solution(String str) {
    while (str.length() > 0 && str.charAt(0) == ' ') {
      str = str.replaceFirst(" ", "");
    }
    if (str.length() == 0) {
      return 0;
    }
    char c = str.charAt(0);
    // 判断字符串的首字符是否为0-9，-，+
    boolean specChar = isSpecialChar(c);
    if (specChar) {
      return 0;
    }
    // 当出现非数字字符时，截断字符串
    char[] charArray = str.toCharArray();
    for (int i = 1; i < charArray.length; i++) {
      char temp = charArray[i];
      if (!Character.isDigit(temp)) {
        str = str.substring(0, i);
        break;
      }
    }
    if (str.length() < 2 && !Character.isDigit(str.charAt(0))) {
      return 0;
    }
    // 当数值超出范围时，输入Integer.MIN_VALUE或者Integer.MAX_VALUE
    int result;
    try {
      result = Integer.parseInt(str);
    } catch (NumberFormatException e) {
      if (c == 45) {
        return Integer.MIN_VALUE;
      } else {
        return Integer.MAX_VALUE;
      }
    }
    return result;
  }

  private boolean isSpecialChar(char temp) {
    return temp > 57 || (temp < 48 && temp != 43 && temp != 45);
  }

  /**
   * 7毫秒
   *
   * @param str
   * @return
   */
  public int solutionTwo(String str) {
    if (str.length() == 0) {
      return 0;
    }

    char[] chars = str.toCharArray();
    char[] result = new char[chars.length];
    int i = 0, j = 0;
    // 此处从chars[i] 开始往后处理，
    for (; i < chars.length; ) {
      if (chars[i] != ' ') {
        break;
      } else {
        i++;
      }
    }

    // 开始由chars[i]节点开始存数据
    for (int k = i; k < chars.length; k++) {
      if ((k == i && (chars[i] == '+' || chars[i] == '-')) || Character.isDigit(chars[k])) {
        result[j++] = chars[k];
      } else {
        break;
      }
    }

    if (result.length == 0) {
      return 0;
    }

    int flag = 1;
    int start = 0;
    if (!Character.isDigit(result[0])) {
      start = 1;
      if (result[0] == '-') {
        flag = -1;
      }
    }

    int sum = 0;
    for (int k = start; k < j; k++) {
      try {
        sum = Math.addExact(sum, (int) (Character.getNumericValue(result[k]) * Math.pow(10, j - 1 - k)));
      } catch (ArithmeticException e) {
        if (flag == 1) {
          return Integer.MAX_VALUE;
        } else {
          return Integer.MIN_VALUE;
        }
      }
    }
    return sum * flag;
  }
}


