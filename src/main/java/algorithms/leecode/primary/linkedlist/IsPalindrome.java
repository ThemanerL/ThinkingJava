package algorithms.leecode.primary.linkedlist;

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
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode one = new ListNode(2);
    ListNode two = new ListNode(3);
    ListNode three = new ListNode(2);
    ListNode four = new ListNode(1);
    head.next = one;
    one.next = two;
    two.next = three;
    three.next = four;

    IsPalindrome isPalindrome = new IsPalindrome();
    System.out.println(isPalindrome.isPalindrome(head));
  }

  public boolean isPalindrome(ListNode head) {
    return false;
  }
}
