import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * Copyright 2020, Xiaomi.
 * All rights reserved.
 *
 * @Author: wangfan8@xiaomi.com
 */

public class UniquePaths {

  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = 1;
        } else if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
      }
    }
    return dp[m-1][n-1];
  }

  public static void main(String[] args) {
    UniquePaths uniquePaths = new UniquePaths();
    System.out.println(uniquePaths.uniquePaths(1,1));

  }


}


