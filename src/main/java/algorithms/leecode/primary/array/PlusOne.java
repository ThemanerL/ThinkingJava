package algorithms.leecode.primary.array;

import java.util.Arrays;

/**
 * <h1>加一</h1>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author 李重辰
 * @date 2019/8/20 17:57
 */
public class PlusOne {
  public static void main(String[] args) {
    int[] ints = new PlusOne().solution(new int[]{4, 3, 2, 9});
    Arrays.stream(ints).forEach(System.out::println);
  }

  private int[] solution(int[] digits) {
    int i = digits[digits.length - 1] + 1;
    digits[digits.length - 1] = i;
    if (i < 10) {
      return digits;
    }
    // 如果最后一位大于10，则进位
    for (int j = digits.length - 1; j > 0; j--) {
      if (digits[j] > 9) {
        digits[j - 1] = digits[j - 1] + 1;
        digits[j] = i - 10;
      }
    }
    if (digits[0] < 10) {
      return digits;
    }
    // 如果进位到digits[0]>10 则digits[1]至digits[length-1]全部后移一位
    int[] outPut = new int[digits.length + 1];
    outPut[0] = 1;
    outPut[1] = i - 10;
    System.arraycopy(digits, 1, outPut, 2, digits.length - 1);
    return outPut;
  }
}
