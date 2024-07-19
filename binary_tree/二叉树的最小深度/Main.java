package binary_tree.二叉树的最小深度;


import binary_tree.TreeNode;

// 111. 二叉树的最小深度: https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
public class Main {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //1. 说明为叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        //2. 如果其中一个子树没有节点，则按照有节点的子树高度
        if (root.left == null || root.right == null) {
            return leftDepth + rightDepth + 1;
        }

        //3. 如果左右子树都有节点，则选出最小的一个返回
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
