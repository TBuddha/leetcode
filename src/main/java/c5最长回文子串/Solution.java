package c5最长回文子串;

/**
 * 官解二，方法：中心扩展算法
 *
 * 时间复杂度：O(n^2)，其中 nn 是字符串的长度。长度为 11 和 22 的回文中心分别有 n 和 n−1 个，每个回文中心最多会向外扩展 O(n) 次。
 * 空间复杂度：O(1)
 *
 * @author zhout
 * @date 2020/5/21 15:16
 */
class Solution {

  public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }
    return R - L - 1;
  }
}
