package algorithms.leecode.primary.string;

import java.util.ArrayList;

/**
 * <h1>整数反转</h1>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 题解：
 * 1、可以将数字转化为字符串，然后反转字符串
 * 2、可以使用堆栈或者数组
 *
 * @author 李重辰
 * @date 2019/8/30 10:05
 */
public class Reverse {
  public static void main(String[] args) {
    int solution = new Reverse().solution(153);
    System.out.println(solution);
  }

  public int solution(int x) {
    int origin = x;
    if (x < 0) {
      origin = -x;
    }
    // 将 x 转化为int数组
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = String.valueOf(origin).length() - 1; i >= 0; i--) {
      int v = (int) Math.floor(origin / Math.pow(10, i));
      list.add(v);
      origin = (int) Math.floor(origin % Math.pow(10, i));
    }
    // 将数组转化为int数值返回
    int result = 0;
    for (int j = list.size() - 1; j >= 0; ) {
      try {
        result = Math.addExact(result, (int) (list.get(j) * Math.pow(10, j--)));
      } catch (ArithmeticException e) {
        return 0;
      }
    }
    if (x < 0) {
      return -result;
    }
    return result;
  }

  /**
   * 终极算法
   *
   * @return
   */
  private int solutionTwo(int x) {
    int result = 0;
    int biggerValue = Integer.MAX_VALUE / 10;
    int smallerValue = Integer.MIN_VALUE / 10;
    while (x != 0) {
      int pop = x % 10;
      x /= 10;
      if (result > biggerValue) {
        return 0;
      }
      if (result < smallerValue) {
        return 0;
      }
      result = result * 10 + pop;
    }
    return result;
  }

}
