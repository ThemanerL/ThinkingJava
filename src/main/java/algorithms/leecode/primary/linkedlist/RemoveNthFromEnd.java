package algorithms.leecode.primary.linkedlist;

import static algorithms.leecode.primary.linkedlist.DeleteNode.ListNode;

/**
 * <h1>删除链表的倒数第N个节点</h1>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author 李重辰
 * @date 2019/9/11 19:13
 */
public class RemoveNthFromEnd {
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
    ListNode listNode = new RemoveNthFromEnd().removeNthFromEnd(head, 5);
    System.out.println(listNode);
  }

  private ListNode removeNthFromEnd(ListNode head, int n) {
    int length = 1;
    ListNode temp = head;
    while (head.next != null) {
      length++;
      head = head.next;
    }
    head = temp;

    int target = length - n;
    int flag = 0;
    if (target == 0) {
      head = head.next;
      return head;
    }
    while (head.next != null) {
      flag++;
      if (flag == target) {
        if (n == 1) {
          head.next = null;
          continue;
        }
        head.next = head.next.next;
      }
      head = head.next;
    }
    head = temp;
    return head;
  }
}

