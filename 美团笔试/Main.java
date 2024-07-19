package 美团笔试;

import java.util.Scanner;

/**
 * @description:
 * @author：三玖
 * @date: 2024/3/16
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long result = 0;
        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt();
            result += price;
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        result -= (x + y);
        System.out.println(result);

        scanner.close();
    }

}
