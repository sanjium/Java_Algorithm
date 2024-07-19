package dfs.全排列;

import java.util.ArrayList;
import java.util.List;

//46.全排列: https://leetcode.cn/problems/permutations/
public class Main {

    private static List<List<Integer>> result;

    private static int[] arr;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        arr = nums;
        dfs(0);
        return result;
    }

    public void dfs(int x) {
        if (x == arr.length) {
            List<Integer> cur = new ArrayList<>();
            for (int i : arr) {
                cur.add(i);
            }
            result.add(cur);
            return;
        }

        for (int i = x; i < arr.length; i++) {
            swap(arr, i, x);
            dfs(x + 1);
            swap(arr, i, x);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
