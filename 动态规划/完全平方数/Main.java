package 动态规划.完全平方数;

import java.util.Arrays;

// 测试链接: https://leetcode.cn/problems/perfect-squares/solutions/1987533/by-lotus-5n-350e/?envType=study-plan-v2&envId=top-100-liked
public class Main {

    public int numSquares(int n) {
        return dfs(n);
    }

    public int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MAX_VALUE;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            res = Math.min(res, dfs(n - i * i) + 1);
        }
        return res;
    }


}
