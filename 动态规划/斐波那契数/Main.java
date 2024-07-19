package 动态规划.斐波那契数;

// 测试链接: https://leetcode.cn/problems/fibonacci-number/description/
public class Main {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
