package c4寻找两个正序数组的中位数;

/**
 * 优解二
 * 时间复杂度达不到题目的要求 O(log(m+n)
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 *
 * @author zhout
 * @date 2020/5/20 10:36
 */
class Solution2 {

  public double findMedianSortedArrays(int[] A, int[] B) {
    int m = A.length;
    int n = B.length;
    //合并数组的长度
    int len = m + n;

    //left左中位数，right右中位数
    int left = -1, right = -1;

    //下标位移
    int aStart = 0, bStart = 0;

    for (int i = 0; i <= len / 2; i++) {
      left = right;
      if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
        right = A[aStart++];
      } else {
        right = B[bStart++];
      }
    }

    //合并数组长度是1，则本身。否则为俩中位数/2
    if ((len & 1) == 0) return (left + right) / 2.0;
    else return right;
  }
}
