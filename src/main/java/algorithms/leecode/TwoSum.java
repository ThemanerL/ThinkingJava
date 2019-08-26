package algorithms.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>两数之和</h1>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author 李重辰
 * @date 2019/5/2 12:47
 */
public class TwoSum {
  public static void main(String[] args) {
    int[] numbers = {2, 2, 2, 15};
    TwoSum twoSum = new TwoSum();
    int[] solution = twoSum.solutionTwo(numbers, 4);
    for (int s : solution) {
      System.out.println(s);
    }
    solution = twoSum.solutionTwo(numbers, 17);
    for (int s : solution) {
      System.out.println(s);
    }
  }

  private int[] solution(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>(16);
    for (int i = 0; i < nums.length; i++) {
      int value = target - nums[i];
      if (map.containsKey(value)) {
        return new int[]{map.get(value), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No Such elements");
  }

  private int[] solutionTwo(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>(16);
    for (int i = 0; i < nums.length; i++) {
      int temp = target - nums[i];
      if (map.containsKey(temp)) {
        return new int[]{map.get(temp), i};
      }
      map.put(nums[i], i);
    }
    throw new RuntimeException("输入不合法");
  }
}
