package 动态规划.最大数组和;

import java.util.Arrays;

// 测试链接: https://leetcode.cn/problems/maximum-subarray/description/
public class Main {

    public int[] dp;

    public int maxSubArray(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dfs(nums, i));
        }
        return res;
    }

    public int dfs(int[] nums, int x) {
        if (x < 0) {
            return 0;
        }
        if (dp[x] != Integer.MIN_VALUE) {
            return dp[x];
        }
        return dp[x] = Math.max(nums[x], dfs(nums, x - 1) + nums[x]);
    }

    public int maxSubArray2(int[] nums) {
        dp = new int[nums.length + 1];
        dp[0] = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }


}
