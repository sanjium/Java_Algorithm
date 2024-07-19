package 等差数列差分.一维差分与等差数列差分;

import java.util.Scanner;

public class Main {

    public static int N = 10000005;

    public static int[] cur = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        while (m-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            int d = (e - s) / (r - l);
            // 模板
            cur[l] += s;
            cur[l + 1] += d - s;
            cur[r + 1] -= (e + d);
            cur[r + 2] += e;
        }

        for (int i = 1; i <= n; i++) {
            cur[i] += cur[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            cur[i] += cur[i - 1];
        }

        long max = 0, xor = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, cur[i]);
            xor ^= cur[i];
        }

        System.out.print(xor + " " + max);
    }
}
