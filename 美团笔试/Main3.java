package 美团笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：三玖
 * @date: 2024/3/16
 */
public class Main3 {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int q = scanner.nextInt();
//        long[] arr = new long[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        while (q-- > 0) {
//            int element = scanner.nextInt();
//            for (int i = 0; i < n; i++) {
//                if (i == element - 1) {
//                    continue;
//                }
//                arr[i] *= 2;
//            }
//            System.out.println(Arrays.toString(arr));
//        }
//        long result = 0;
//        for (int i = 0; i < n; i++) {
//            result += arr[i];
//        }
//        System.out.println(result % (1000000007));
//        scanner.close();
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int k = q;
        long[] arr = new long[n];
        int[] cho = new int[100010];
        long bigResult = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            bigResult += arr[i];
        }

        while (q-- > 0) {
            int element = scanner.nextInt();
            cho[element - 1]++;
            bigResult *= 2;
        }

        for (int i = 0; i < n; i++) {
            long bigResultI = arr[i] * 2 * k;
            long realResult = arr[i] * 2 * (k - cho[i]);
            bigResult -= (bigResultI - realResult);
        }
        System.out.println(bigResult % (1000000007));

        scanner.close();
    }


}
