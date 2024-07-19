package 双指针.接雨水;

// 测试链接: https://leetcode.cn/problems/trapping-rain-water/description/
public class Main {

    public int trap(int[] height) {
        int n = height.length;
        int ans = 0, lMax = height[0], rMax = height[n - 1], l = 1, r = n - 2;
        while (l <= r) {
            if (lMax <= rMax) {
                ans += Math.max(0, lMax - height[l]);
                lMax = Math.max(lMax, height[l++]);
            } else {
                ans += Math.max(0, rMax - height[r]);
                rMax = Math.max(rMax, height[r--]);
            }
        }
        return ans;
    }
}
