package sort.随机快速排序;

public class Main {

    public static int[] arr;

    public static int mLeft;

    public static int mRight;

    public int[] sortArray(int[] nums) {
        arr = nums;
        quickSort(0, nums.length - 1);
        return arr;
    }

    public void quickSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[(int) (l + Math.random() * (r - l + 1))];
        partition(l, r, x);
        int left = mLeft;
        int right = mRight;
        quickSort(l, left - 1);
        quickSort(right + 1, r);
    }

    private void partition(int l, int r, int x) {
        int a = l, b = r, i = l;

        while (i <= b) {
            if (arr[i] < x) {
                swap(i++, a++);
            } else if (arr[i] == x) {
                i++;
            } else {
                swap(i, b--);
            }
        }
        mLeft = a;
        mRight = b;
    }

    private void swap(int a, int b) {
        int swap = arr[a];
        arr[a] = arr[b];
        arr[b] = swap;
    }


}
