package 美团笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：三玖
 * @date: 2024/3/16
 */
public class Main4 {

    public static int[] arr;

    public static int res;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n];
        res = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            boolean[] cho = new boolean[n];
            for (int j = i; j < n; j++) {
                cho[j] = true;
                int[] temp = new int[2];
                for (int k = 0; k < cho.length; k++) {
                    if (cho[k]) {
                        temp[arr[k] - 1]++;
                    }
                }
                if (temp[0] != 0 && temp[1] != 0) {
                    res += temp[1] > temp[0] ? 2 : 1;
                } else {
                    if (temp[0] == 0 && temp[1] == 0) {
                        res = res;
                    } else {
                        res += temp[0] != 0 ? 1 : 2;
                    }
                }
            }
        }

        System.out.println(res);
        scanner.close();
    }

//    public static void dfs(int x) {
//        if (x >= arr.length) {
//            int[] temp = new int[2];
//            for (int i = 0; i < cho.length; i++) {
//                if (cho[i]) {
//                    temp[arr[i] - 1]++;
//                }
//            }
//            System.out.println(Arrays.toString(cho));
//
//            if (temp[0] != 0 && temp[1] != 0) {
//                res += temp[1] > temp[0] ? 2 : 1;
//            } else {
//                if (temp[0] == 0 && temp[1] == 0) {
//                    return;
//                } else {
//                    res += temp[0] != 0 ? 1 : 2;
//                }
//            }
//            return;
//        }
//
//        for (int i = x; i < arr.length; i++) {
//            cho[x] = true;
//            dfs(x + 1);
//            cho[x] = false;
//        }
//    }

}
