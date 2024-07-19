package dfs.全排列;

import java.util.ArrayList;
import java.util.List;

public class Exercise {

    private static List<List<Integer>> result;

    private static int[] arr;

    private static int[] temp;

    private static boolean[] cho;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        arr = nums;
        temp = new int[arr.length];
        cho = new boolean[arr.length];
        dfs(0);
        return result;
    }

    public void dfs(int x) {
        if (x == arr.length) {
            List<Integer> cur = new ArrayList<>();
            for (int i : temp) {
                cur.add(i);
            }
            result.add(cur);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!cho[i]) {
                cho[i] = true;
                temp[x] = arr[i];
                dfs(x + 1);
                cho[i] = false;
                temp[x] = 0;
            }
        }
    }
}
