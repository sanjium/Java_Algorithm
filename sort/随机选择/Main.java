package sort.随机选择;

public class Main {

    public static int left;

    public static int right;

    public int findKthLargest(int[] nums, int k) {
        return randomSelect(nums, nums.length - k);
    }

    private int randomSelect(int[] nums, int i) {

        int ans = 0;

        for (int l = 0, r = nums.length - 1; l <= r; ) {
            partition(nums, l, r, nums[l + (int) (Math.random() * (r - l + 1))]);

            if (i < left) {
                r = left - 1;
            } else if (i > right) {
                l = right + 1;
            } else {
               ans = nums[i];
               break;
            }

        }
        return ans;
    }

    private void partition(int[] nums, int l, int r, int i) {
        int a = l;
        int b = r;
        int temp = l;

        while (temp <= b) {
            if (nums[temp] < i) {
                swap(nums, temp++, a++);
            } else if (nums[temp] == i) {
                temp++;
            } else {
                swap(nums, temp, b--);
            }
        }

        left = a;
        right = b;
    }

    private void swap(int[] nums, int temp, int i) {
        int a = nums[temp];
        nums[temp] = nums[i];
        nums[i] = a;
    }


}
