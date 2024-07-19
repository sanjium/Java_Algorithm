package 腾讯云智;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author：三玖
 * @date: 2024/3/25
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 1, 2, 1};

        int[] count = new int[nums.length + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            if (count[nums[i]] == 2) {
                list.add(nums[i]);
            }
        }
        System.out.println(list);
    }

}
