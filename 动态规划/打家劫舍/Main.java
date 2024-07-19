package 动态规划.打家劫舍;

import java.util.Arrays;

// 测试链接: https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-100-liked
public class Main {

    public int[] mem;

    public int rob(int[] nums) {
        int n = nums.length;
        mem = new int[n];
        Arrays.fill(mem, -1);
        return dfs(nums, n - 1);
    }

    public int dfs(int[] nums, int x) {
        if (x < 0) {
            return 0;
        }

        if (mem[x] != -1) {
            return mem[x];
        }

        return mem[x] = Math.max(dfs(nums, x - 2) + nums[x], dfs(nums, x - 1));
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = 0; i < n; i++) {
            dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]);
        }
        return dp[n + 1];
    }

}
