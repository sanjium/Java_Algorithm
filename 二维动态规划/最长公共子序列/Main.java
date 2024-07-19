package 二维动态规划.最长公共子序列;

import java.util.Arrays;

// 测试链接: https://leetcode.cn/problems/longest-common-subsequence/description/
public class Main {

    public int[][] mem;

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();
        mem = new int[n + 1][m + 1];

        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }

        return dfs(text1, text2, n, m);
    }

    public int dfs(String text1, String text2, int len1, int len2) {
        if (len1 == 0 || len2 == 0) {
            return 0;
        }

        if (mem[len1 - 1][len2 - 1] != -1) {
            return mem[len1 - 1][len2 - 1];
        }

        int result;
        if (text1.charAt(len1 - 1) == text2.charAt(len2 - 1)) {
            result = dfs(text1, text2, len1 - 1, len2 - 1) + 1;
        } else {
            result = Math.max(dfs(text1, text2, len1 - 1, len2), dfs(text1, text2, len1, len2 - 1));
        }
        mem[len1 - 1][len2 - 1] = result;
        return result;
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        mem = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    mem[i][j] = mem[i - 1][j - 1] + 1;
                } else {
                    mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
                }
            }
        }

        return mem[n][m];
    }

}
