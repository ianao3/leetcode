package tree;

import java.util.ArrayDeque;

/**
 * 翻转二叉树
 *
 * @author lc
 * @date 2022/4/26 19:15
 */
public class InvertTree226 {
    /**
     * 深度优先搜索
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    /**
     * 非递归
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeByBFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        //遍历树
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.poll();
            TreeNode invertTreeNode = invertTreeNode(node);
            if (invertTreeNode.left != null) {
                treeNodes.offer(invertTreeNode.left);
            }

            if (invertTreeNode.right != null) {
                treeNodes.offer(invertTreeNode.right);
            }
        }
        return root;
    }

    private TreeNode invertTreeNode(TreeNode node) {
        if (node.left != null || node.right != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return node;
    }

}

