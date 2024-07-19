package sort.归并排序;

public class Main {

    public static int N = 50001;

    public static int[] arr;

    public static int[] temp = new int[N];

    public int[] sortArray(int[] nums) {
        arr = nums;
        mergeSort2(0, nums.length - 1);
        return arr;
    }

    //递归版
    public void mergeSort(int l, int r) {
        if (l == r) {
            return;
        }

        int m = (l + r) >> 1;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        merge(l, m, r);
    }

    // 非递归版
    public void mergeSort2(int l, int r) {
        int n = arr.length;
        for (int step = 1; step < n; step <<= 1) {
            l = 0;
            while (l < n) {
                int m = l + step - 1;
                if (m + 1 >= n) {
                    break;
                }
                r = Math.min(l + 2 * step - 1, n - 1);
                merge(l, m, r);
                l = r + 1;
            }
        }
    }

    private void merge(int l, int m, int r) {
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
    }

}
