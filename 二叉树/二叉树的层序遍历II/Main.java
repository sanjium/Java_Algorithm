package 二叉树.二叉树的层序遍历II;


import 二叉树.TreeNode;

import java.util.*;

/**
 * @description:
 * @author：三玖
 * @date: 2024/2/15
 */
public class Main {

    Queue<TreeNode> queue;
    List<List<Integer>> result;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        queue = new LinkedList<>();
        result = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                temp.add(treeNode.val);
            }
            result.add(temp);
        }

        int l = 0;
        int r = result.size() - 1;
        while (l < r) {
            List<Integer> left = result.get(l);
            List<Integer> right = result.get(r);
            List<Integer> temp = left;
            result.set(l,right);
            result.set(r,temp);
            l++;
            r--;
        }

        return result;
    }

}
