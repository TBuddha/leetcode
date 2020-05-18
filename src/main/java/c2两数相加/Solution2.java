package c2两数相加;

/**
 * 优解
 * https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
 *
 * @author zhout
 * @date 2020/5/18 16:53
 */
class Solution2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode pre = new ListNode(0);
    ListNode cur = pre;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int x = l1 == null ? 0 : l1.val;
      int y = l2 == null ? 0 : l2.val;
      int sum = x + y + carry;

      // 有评论到这里可优化提速，未验证
      // carry = sum / 10;
      // =>
      carry = sum > 9 ? 1 : 0;
      sum = sum % 10;
      cur.next = new ListNode(sum);

      cur = cur.next;
      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }
    if (carry == 1) {
      cur.next = new ListNode(carry);
    }
    return pre.next;
  }
}
