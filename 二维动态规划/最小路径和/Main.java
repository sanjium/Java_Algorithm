package 二维动态规划.最小路径和;

import java.util.Arrays;

// 测试链接: https://leetcode.cn/problems/minimum-path-sum/description/
public class Main {

    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] mem = new int[x + 1][y + 1];
        for (int[] ints : mem) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        return dfs(grid, mem, x, y, 0, 0);
    }

    public int dfs(int[][] grid, int[][] mem, int x, int y, int i, int j) {
        if (mem[i][j] != Integer.MAX_VALUE) {
            return mem[i][j];
        }

        if (i >= x || j >= y) {
            return Integer.MAX_VALUE;
        }

        if (i == x - 1 && j == y - 1) {
            return grid[i][j];
        }

        int down = dfs(grid, mem, x, y, i + 1, j);
        int right = dfs(grid, mem, x, y, i, j + 1);
        mem[i][j] = grid[i][j] + Math.min(down, right);
        return mem[i][j];
    }

    public int minPathSum2(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x + 1][y + 1];

        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        for (int i = x - 1; i >= 0; i--) {
            for (int j = y - 1; j >= 0; j--) {
                if (i == x - 1 && j == y - 1) {
                    dp[i][j] = grid[i][j];
                } else {
                    int down = dp[i + 1][j];
                    int right = dp[i][j + 1];
                    dp[i][j] = grid[i][j] + Math.min(down, right);
                }
            }
        }
        return dp[0][0];
    }

}
