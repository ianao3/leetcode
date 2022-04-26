package tree;

/**
 * @author lc
 * @date 2022/5/5 10:54
 */
public class ConvertTree538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
