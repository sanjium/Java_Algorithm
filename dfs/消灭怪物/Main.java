package dfs.消灭怪物;

import java.util.Scanner;

/**
 * @description:
 * @author：三玖
 * @date: 2024/2/8
 */
public class Main {

    public static int[] kill;

    public static int[] blood;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while (N-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            kill = new int[n];
            blood = new int[n];
            boolean[] cho = new boolean[n];
            for (int i = 0; i < n; i++) {
                kill[i] = scanner.nextInt();
                blood[i] = scanner.nextInt();
            }
            int count = dfs(n, m, 0, m, cho);
            if (count == Integer.MAX_VALUE){
                count = -1;
            }
            System.out.println(count);
        }
    }

    public static int dfs(int n, int m, int i, int r, boolean[] cho) {
        if (r <= 0) {
            return i;
        }

        if (i >= n) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            if (!cho[k]) {
                cho[k] = true;
                min = Math.min(min, dfs(n, m, i + 1, r - (r <= blood[k] ? kill[k] * 2 : kill[k]), cho));
                cho[k] = false;
            }
        }
        return min;
    }

}
