package offer.tree;

/**
 * @Auther: Carl
 * @Date: 2021/04/28/17:42
 * @Description:    #68_ii  二叉树的最近公共祖先
 */
public class offer_68_ii {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
