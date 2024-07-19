package dfs.组合;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<List<Integer>> result;

    private static List<Integer> temp;

    private static int N;

    private static int K;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        temp = new ArrayList<>();
        N = n;
        K = k;
        dfs(0, 1);
        return result;
    }

    public void dfs(int x, int start) {
        if (N - start + 1 < K - temp.size()){
            return;
        }

        if (x == K) {
            List<Integer> cur = new ArrayList<>(temp);
            result.add(cur);
            return;
        }

        for (int i = start; i <= N; i++) {
            temp.add(i);
            dfs(x + 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
