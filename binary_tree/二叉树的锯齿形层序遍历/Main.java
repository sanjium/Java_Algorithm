package binary_tree.二叉树的锯齿形层序遍历;

import binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

//103. 二叉树的锯齿形层序遍历: https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
public class Main {

    private static int N = 2001;

    private static TreeNode[] queue = new TreeNode[N];

    private static int l, r;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        l = 0;
        r = 0;
        queue[r++] = root;
        boolean isReverse = false;
        while (l < r) {
            int size = r - l;
            List<Integer> temp = new ArrayList<>();
            if (isReverse) {
                for (int i = r - 1, k = 0; k < size; i--, k++) {
                    TreeNode treeNode = queue[i];
                    temp.add(treeNode.val);
                }
            } else {
                for (int i = 0, j = l; i < size; i++) {
                    TreeNode treeNode = queue[j++];
                    temp.add(treeNode.val);
                }
            }

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue[l++];
                if (treeNode.left != null) {
                    queue[r++] = treeNode.left;
                }
                if (treeNode.right != null) {
                    queue[r++] = treeNode.right;
                }
            }
            ans.add(temp);
            isReverse = !isReverse;
        }

        return ans;
    }

}
