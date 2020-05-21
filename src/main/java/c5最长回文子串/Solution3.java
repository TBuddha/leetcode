package c5最长回文子串;

/**
 * 优解：Manacher 算法
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
 *
 * @author zhout
 * @date 2020/5/21 15:54
 */
class Solution3 {

  public String preProcess(String s) {
    int n = s.length();
    if (n == 0) {
      return "^$";
    }
    //    String ret = "^";
    //    for (int i = 0; i < n; i++) ret += "#" + s.charAt(i);
    //    ret += "#$";
    //    return ret;
    // 这里调整一下原作的写法， += 反编译后的代码，在for循环中，每次都是new了一个StringBuilder，
    // 然后再把String转成StringBuilder，再进行append。
    // 而频繁的新建对象当然要耗费很多时间了，不仅仅会耗费时间，频繁的创建对象，还会造成内存资源的浪费
    StringBuilder ret = new StringBuilder("^");
    for (int i = 0; i < n; i++) ret.append("#").append(s.charAt(i));
    ret.append("#$");
    return ret.toString();
  }

  // 马拉车算法
  public String longestPalindrome(String s) {
    String T = preProcess(s);
    int n = T.length();
    int[] P = new int[n];
    int C = 0, R = 0;
    for (int i = 1; i < n - 1; i++) {
      int i_mirror = 2 * C - i;
      if (R > i) {
        P[i] = Math.min(R - i, P[i_mirror]); // 防止超出 R
      } else {
        P[i] = 0; // 等于 R 的情况
      }

      // 碰到之前讲的三种情况时候，需要利用中心扩展法
      while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
        P[i]++;
      }

      // 判断是否需要更新 R
      if (i + P[i] > R) {
        C = i;
        R = i + P[i];
      }
    }

    // 找出 P 的最大值
    int maxLen = 0;
    int centerIndex = 0;
    for (int i = 1; i < n - 1; i++) {
      if (P[i] > maxLen) {
        maxLen = P[i];
        centerIndex = i;
      }
    }
    int start = (centerIndex - maxLen) / 2; // 最开始讲的求原字符串下标
    return s.substring(start, start + maxLen);
  }
}
