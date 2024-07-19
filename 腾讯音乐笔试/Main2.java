package 腾讯音乐笔试;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author：三玖
 * @date: 2024/4/18
 */


public class Main2 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //1  1
    //2. 2 1 1
    //3. 4 2 2 1 1 1 1
    // 4. 8
    // 4.   4.
    // 2. 2. 2. 2.
    //
    public TreeNode create(int n) { //3.
        TreeNode[] queue = new TreeNode[16385];
        int head = 0;
        int tail = 0;
        int size = 1;
        int currentCount = 1;
        int count = (int) Math.pow(2, n - 1); //4.
        int maxCount = count; //4.
        TreeNode treeNode = new TreeNode(count);
        queue[head++] = treeNode;
        while (currentCount < maxCount) {
            currentCount *= 2; //2.
            count /= 2; // 2.
            for (int i = 0; i < size; i++){
                TreeNode poll = queue[tail++];
                TreeNode newLeft = new TreeNode(count);
                TreeNode newRight = new TreeNode(count);
                poll.left = newLeft;
                poll.right = newRight;
                queue[head++] = newLeft;
                queue[head++] = newRight;
            }
            size *=2;
        }
        return treeNode;
    }
    // 2,2

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        TreeNode treeNode = main2.create(3);
        System.out.println(treeNode);
    }
}
