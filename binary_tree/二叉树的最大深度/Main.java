package binary_tree.二叉树的最大深度;

import binary_tree.TreeNode;

//104. 二叉树的最大深度:https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
public class Main {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
