package binary_tree.二叉树最大宽度;


import binary_tree.TreeNode;

// 662. 二叉树最大宽度: https://leetcode.cn/problems/maximum-width-of-binary-tree/description/
public class Main {

    private static final int N = 3001;

    private static final TreeNode[] nq = new TreeNode[N];

    private static final int[] iq = new int[N];

    private static int l;

    private static int r;

    public int widthOfBinaryTree(TreeNode root) {
        l = 0;
        r = 0;
        nq[r] = root;
        iq[r++] = 1;

        int max = 0;
        while (l < r) {
            int size = r - l;
            max = Math.max(max, iq[r - 1] - iq[l] + 1);

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = nq[l];
                int id = iq[l++];

                if (treeNode.left != null) {
                    nq[r] = treeNode.left;
                    iq[r++] = id * 2;
                }

                if (treeNode.right != null) {
                    nq[r] = treeNode.right;
                    iq[r++] = id * 2 + 1;
                }
            }
        }
        return max;
    }
}
