package sort.基数排序;

import java.util.Arrays;

public class Main {

    public static int BASE = 10;
    public static int N = 50001;

    public static int n;

    public static int[] arr = new int[N];

    public static int[] help = new int[N];

    public static int[] cnts = new int[BASE];

    public static int min = 0;

    public static int max = 0;


    public int[] sortArray(int[] nums) {
        arr = nums;
        n = nums.length;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
        }

        for (int i = 0; i < n; i++) {
            arr[i] -= min;
            max = Math.max(max, arr[i]);
        }

        radixSort(bits(max));

        for (int i = 0; i < n; i++) {
            arr[i] += min;
        }
        return arr;
    }

    // 返回一个数在BASE进制下有几位
    public int bits(int x) {
        int ans = 0;
        while (x > 0) {
            ans++;
            x /= BASE;
        }
        return ans;
    }

    // 基数排序核心代码
    // bits是arr中最大值在BASE进制下有几位
    public void radixSort(int bits) {
        // 理解的时候可以假设BASE = 10
        for (int offset = 1; bits > 0; offset *= BASE, bits--) {
            Arrays.fill(cnts, 0);
            for (int i = 0; i < n; i++) {
                // 数字提取某一位的技巧
                cnts[(arr[i] / offset) % BASE]++;
            }
            // 处理成前缀次数累加的形式
            for (int i = 1; i < BASE; i++) {
                cnts[i] = cnts[i] + cnts[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                // 前缀数量分区的技巧
                // 数字提取某一位的技巧
                help[--cnts[(arr[i] / offset) % 10]] = arr[i];
            }

            for (int i = 0; i < n; i++) {
                arr[i] = help[i];
            }
        }

    }

}
