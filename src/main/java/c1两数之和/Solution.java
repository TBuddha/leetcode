package c1两数之和;

/**
 * 官解，https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
 * 暴力法
 *
 * @author zhout
 * @date 2020/5/18 15:02
 */
class Solution {

  // 时间复杂度：O(n^2) 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，
  // 这将耗费 O(n) 的时间。因此时间复杂度为 O(n^2)
  // 空间复杂度：O(1)
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == target - nums[i]) {
          return new int[] {i, j};
        }
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}
