package 二维动态规划.单词搜索;

import java.util.Arrays;

public class Main {

    public int[] fx = new int[]{1, 0, -1, 0};
    public int[] fy = new int[]{0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int x, int y, int k) {
        if (k >= word.length()) {
            return true;
        }

        if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || board[x][y] != word.charAt(k)) {
            return false;
        }

        char temp = board[x][y];
        board[x][y] = '0';

        boolean ans = false;
        for (int i = 0; i < 4; i++) {
            ans |= dfs(board, word, x + fx[i], y + fy[i], k + 1);
        }
        board[x][y] = temp;
        return ans;
    }

}
