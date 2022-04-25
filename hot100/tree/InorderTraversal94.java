package tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> treeNodes = new ArrayDeque<>();
        LinkedList<Integer> res = new LinkedList<>();
        while (root != null || !treeNodes.isEmpty()){
            while (root != null){
                treeNodes.push(root);
                root = root.left;
            }
            root = treeNodes.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
