package algorithms.leecode.parimary.string;

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
 *
 * @author 李重辰
 * @date 2019/8/30 10:05
 */
public class Reverse {
  public static void main(String[] args) {
    int solution = new Reverse().solution(1534236469);
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
    // 翻转数组
    int size = list.size();
    for (int i = 0; i < size / 2; i++) {
      Integer temp = list.get(i);
      list.set(i, list.get(size - 1 - i));
      list.set(size - 1 - i, temp);
    }
    // 将数组转化为int数值返回
    int result = 0;
    for (int i = 0, j = list.size() - 1; i < list.size(); ) {
      try {
        result = Math.addExact(result, (int) (list.get(i++) * Math.pow(10, j--)));
      } catch (ArithmeticException e) {
        return 0;
      }
    }
    if (x < 0) {
      return -result;
    }
    return result;
  }
}
