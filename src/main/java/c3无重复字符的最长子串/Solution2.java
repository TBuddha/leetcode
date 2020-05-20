package c3无重复字符的最长子串;

/**
 *
 * 评论找的优解
 * @author zhout
 * @date 2020/5/19 16:32
 */
class Solution2 {
  public static int lengthOfLongestSubstring(String s) {
    int maxSize = 0;
    int[] dict = new int[256]; // 记录ASCII 码字符出现的位置，以字符作为下标
    int base = 0;
    int key = 0;
    int i;
    while (key < s.length()) {
      i = s.charAt(key);
      if (dict[i] > base) base = dict[i];
      dict[i] = key + 1; // 以1作为起始位置，下标加1
      maxSize = Math.max(maxSize, key - base + 1);
      key++;
    }
    return maxSize;
  }
}
