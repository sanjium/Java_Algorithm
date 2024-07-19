package 动态规划.解码方法II;

import java.util.Arrays;

//测试链接: https://leetcode.cn/problems/decode-ways-ii/description/
public class Main {

    public static int mod = 1000000007;

//    public static long[] mem;
//
//    public int numDecodings(String s) {
//        mem = new long[s.length() + 1];
//        Arrays.fill(mem, -1);
//        return (int) dfs(s, 0);
//    }
//
//    public long dfs(String s, int i) {
//        if (i >= s.length()) {
//            return 1;
//        }
//        if (s.charAt(i) == '0') {
//            return 0;
//        }
//        if (mem[i] != -1) {
//            return mem[i];
//        }
//        long ans = dfs(s, i + 1) * (s.charAt(i) == '*' ? 9 : 1);
//        if (i + 1 < s.length()) {
//            if (s.charAt(i) != '*') {
//                if (s.charAt(i + 1) != '*') {
//                    if ((s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0' <= 26) {
//                        ans += dfs(s, i + 2);
//                    }
//                } else {
//                    if (s.charAt(i) == '1') {
//                        ans += dfs(s, i + 2) * 9;
//                    }
//                    if (s.charAt(i) == '2') {
//                        ans += dfs(s, i + 2) * 6;
//                    }
//                }
//            } else {
//                if (s.charAt(i + 1) != '*') {
//                    if (s.charAt(i + 1) <= '6') {
//                        ans += dfs(s, i + 2) * 2;
//                    } else {
//                        ans += dfs(s, i + 2);
//                    }
//                } else {
//                    ans += dfs(s, i + 2) * 15;
//                }
//            }
//        }
//        ans %= mod;
//        mem[i] = ans;
//        return ans;
//    }


    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            }else{
                dp[i] = dp[i + 1] * (s.charAt(i) == '*' ? 9 : 1);
                if (i + 1 < s.length()) {
                    if (s.charAt(i) != '*') {
                        if (s.charAt(i + 1) != '*') {
                            if ((s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0' <= 26) {
                                dp[i] += dp[i + 2];
                            }
                        } else {
                            if (s.charAt(i) == '1') {
                                dp[i] += dp[i + 2] * 9;
                            }
                            if (s.charAt(i) == '2') {
                                dp[i] += dp[i + 2] * 6;
                            }
                        }
                    } else {
                        if (s.charAt(i + 1) != '*') {
                            if (s.charAt(i + 1) <= '6') {
                                dp[i] += dp[i + 2] * 2;
                            } else {
                                dp[i] += dp[i + 2];
                            }
                        } else {
                            dp[i] += dp[i + 2] * 15;
                        }
                    }
                }
                dp[i] %= mod;
            }
        }
        return (int) dp[0];
    }

}
