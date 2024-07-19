package binary_search;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 6};
        System.out.println(findLeft(arr, 3));
        System.out.println(findRight(arr, 3));
    }

    public static boolean exists(int[] arr, int num) {
        int l = 0;
        int r = arr.length - 1;
        int m;

        while (l <= r) {
            m = (l + r) >> 1;
            if (arr[m] == num) {
                return true;
            } else if (arr[m] > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;

    }

    public static int findLeft(int[] arr, int num)  {
        int l = -1;
        int r = arr.length;
        int m;
        while (l + 1 != r) {
            m = l + ((r - l) >> 1);
            if (arr[m] < num) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }

    public static int findRight(int[] arr, int num) {
        int l = -1;
        int r = arr.length;
        int m;
        while (l + 1 != r) {
            m = l + ((r - l) >> 1);
            if (arr[m] <= num) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l + 1 < r) {
            m = l + ((r - l) >> 1);
            if (isBlue(nums, m)) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }

    private boolean isBlue(int[] nums, int m) {
        return nums[m] < nums[m + 1];
    }


}
