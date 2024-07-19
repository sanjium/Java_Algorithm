package 二维动态规划.最长回文子序列;

import java.util.Arrays;

// 测试链接: https://leetcode.cn/problems/longest-palindromic-subsequence/description/
public class Main {

    public int[][] dp;

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n + 1][n + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return dfs(s, 0, n - 1);
    }

    public int dfs(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int result;
        if (s.charAt(i) == s.charAt(j)) {
            result = dfs(s, i + 1, j - 1) + 2;
        } else {
            result = Math.max(dfs(s, i + 1, j), dfs(s, i, j - 1));
        }
        dp[i][j] = result;
        return result;
    }

    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

}
