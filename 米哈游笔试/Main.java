package 米哈游笔试;

import java.util.Scanner;

/**
 * @description:
 * @author：三玖
 * @date: 2024/3/17
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] masterBlood = new int[n];
            int[] curBlood = new int[n];
            int[] touchR = new int[n];
            int[] dieMaster = new int[n];

            for (int i = 0; i < n; i++) {
                masterBlood[i] = scanner.nextInt();
                curBlood[i] = masterBlood[i];
            }

            int E = scanner.nextInt();
            int R = scanner.nextInt();

            int eCount = 0;
            int rCount = 0;

            int overMaster = 0;
            while (overMaster < n) {
                int thisTouchR = 0;
                eCount++;
                for (int i = 0; i < n; i++) {
                    curBlood[i] -= E;
                    if (curBlood[i] <= 0 && dieMaster[i] == 0) {
                        overMaster++;
                        dieMaster[i] = 1;
                    }
                }
                if (overMaster == n) {
                    break;
                }
                for (int i = 0; i < n; i++) {
                    if ((double) curBlood[i] / (double) masterBlood[i] <= 0.5 && touchR[i] == 0) {
                        touchR[i] = 1;
                        thisTouchR++;
                    }
                }
                for (int i = 0; i < thisTouchR; i++) {
                    rCount++;
                    for (int j = 0; j < n; j++) {
                        curBlood[j] -= R;
                        if (curBlood[j] <= 0 && dieMaster[j] == 0) {
                            overMaster++;
                            dieMaster[j] = 1;
                        }
                    }
                    if (overMaster == n) {
                        break;
                    }
                    for (int j = 0; j < n; j++) {
                        if ((double) curBlood[j] / (double) masterBlood[j] <= 0.5 && touchR[j] == 0) {
                            touchR[j] = 1;
                            thisTouchR++;
                        }
                    }
                }
            }
            System.out.println(eCount + " " + rCount);
        }
        scanner.close();
    }
}
