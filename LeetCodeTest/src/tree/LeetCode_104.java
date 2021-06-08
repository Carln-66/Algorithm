package tree;

/**
 * @Auther: Carl
 * @Date: 2021/06/08/17:44
 * @Description: 二叉树的最大深度
 */
public class LeetCode_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth =  maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
