package binary_tree.前序遍历;

import binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Main {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = root;
        stack.push(head);
        while (!stack.empty()) {
            head = stack.pop();
            result.add(head.val);
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
        return result;
    }
}
