public class Solution {
  public int climbStairs(int n) {
    if (n < 2) {
      return 1;
    }
    int pre = 1;
    int prePre = 1;
    int max = 0;

    for (int i = 2; i <= n; i++) {
      max = pre + prePre;
      prePre = pre;
      pre = max;
    }

    return max;
  }
}