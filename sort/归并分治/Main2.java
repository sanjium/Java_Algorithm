package sort.归并分治;


public class Main2 {

    private static final int N = 50001;

    private static int[] arr;

    private static final int[] temp = new int[N];

    public int reversePairs(int[] nums) {
        arr = nums;
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) >> 1;
        return mergeSort(l, m) + mergeSort(m + 1, r) + merge(l, m, r);
    }

    private int merge(int l, int m, int r) {
        int ans = 0;

        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r && (long) arr[i] > (long) arr[j] * 2) {
                j++;
            }
            ans += j - m - 1;
        }

        int i = l;
        int a = l;
        int b = m + 1;

        while (a <= m && b <= r) {
            temp[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }

        while (a <= m) {
            temp[i++] = arr[a++];
        }

        while (b <= r) {
            temp[i++] = arr[b++];
        }

        for (i = l; i <= r; i++) {
            arr[i] = temp[i];
        }
        return ans;
    }

}
