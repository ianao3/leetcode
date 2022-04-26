package tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树最大深度
 *
 * @author lc
 * @date 2022/4/26 16:28
 */
public class MaxDepth104 {
    /**
     * 深度优先递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public int maxDepthByBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.offer(root);
        int ans = 0;
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            while (size > 0) {
                TreeNode node = treeNodes.poll();
                if (node.left != null) {
                    treeNodes.offer(node.left);
                }
                if (node.right != null) {
                    treeNodes.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
