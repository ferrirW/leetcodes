import java.util.Arrays;

/**
 * Copyright 2020, Xiaomi.
 * All rights reserved.
 *
 * @Author: wangfan8@xiaomi.com
 */

public class MaxProfit {

  private static int[] prices = {1, 3, 2, 8, 4, 9};
  private static int fee = 2;

  public int maxProfitDp(int[] prices, int fee) {
    int days = prices.length;
    int[][] dp = new int[days][2];
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < days; i++) {
      dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - fee + prices[i]);
      dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
    }

    return dp[days-1][0];
  }

  //贪心没看懂。。。感觉会陷入局部最优
  public int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    int buy = prices[0] + fee;
    int profit = 0;
    for (int i = 1; i < n; ++i) {
      System.out.println(prices[i] + " " + (prices[i]+fee) + " " + buy + " " + profit);
      if (prices[i] + fee < buy) {
        buy = prices[i] + fee;
      } else if (prices[i] > buy) {
        profit += prices[i] - buy;
        buy = prices[i];
      }
    }
    return profit;
  }


  public static void main(String[] args) {
    MaxProfit maxProfit = new MaxProfit();
    System.out.println(maxProfit.maxProfit(prices, fee));;
  }
}
