package c1twosum;

import java.util.Arrays;

/**
 * （不可用）双指针，除非列表有。数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
 *
 * @author zhout
 * @date 2020/5/18 15:11
 */
class Solution2 {

  // 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
  // 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
  // 如果 sum > target，移动较大的元素，使 sum 变小一些；
  // 如果 sum < target，移动较小的元素，使 sum 变大一些。
  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null) return null;
    int i = 0, j = numbers.length - 1;
    while (i < j) {
      int sum = numbers[i] + numbers[j];
      if (sum == target) {
        return new int[] {i, j};
      } else if (sum < target) {
        i++;
      } else {
        j--;
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  public static void main(String[] args) {
    Solution2 res = new Solution2();
    System.out.println(Arrays.toString(res.twoSum(new int[] {3, 2, 4}, 6)));
  }
}
