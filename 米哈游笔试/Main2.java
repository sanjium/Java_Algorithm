package 米哈游笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：三玖
 * @date: 2024/3/17
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arrX = new int[n];
        int[] arrY = new int[m];
        for (int i = 0; i < n; i++) {
            arrX[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arrY[i] = scanner.nextInt();
        }
        Arrays.sort(arrX);
        Arrays.sort(arrY);

        int result = 0;
        for (int i = 0; i < n; i++) {
            int x1 = arrX[i];
            for (int j = 0; j < n; j++) {
                int y1 = arrY[j];

                int k1 = i;
                for (int x2 = 0; x2 <= x1; k1++) {
                    if (k1 >= n) {
                        break;
                    }
                    x2 = arrX[k1];
                    if (x2 > x1) {
                        break;
                    }
                }
                int k2 = j;
                for (int y2 = 0; y2 <= y1; k2++) {
                    if (k2 >= m) {
                        break;
                    }
                    y2 = arrY[k2];
                    if (y2 > y1) {
                        break;
                    }
                }
                result += k1 * k2;
            }
        }
        System.out.println(result);
        scanner.close();
    }

}
