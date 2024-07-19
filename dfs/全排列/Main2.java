package dfs.全排列;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    private static List<List<Integer>> result;

    private static int[] arr;

    private static int[] cur;

    //0. 还没走到过 //1. 选 //2.不选
    private static int[] cho;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        arr = nums;
        cur = new int[arr.length];
        cho = new int[arr.length];
        dfs(0);
        return result;
    }

    public void dfs(int x) {
        if (x == arr.length) {
            List<Integer> ans = new ArrayList<>();
            for (int i : cur) {
                ans.add(i);
            }
            result.add(ans);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (cho[i] != 1) {
                cho[i] = 1;
                cur[x] = arr[i];
                dfs(x + 1);
                // 恢复现场
                cho[i] = 2;
                cur[x] = 0;
            }
        }
    }
}
