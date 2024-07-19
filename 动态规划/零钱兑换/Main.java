package 动态规划.零钱兑换;

import java.util.Arrays;

// 测试链接: https://leetcode.cn/problems/coin-change/description/?envType=study-plan-v2&envId=top-100-liked
public class Main {

    public int coinChange(int[] coins, int amount) {
        int res = dfs(coins, amount);
        return res > 10000 ? -1 : res;
    }

    public int dfs(int[] coins, int amount) {
        if (amount < 0) {
            return 0x3f3f3f;
        }

        if (amount == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            result = Math.min(dfs(coins, amount - coin) + 1, result);
        }
        return result;
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,0x3f3f3f);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > 10000 ? -1 : dp[amount];
    }

}
