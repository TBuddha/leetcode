package c1两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * 一遍哈希表
 *
 * @author zhout
 * @date 2020/5/18 15:09
 */
class Solution2 {

  // 时间复杂度：O(n)，
  // 我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。
  // 空间复杂度：O(n)，
  // 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}
