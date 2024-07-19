package 美团笔试;

import java.util.Scanner;

/**
 * @description:
 * @author：三玖
 * @date: 2024/3/16
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.next();
        int result = Integer.MAX_VALUE;

        // 1. 改成全部是小写
        int x = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                x++;
            }
        }
        result = Math.min(result, x);
        // 2. 所有字母都是大写
        x = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                x++;
            }
        }
        result = Math.min(result, x);
        // 3. 开头大写，其他小写
        x = 0;
        if (Character.isLowerCase(word.charAt(0))) {
            x++;
        }
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                x++;
            }
        }
        result = Math.min(result, x);
        System.out.println(result);
        scanner.close();
    }
}
