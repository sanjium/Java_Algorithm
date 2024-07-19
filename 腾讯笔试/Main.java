package 腾讯笔试;

import java.util.Scanner;

/**
 * @description:
 * @author：三玖
 * @date: 2024/3/31
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        long result = 0;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            result += Math.max(num, num ^ x);
        }
        System.out.println(result);
        scanner.close();
    }

}
