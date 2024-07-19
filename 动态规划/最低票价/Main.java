package 动态规划.最低票价;


import java.util.Arrays;

// 测试链接: https://leetcode.cn/problems/minimum-cost-for-tickets/description/
public class Main {

    public int[] durations = new int[]{1, 7, 30};
//    public int[] mem;
    //    public int mincostTickets(int[] days, int[] costs) {
//        mem = new int[days.length + 1];
//        Arrays.fill(mem, Integer.MAX_VALUE);
//        return dfs(days, costs, 0);
//    }
//
//    public int dfs(int[] days, int[] costs, int i) {
//        if (i == days.length) {
//            return 0;
//        }
//
//        if (mem[i] != Integer.MAX_VALUE) {
//            return mem[i];
//        }
//
//        int ans = Integer.MAX_VALUE;
//        for (int k = 0, j = i; k < 3; k++) {
//            while (j < days.length && days[j] < durations[k] + days[i]) {
//                j++;
//            }
//            ans = Math.min(ans, costs[k] + dfs(days, costs, j));
//        }
//        mem[i] = ans;
//        return ans;
//    }

    public int[] dp = new int[366];

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0, j = i; k < 3; k++) {
                while (j < n && days[j] < durations[k] + days[i]) {
                    j++;
                }
                dp[i] = Math.min(dp[i], costs[k] + dp[j]);
            }
        }
        return dp[0];
    }


}
