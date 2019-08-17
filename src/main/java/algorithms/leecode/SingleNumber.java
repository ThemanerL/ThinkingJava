package algorithms.leecode;

import java.util.Arrays;
import java.util.PrimitiveIterator;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author 李重辰
 * @date 2019/8/17 9:59
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int i = new SingleNumber().solutionTwo(nums);
        System.out.println(i);
    }

    private int solutionOne(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean sorted = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
        if (nums.length == 1 || nums[0] != nums[1]) {
            return nums[0];
        }
        for (int i = 2; i < nums.length; i = i + 2) {
            if (i >= nums.length - 1) {
                return nums[i];
            }
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 将数组排序后求和，奇数+ 偶数- 这种方式引用的PrimitiveIterator在LeetCode中没有被引用
     * @param nums
     * @return
     */
    private int solutionTwo(int[] nums) {
        PrimitiveIterator.OfInt iterator = Arrays.stream(nums).sorted().;
        int sum = 0;
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            Integer integer = iterator.next();
            if ((1 & i) == 1) {
                sum += integer;
            } else {
                sum -= integer;
            }
        }
        return sum;
    }
}
