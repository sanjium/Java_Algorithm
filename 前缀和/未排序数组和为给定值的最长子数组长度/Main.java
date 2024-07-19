package 前缀和.未排序数组和为给定值的最长子数组长度;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//测试连接: https://www.nowcoder.com/practice/36fb0fd3c656480c92b569258a1223d5
public class Main {

    public static int[] arr;

    public static int N;

    public static int aim;

    public static Map<Integer, Integer> map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        aim = scanner.nextInt();
        arr = new int[N];
        map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (map.containsKey(sum - aim)) {
                result = Math.max(result, i - map.get(sum - aim));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        System.out.println(result);
    }
}
