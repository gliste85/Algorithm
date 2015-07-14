/**
 * Best Time to Buy and Sell Stock II
 * www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-ii/
 *
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 *
 * Design an algorithm to find the maximumprofit. You may complete as many
 * transactions as you like(ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple tansactions at
 * the same time(ie, you must sell the stock before you buy again).
 *
 * Example
 * Given an example [2 ,1, 2, 0, 1], return 2.
 */

class Solution {
  /**
   * @param prices: Given an integer array
   * @return: Maximum profit
   */
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int result = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      int diff = prices[i + 1] - prices[i];
      if (diff > 0) {
        result += diff;
      }
    }
    return result;
  }
};
