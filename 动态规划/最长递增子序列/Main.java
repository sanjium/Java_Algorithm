package 动态规划.最长递增子序列;

// 测试链接: https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-100-liked
public class Main {

    public static int[] mem;

    public int lengthOfLIS(int[] nums) {
        int res = 0;
        mem = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dfs(nums, i) + 1);
        }
        return res;
    }

    public int dfs(int[] nums, int x) {
        if (mem[x] != 0) {
            return mem[x];
        }
        int res = 0;
        for (int i = 0; i < x; i++) {
            if (nums[i] < nums[x]) {
                res = Math.max(res, dfs(nums, i) + 1);
            }
        }
        mem[x] = res;
        return res;
    }

}
