package 动态规划.解码方法;

import java.util.Arrays;

// 测试链接: https://leetcode.cn/problems/decode-ways/description/
public class Main {

//    public int numDecodings(String s) {
//        int[] mem = new int[s.length() + 1];
//        Arrays.fill(mem, -1);
//        return dfs(s, mem, 0);
//    }
//
//    public int dfs(String s, int[] mem, int i) {
//        if (i >= s.length()) {
//            return 1;
//        }
//
//        if (mem[i] != -1) {
//            return mem[i];
//        }
//
//        int result;
//        if (s.charAt(i) == '0') {
//            result = 0;
//        } else {
//            result = dfs(s, mem, i + 1);
//            if (i + 1 < s.length() && (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0' <= 26) {
//                result += dfs(s, mem, i + 2);
//            }
//        }
//        mem[i] = result;
//        return result;
//    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < s.length() && (s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0' <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

}
