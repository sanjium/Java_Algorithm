package 动态规划.爬楼梯;

import java.util.Arrays;

// 测试链接: https://leetcode.cn/problems/climbing-stairs/?envType=study-plan-v2&envId=top-100-liked
public class Main {

    public int[] mem;

    public int climbStairs(int n) {
        mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return dfs(n);
    }

    public int dfs(int i) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        if (mem[i] != -1) {
            return mem[i];
        }
        return mem[i] = dfs(i - 1) + dfs(i - 2);
    }

    public int climbStairs2(int n) {
        mem = new int[n + 1];
        mem[0] = 1;
        mem[1] = 1;
        for (int i = 2; i <= n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return dfs(n);
    }

}

