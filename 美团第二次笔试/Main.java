package 美团第二次笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：三玖
 * @date: 2024/3/23
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp = scanner.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = temp.charAt(j) - '0';
            }
        }

        long res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int count0 = 0;
                int count1 = 0;
                if (arr[i][j] == 0) {
                    count0++;
                } else {
                    count1++;
                }
                if (arr[i + 1][j] == 0) {
                    count0++;
                } else {
                    count1++;
                }
                if (arr[i][j + 1] == 0) {
                    count0++;
                } else {
                    count1++;
                }
                if (arr[i + 1][j + 1] == 0) {
                    count0++;
                } else {
                    count1++;
                }
                if (count0 == count1) {
                    res++;
                }
            }
        }
        System.out.println(res);
        scanner.close();
    }

}
