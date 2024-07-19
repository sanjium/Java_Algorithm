package 前缀树.接头密匙;

import java.util.HashMap;
import java.util.Map;

public class Main {

    class TreeNode {
        public int pass;

        public int end;

        public Map<Integer, TreeNode> next;

        public TreeNode() {
            pass = 0;
            end = 0;
            next = new HashMap<>();
        }
    }

    TreeNode root;

    public int[] countConsistentKeys(int[][] b, int[][] a) {
        // write code here
        init();
        int[] result = new int[b.length];
        StringBuilder sb = new StringBuilder();
        for (int[] ints : a) {
            sb.setLength(0);
            for (int j = 1; j < ints.length; j++) {
                sb.append(ints[j] - ints[j - 1]).append("#");
            }
            insert(sb.toString());
        }

        for (int i = 0; i < b.length; i++) {
            sb.setLength(0);
            for (int j = 1; j < b[i].length; j++) {
                sb.append(b[i][j] - b[i][j - 1]).append("#");
            }
            result[i] = count(sb.toString());
        }
        return result;
    }

    public void init() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode temp = root;
        temp.pass++;
        for (int i = 0; i < word.length(); i++) {
            Integer key = word.charAt(i) - '0';
            if (!temp.next.containsKey(key)) {
                temp.next.put(key, new TreeNode());
            }
            temp = temp.next.get(key);
            temp.pass++;
        }
        temp.end++;
    }

    public int count(String word) {
        TreeNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            Integer key = word.charAt(i) - '0';
            if (!temp.next.containsKey(key)) {
                return 0;
            }
            temp = temp.next.get(key);
        }
        return temp.pass;
    }
}
