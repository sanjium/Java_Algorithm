package 滑动窗口.长度最小的子数组;

public class Main {

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;

        for (int l = 0, r = 0, sum = 0; r < nums.length; r++) {
            sum += nums[r];

            while (sum - nums[l] >= target) {
                sum -= nums[l++];
            }

            if (sum >= target) {
                result = Math.min(result, r - l + 1);
            }

        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
