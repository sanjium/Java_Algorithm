package binary_tree.二叉树的序列化与反序列化;

import binary_tree.TreeNode;

// 297. 二叉树的序列化与反序列化: https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
public class Codec {

    private static int cnt;

    // 序列化
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        s(root, builder);
        return builder.toString();
    }

    public void s(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#,");
            return;
        }
        builder.append(root.val).append(",");
        s(root.left, builder);
        s(root.right, builder);
    }


    // 反序列化
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        cnt = 0;
        return d(arr);
    }

    private TreeNode d(String[] arr) {
        String cur = arr[cnt++];
        if (cur.equals("#")) {
            return null;
        }

        TreeNode treeNode = new TreeNode();
        treeNode.val = Integer.parseInt(cur);
        treeNode.left = d(arr);
        treeNode.right = d(arr);
        return treeNode;
    }

}
