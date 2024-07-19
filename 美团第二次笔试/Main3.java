package 美团第二次笔试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author：三玖
 * @date: 2024/3/23
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        String colors = scanner.next();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == 'R') {
                list.add(arr[i]);
            }
        }
        int count = 0;
        Integer[] array = list.toArray(new Integer[0]);
        Arrays.sort(array);
        int temp = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == 'R') {
                if (arr[i] != array[temp]) {
                    count++;
                }
                arr[i] = array[temp];
                temp++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] < arr[i - 1]) {
                System.out.println(-1);
                return;
            }
            if (i < n - 1 && arr[i] > arr[i + 1]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count % 2 == 0 ? count / 2 : count / 2 + 1);
        scanner.close();
    }

}
