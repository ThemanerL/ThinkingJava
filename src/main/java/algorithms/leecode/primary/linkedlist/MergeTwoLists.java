package algorithms.leecode.primary.linkedlist;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author 李重辰
 * @date 2019/12/5 11:03
 */
public class MergeTwoLists {

  private ListNode solution(ListNode l1, ListNode l2) {
    if (null == l1 && null == l2) {
      return null;
    } else if (null == l1) {
      return l2;
    } else if (null == l2) {
      return l1;
    } else {
      ListNode pre = new ListNode(-1);
      ListNode pointer = pre;
      while (null != l1 && null != l2) {
        if (l1.val <= l2.val) {
          pointer.next = l1;
          l1 = l1.next;
        } else {
          pointer.next = l2;
          l2 = l2.next;
        }
        pointer = pointer.next;
      }
      pointer.next = l1 == null ? l2 : l1;
      return pre.next;
    }
  }

  public static void main(String[] args) {
    ListNode one = new ListNode(1);
    ListNode three = new ListNode(3);
    ListNode five = new ListNode(5);
    one.next = three;
    three.next = five;

    ListNode one1 = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three1 = new ListNode(3);
    one1.next = two;
    two.next = three1;

    ListNode solution = new MergeTwoLists().solution(one, one1);
    System.out.println(solution);
  }
}
