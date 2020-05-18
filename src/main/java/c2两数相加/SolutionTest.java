package c2两数相加;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zhout
 * @date 2020/5/18 16:28
 */
public class SolutionTest {

  private long start;
  private long end;

  private ListNode l1;
  private ListNode l2;

  @Before
  public void before() {
    start = System.currentTimeMillis();

    l1 = new ListNode(1);
    l1.next = new ListNode(2);

    l2 = new ListNode(2);
    l2.next = new ListNode(9);
  }

  @After
  public void after() {
    end = System.currentTimeMillis();
    System.out.println("cost: " + (end - start) + "ms");
  }

  @Test
  public void solution() {
    Solution res = new Solution();
    System.out.println(res.addTwoNumbers(l1, l2));
  }

  @Test
  public void solution2() {
    Solution2 res = new Solution2();
    System.out.println(res.addTwoNumbers(l1, l2));
  }
}
