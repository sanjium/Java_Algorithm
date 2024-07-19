package 美团第二次笔试;

import java.util.Scanner;

/**
 * @description:
 * @author：三玖
 * @date: 2024/3/23
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //abcccba
        int n = scanner.nextInt();
        String str = scanner.next();

        int i = 0;
        int j = 1;

        long res = 0;
        while (j < str.length()) {
            if (str.charAt(i) != str.charAt(j)) {
                res += j - i - 1;
                i = j;
            }
            j++;
        }
        System.out.println(res);
        scanner.close();
    }
}
