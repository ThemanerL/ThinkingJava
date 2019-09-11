package algorithms.leecode.primary.linkedlist;

import static algorithms.leecode.primary.linkedlist.DeleteNode.ListNode;

/**
 * <h1>反转链表</h1>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author 李重辰
 * @date 2019/9/11 20:48
 */
public class ReverseList {
  public ListNode reverseList(ListNode head) {
    ListNode pre = new ListNode(0);
    ListNode temp = head;
    pre.next = head;
    while (head.next != null) {
      head = head.next;
    }

    while (temp.next == head) {
      head.next = temp;
    }
    return null;
  }
}
