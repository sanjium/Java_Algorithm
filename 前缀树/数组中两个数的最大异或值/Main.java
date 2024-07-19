package 前缀树.数组中两个数的最大异或值;

public class Main {

    public static int MAXN = 3000001;

    public static int[][] tree = new int[MAXN][2];

    public static int cnt;

    int high;


    public int findMaximumXOR(int[] nums) {
        init(nums);
        int result = 0;
        for (int num : nums) {
            result = Math.max(result, maxXor(num));
        }
        clear();
        return result;
    }


    public void init(int[] nums) {
        cnt = 1;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        high = 31 - Integer.numberOfLeadingZeros(max);

        for (int num : nums) {
            insert(num);
        }
    }

    private void insert(int num) {
        int cur = 1;
        for (int i = high; i >= 0; i--) {
            int key = (num >> i) & 1;
            if (tree[cur][key] == 0) {
                tree[cur][key] = ++cnt;
            }
            cur = tree[cur][key];
        }
    }

    private int maxXor(int num) {
        int result = 0;
        int cur = 1;

        for (int i = high; i >= 0; i--) {
            int key = (num >> i) & 1;
            int want = key ^ 1;
            if (tree[cur][want] == 0) {
                want ^= 1;
            }
            result |= (key ^ want) << i;
            cur = tree[cur][want];
        }
        return result;
    }

    public static void clear() {
        for (int i = 1; i <= cnt; i++) {
            tree[i][0] = tree[i][1] = 0;
        }
    }

}
