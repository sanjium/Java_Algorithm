package sort.堆排序;

// 912. 排序数组: https://leetcode.cn/problems/sort-an-array/
public class Main {

    public static int[] arr;

    public int[] sortArray(int[] nums) {
        arr = nums;
        heapSort();
        return arr;
    }

    private void heapSort() {
        int size = arr.length;
        // 满足大根堆
        for (int i = 0; i < size; i++) {
            heapInsert(i);
        }
        // 排序
        while (size > 1) {
            // 先将第一位和最后一位交换，那么最后一位的数字就确定了
            swap(0, --size);
            // 重新往下满足大根堆
            heapify(0, size);
        }
    }

    private void heapify(int i, int size) {
        int l = i * 2 + 1;
        while (l < size) {
            int best = l + 1 < size && arr[l] < arr[l + 1] ? l + 1 : l;
            best = arr[i] < arr[best] ? best : i;
            if (best == i) {
                break;
            }
            swap(i,best);
            i = best;
            l = i * 2 + 1;
        }
    }

    private void heapInsert(int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
