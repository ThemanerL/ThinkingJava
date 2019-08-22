package algorithms.leecode;

import java.util.Arrays;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author 李重辰
 * @date 2019/8/21 20:50
 */
public class MoveZeroes {
  public static void main(String[] args) {
    int[] nums = new int[]{0, 3, 0, 3, 12};
    new MoveZeroes().solution(nums);
    Arrays.stream(nums).forEach(System.out::println);
  }

  private void solution(int[] nums) {
    int length = nums.length;
    int i = 0;
    while (i < nums.length) {
      while (nums[i] == 0) {
        System.arraycopy(nums, i + 1, nums, i, length - (i + 1));
        nums[length - 1] = 0;
        if (isEnd(i, nums)) {
          return;
        }
      }
      i++;
    }
  }

  private static boolean isEnd(int j, int[] nums) {
    for (; j < nums.length; j++) {
      if (nums[j] != 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * 终极算法
   * @param nums
   */
  public void moveZeroes(int[] nums) {
    if(nums == null || nums.length < 2){
      return;
    }

    int count = 0;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] == 0){
        count++;
      }else{
        nums[i-count] = nums[i];
      }
    }
    for(int j = 0; j < count; j++){
      nums[nums.length - 1 -j] = 0;
    }
  }
}
