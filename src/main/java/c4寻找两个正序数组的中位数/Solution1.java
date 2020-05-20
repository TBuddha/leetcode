package c4寻找两个正序数组的中位数;

/**
 * 优解一
 * 时间复杂度达不到题目的要求 O(log(m+n)
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 *
 * 简单粗暴，先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据奇数，还是偶数，返回中位数。
 *
 *
 * @author zhout
 * @date 2020/5/20 10:07
 */
class Solution1 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] nums;
    int m = nums1.length;
    int n = nums2.length;
    nums = new int[m + n];
    // nums1为空，nums2分奇偶两种情况判断
    if (m == 0) {
      if (n % 2 == 0) {
        return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
      } else {
        return nums2[n / 2];
      }
    }
    // nums2为空，nums1分奇偶情况判断
    if (n == 0) {
      if (m % 2 == 0) {
        return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
      } else {
        return nums1[m / 2];
      }
    }

    //两个数组合并
    int count = 0;
    int i = 0, j = 0;
    while (count != (m + n)) {
      if (i == m) {
        while (j != n) {
          nums[count++] = nums2[j++];
        }
        break;
      }
      if (j == n) {
        while (i != m) {
          nums[count++] = nums1[i++];
        }
        break;
      }

      if (nums1[i] < nums2[j]) {
        nums[count++] = nums1[i++];
      } else {
        nums[count++] = nums2[j++];
      }
    }

    if (count % 2 == 0) {
      return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
    } else {
      return nums[count / 2];
    }
  }
}
