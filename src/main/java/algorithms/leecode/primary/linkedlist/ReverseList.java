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
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode one = new ListNode(2);
    ListNode two = new ListNode(3);
    ListNode three = new ListNode(4);
    ListNode four = new ListNode(5);
    head.next = one;
    one.next = two;
    two.next = three;
    three.next = four;
    ListNode resultHead = new ReverseList().reverseList(head);
    System.out.println(resultHead);
  }

  /**
   * 递归法
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {
    if(head==null||head.next==null){
      return head;
    }
    ListNode temp = head.next;
    ListNode newHead = reverseList(head.next);
    temp.next = head;
    head.next = null;
    return newHead;
  }
}
