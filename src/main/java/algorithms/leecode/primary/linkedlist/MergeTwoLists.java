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

  private ListNode solution(ListNode l1, ListNode l2) {}

  public static void main(String[] args) {
    ListNode one = new ListNode(1);
    ListNode three = new ListNode(3);
    ListNode five = new ListNode(5);
    one.next = three;
    three.next = five;

    ListNode one1 = new ListNode(1);
    ListNode two = new ListNode(3);
    ListNode three1 = new ListNode(5);
    one1.next = two;
    two.next = three1;

    ListNode solution = new MergeTwoLists().solution(one, one1);
    System.out.println(solution);
  }
}
