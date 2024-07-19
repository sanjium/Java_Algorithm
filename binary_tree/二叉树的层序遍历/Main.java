package binary_tree.二叉树的层序遍历;

import binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

//102. 二叉树的层序遍历: https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
public class Main {

    private static final int N = 2001;
    private static TreeNode[] queue = new TreeNode[N];
    private static int l, r;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        // 如果没有头节点,则直接返回
        if (root == null) {
            return ans;
        }
        l = 0;
        r = 0;
        queue[r++] = root;
        while (l < r) {
            int size = r - l;
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue[l++];
                if (treeNode.left != null) {
                    queue[r++] = treeNode.left;
                }
                if (treeNode.right != null) {
                    queue[r++] = treeNode.right;
                }
                temp.add(treeNode.val);
            }
            ans.add(temp);
        }
        return ans;
    }

}
