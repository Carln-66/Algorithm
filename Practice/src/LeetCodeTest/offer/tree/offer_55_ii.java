package LeetCodeTest.offer.tree;

/**
 * @Auther: Carl
 * @Date: 2021/04/10/21:51
 * @Description:  #55 - ii  平衡二叉树
 */
public class offer_55_ii {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
