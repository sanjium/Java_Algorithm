package binary_tree.二叉树的序列化与反序列化_按层序列;

import binary_tree.TreeNode;

public class Codec {

    private static int N = 10001;

    private static TreeNode[] queue = new TreeNode[N];

    int l, r;


    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root != null) {
            l = 0;
            r = 0;
            queue[r++] = root;
            builder.append(root.val).append(",");
            while (l < r) {
                TreeNode treeNode = queue[l++];
                if (treeNode.left != null) {
                    queue[r++] = treeNode.left;
                    builder.append(treeNode.left.val).append(",");
                } else {
                    builder.append("#,");
                }
                if (treeNode.right != null) {
                    queue[r++] = treeNode.right;
                    builder.append(treeNode.right.val).append(",");
                } else {
                    builder.append("#,");
                }
            }
        }
        return builder.toString();
    }


    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(",");
        int index = 0;
        l = 0;
        r = 0;
        TreeNode head = generate(arr, index++);
        queue[r++] = head;
        while (l < r) {
            TreeNode treeNode = queue[l++];
            treeNode.left = generate(arr, index++);
            treeNode.right = generate(arr, index++);
            if (treeNode.left != null) {
                queue[r++] = treeNode.left;
            }
            if (treeNode.right != null) {
                queue[r++] = treeNode.right;
            }
        }
        return head;
    }

    private TreeNode generate(String[] arr, int index) {
        return arr[index].equals("#") ? null : new TreeNode(Integer.parseInt(arr[index]));
    }
}