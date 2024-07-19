package sort.归并分治;

import java.util.Scanner;

// 计算数组的小和,测试链接:https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {

    private static final int N = 100001;

    private static final int[] arr = new int[N];

    private static final int[] temp = new int[N];

    private static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        long result = mergeSort(0, n - 1);
        System.out.println(result);
    }

    private static long mergeSort(int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) >> 1;
        return mergeSort(l, m) + mergeSort(m + 1, r) + merge(l, m, r);
    }

    private static long merge(int l, int m, int r) {
        long ans = 0;
        for (int i = l, j = m + 1, sum = 0; j <= r; j++) {
            while (i <= m && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
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