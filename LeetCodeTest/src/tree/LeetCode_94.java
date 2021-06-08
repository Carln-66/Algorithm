package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/06/08/17:39
 * @Description: 二叉树中序遍历
 */
public class LeetCode_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode cur, List<Integer> res) {
        if (cur == null) return;
        inorder(cur.left, res);
        res.add(cur.val);
        inorder(cur.right, res);
    }
}
