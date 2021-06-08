package tree;

/**
 * @Auther: Carl
 * @Date: 2021/06/08/18:00
 * @Description: 相同的树
 */
public class LeetCode_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
