package algorithms.leecode.primary.linkedlist;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 提示：此题可以使用递归解决。
 *
 * @author 李重辰
 * @date 2019/12/6 21:08
 */
public class IsPalindrome {
  public boolean isPalindrome(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    while (head.next != null) {
      stack.push(head);
      head.next = head;
    }

    while (!stack.empty()) {
      if (stack.pop() != head) {
        return false;
      }
    }
    return true;
  }
}
