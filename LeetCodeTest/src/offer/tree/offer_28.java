package offer.tree;

/**
 * @Auther: Carl
 * @Date: 2021/07/04/14:50
 * @Description: 对称的二叉树
 */
public class offer_28 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
