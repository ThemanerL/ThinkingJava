package algorithms.leecode.primary.linkedlist;

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
//    ListNode resultHead = new ReverseList().reverserListThree(head);
//    System.out.println("循环方式原地反转输出：" + resultHead);
//    ListNode resultHead2 = new ReverseList().reverseListByInsert(head);
//    System.out.println("循环方式头结点插入法输出：" + resultHead2);
    ListNode resultHead3 = new ReverseList().secondLinkedList0427(head);
    System.out.println("循环方式原地反转输出：" + resultHead3);
  }

  /**
   * 递归法
   *
   * @param head 链表的头结点
   * @return 反转后的链表的头
   */
  private ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

  /**
   * 循环法
   *
   * @param head 链表的头结点
   * @return 反转后的链表的头
   */
  private ListNode reverserListThree(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode pre = head;
    ListNode next = head.next;
    ListNode temp;
    head.next = null;
    while (next != null) {
      temp = next.next;
      next.next = pre;
      pre = next;
      next = temp;
    }
    return pre;
  }

  /**
   * 头结点插入法反转链表
   * 创建了一个临时节点，和另一个新的节点
   */
  public ListNode reverseListByInsert(ListNode head) {
    ListNode listResult = new ListNode(-1);
    ListNode temp;
    while (head != null) {
      temp = head.next;
      head.next = listResult.next;
      listResult.next = head;
      head = temp;
    }
    return listResult.next;
  }

  /**
   * 理解后写的原地while循环反转链表
   */
  private ListNode myReverseListByReLocate(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode preHead = null, tempNode;
    while (head != null) {
      tempNode = head.next;
      head.next = preHead;
      preHead = head;
      head = tempNode;
    }
    return preHead;
  }

  /**
   * 递归原地反转，算是自己写出来了吧但是有点迷糊
   */
  private ListNode myRecursiveSolution(ListNode head) {
    if (head.next == null) {
      return head;
    }
    ListNode temp = head.next;
    head.next = null;
    ListNode preHead = myRecursiveSolution(temp);
    temp.next = head;
    return preHead;
  }

  /**
   * 今天完全是自己画图自己写出来的，用两个链表处理的方式基本掌握
   * 2020/04/27
   */
  private ListNode secondLinkedList0427(ListNode head) {
    ListNode result = new ListNode(-1);
    ListNode temp;
    while (head != null) {
      temp = head.next;
      head.next = result.next;
      result.next = head;
      head = temp;
    }
    return result.next;
  }
}
