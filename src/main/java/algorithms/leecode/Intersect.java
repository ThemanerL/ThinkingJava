package algorithms.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author 李重辰
 * @date 2019/8/19 20:20
 */
public class Intersect {
    public static void main(String[] args) {
        int[] ints = new Intersect().solution(new int[]{1, 2, 2, 3}, new int[]{2, 2, 4});
        Arrays.stream(ints).forEach(System.out::println);
    }

    /**
     * 最蠢算法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] solution(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>(Math.min(nums1.length, nums2.length));
        for (int item : nums1) {
            for (int value : nums2) {
                if (item == value) {
                    list.add(item);
                    break;
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
