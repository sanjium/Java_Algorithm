package 二维前缀和.最大的以1为边界的正方形;

//测试链接: https://leetcode.cn/problems/largest-1-bordered-square/description/
public class Main {

    public int largest1BorderedSquare(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] += (i > 0 ? grid[i - 1][j] : 0) + (j > 0 ? grid[i][j - 1] : 0) - (i > 0 && j > 0 ? grid[i - 1][j - 1] : 0);
            }
        }

        if (sum(grid, 0, 0, grid.length - 1, grid[0].length - 1) == 0) {
            return 0;
        }

        int ans = 1;
        for (int a = 0; a < grid.length; a++) {
            for (int b = 0; b < grid[0].length; b++) {
                for (int c = a + ans, d = b + ans, k = ans + 1; c < grid.length && d < grid[0].length; c++, d++, k++) {
                    if (sum(grid, a, b, c, d) - sum(grid, a + 1, b + 1, c - 1, d - 1) == (k - 1) << 2) {
                        ans = k;
                    }
                }
            }
        }
        return ans * ans;
    }

    public int sum(int[][] g, int a, int b, int c, int d) {
        return a > c ? 0 : g[c][d] - (a > 0 ? g[a - 1][d] : 0) - (b > 0 ? g[c][b - 1] : 0) + (a > 0 && b > 0 ? g[a - 1][b - 1] : 0);
    }

}
