package sort;

import java.util.Arrays;

public class Main {

    public static int[] a = new int[]{4, 3, 5, 2, 1, -2, 1, 9, 3};

    public static void main(String[] args) {
//        bubbleSort();
//        choiceSort();
        insertSort();
        System.out.println(Arrays.toString(a));
    }

    // 冒泡排序
    public static void bubbleSort() {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    // 选择排序
    public static void choiceSort() {
        for (int i = 1; i < a.length; i++) {
            int minIndex = i - 1;
            for (int j = i; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    swap(a, minIndex, j);
                }
            }
        }
    }

    // 插入排序
    public static void insertSort() {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                swap(a, j, j - 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
