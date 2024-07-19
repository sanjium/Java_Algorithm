package dfs.n皇后;

public class Main {

    public static int N;

    public static int[] path;

    public int totalNQueens(int n) {
        N = n;
        path = new int[N];
        return dfs(0);
    }

    public int dfs(int i) {
        if (N == i) {
            return 1;
        }

        int ans = 0;
        for (int j = 0; j < N; j++) {
            if (check(i, j)) {
                path[i] = j;
                ans += dfs(i + 1);
            }
        }

        return ans;
    }

    public boolean check(int i, int j) {
        for (int k = 0; k < i; k++) {
            if (path[k] == j || Math.abs(i - k) == Math.abs(j - path[k])) {
                return false;
            }
        }
        return true;
    }
}
