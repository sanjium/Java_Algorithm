package dfs.子集;

import java.util.ArrayList;
import java.util.List;

// LCR 079.子集: https://leetcode.cn/problems/TVdhkn/description/
public class Main {

    private static List<List<Integer>> result;

    private static List<Integer> temp;

    private static int[] arr;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        temp = new ArrayList<>();
        arr = nums;
        dfs(0);
        return result;
    }

    public void dfs(int x) {
        if (x == arr.length) {
            List<Integer> cur = new ArrayList<>(temp);
            result.add(cur);
            return;
        }

        // 不选
        dfs(x + 1);
        // 选
        temp.add(arr[x]);
        dfs(x + 1);
        temp.remove(temp.size() - 1);
    }
}
