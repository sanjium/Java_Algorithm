package 前缀和.区域和检索_数组不可变;

// 测试链接 : https://leetcode.cn/problems/range-sum-query-immutable/
public class NumArray {

    public int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? sums[right] : sums[right] - sums[left - 1];
    }


}
