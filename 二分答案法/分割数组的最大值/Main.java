package 二分答案法.分割数组的最大值;

// 测试连接: https://leetcode.cn/problems/split-array-largest-sum/
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{7, 2, 5, 10, 8};
        System.out.println(main.splitArray(nums, 2));
    }

    public int splitArray(int[] nums, int k) {
        int l = -1;
        int r = 0;
        for (int num : nums) {
            r += num;
        }
        r += 1;

        int ans = 0;
        int m;
        while (l + 1 != r) {
            m = l + ((r - l) >> 1);
            // > k
            if (isBlue(nums, m, k)) {
                l = m;
                // <= k
            } else {
                r = m;
                ans = m;
            }
        }
        return ans;
    }

    public boolean isBlue(int[] nums, int maxSum, int people) {
        int part = 1;
        int sum = 0;
        for (int num : nums) {
            if (num > maxSum) {
                return true;
            }
            if (sum + num > maxSum) {
                part++;
                sum = num;
            } else {
                sum += num;
            }
        }

        return part > people;
    }

}
