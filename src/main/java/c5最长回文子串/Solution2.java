package c5最长回文子串;

/**
 * 优解：暴力解法
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
 *
 * 时间复杂度： O(n³），两层 for 循环 O(n²），for 循环里边判断是否为回文 O(n），所以时间复杂度为 O(n³）。
 * 空间复杂度：O(1），常数个变量。
 *
 * @author zhout
 * @date 2020/5/21 15:39
 */
class Solution2 {
  public String longestPalindrome(String s) {
    String ans = "";
    int max = 0;
    int len = s.length();
    for (int i = 0; i < len; i++)
      for (int j = i + 1; j <= len; j++) {
        String test = s.substring(i, j);
        if (isPalindromic(test) && test.length() > max) {
          ans = s.substring(i, j);
          max = Math.max(max, ans.length());
        }
      }
    return ans;
  }

  public boolean isPalindromic(String s) {
    int len = s.length();
    // 检查一半即可
    for (int i = 0; i < len / 2; i++) {
      // 对应回文字符串，一一比较是否相同
      if (s.charAt(i) != s.charAt(len - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
