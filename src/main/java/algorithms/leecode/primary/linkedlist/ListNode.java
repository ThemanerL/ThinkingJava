package algorithms.leecode.primary.linkedlist;

import java.util.StringJoiner;

/**
 * @author 李重辰
 * @date 2019/12/5 11:25
 */
public class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
        .add("val=" + val)
        .add("next=" + next)
        .toString();
  }
}
