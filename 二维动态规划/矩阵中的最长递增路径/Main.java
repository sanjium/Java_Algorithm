package 二维动态规划.矩阵中的最长递增路径;

import java.util.Arrays;

// 测试链接: https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/description/
public class Main {

    public int[][] mem;

    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        mem = new int[n + 1][m + 1];
        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(result, dfs(matrix, n, m, i, j));
            }
        }
        return result;
    }

    public int dfs(int[][] matrix, int n, int m, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }

        if (mem[i][j] != -1) {
            return mem[i][j];
        }

        int result = 1;
        int temp = matrix[i][j];
        matrix[i][j] = -1;
        if (i > 0) {
            result = Math.max(result, (matrix[i - 1][j] > temp ? dfs(matrix, n, m, i - 1, j) + 1 : 0));
        }
        if (j < m - 1) {
            result = Math.max(result, (matrix[i][j + 1] > temp ? dfs(matrix, n, m, i, j + 1) + 1 : 0));
        }
        if (i < n - 1) {
            result = Math.max(result, (matrix[i + 1][j] > temp ? dfs(matrix, n, m, i + 1, j) + 1 : 0));
        }
        if (j > 0) {
            result = Math.max(result, (matrix[i][j - 1] > temp ? dfs(matrix, n, m, i, j - 1) + 1 : 0));
        }
        matrix[i][j] = temp;
        mem[i][j] = result;
        return result;
    }

}
