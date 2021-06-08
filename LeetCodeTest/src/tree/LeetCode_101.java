package tree;

/**
 * @Auther: Carl
 * @Date: 2021/06/08/17:52
 * @Description:
 */
public class LeetCode_101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}
