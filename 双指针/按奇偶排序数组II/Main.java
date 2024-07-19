package 双指针.按奇偶排序数组II;

// 测试链接 : https://leetcode.cn/problems/sort-array-by-parity-ii/
public class Main {

    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        for (int even = 0, odd = 1; odd < n && even < n; ) {
            if (nums[n - 1] % 2 == 0) {
                swap(nums, n - 1, even);
                even += 2;
            } else {
                swap(nums, n - 1, odd);
                odd += 2;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
