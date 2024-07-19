package heap.线段重合;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

// 线段重合: https://www.nowcoder.com/practice/1ae8d0b6bb4e4bcdbf64ec491f63fc37
public class Main {

    public static int N = 10001;

    public static int[][] arr = new int[N][2];

    public static int[] heap = new int[N];

    public static int size;

    public static int n;

    public static void add(int x) {
        heap[size] = x;
        int i = size++;

        while (heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    //TODO int best = l + 1 < size && heap[l] <= heap[l + 1] ? l : l + 1;
    //     int best = l + 1 < size && heap[l + 1] < heap[l] ? l + 1 : l;

    public static void pop() {
        swap(0, --size);
        int i = 0;
        int l = 1;
        while (l < size) {
            int best = l + 1 < size && heap[l] < heap[l + 1] ? l : l + 1;
            best = heap[i] < heap[best] ? i : best;
            if (best == i) {
                return;
            }
            swap(i, best);
            i = best;
            l = i * 2 + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        // 堆的清空
        size = 0;

        Arrays.sort(arr, 0, n, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (size > 0 && heap[0] <= arr[i][0]) {
                pop();
            }
            add(arr[i][1]);
            ans = Math.max(ans, size);
        }
        System.out.println(ans);

    }

    public static void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

}
