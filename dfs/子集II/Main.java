package dfs.子集II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90. 子集II: https://leetcode.cn/problems/subsets-ii/description/
public class Main {

    private static List<List<Integer>> result;

    private static int[] arr;

    private static List<Integer> path;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        arr = nums;
        dfs(0);
        return result;
    }

    public void dfs(int i) {
        if (i == arr.length) {
            List<Integer> cur = new ArrayList<>(path);
            result.add(cur);
            return;
        }

        int j = i + 1;
        while (j < arr.length && arr[i] == arr[j]) {
            j++;
        }
        // 不选当前数
        dfs(j);
        // 选当前数,有可能为多个
        for (int u = i; u < j; u++) {
            path.add(arr[u]);
            dfs(j);
        }
        // 回溯之前的选择
        for (int u = i; u < j; u++) {
            path.remove(path.size() - 1);
        }
    }
}
