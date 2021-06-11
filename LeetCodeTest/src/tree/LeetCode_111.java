package tree;

/**
 * @Auther: Carl
 * @Date: 2021/06/10/23:11
 * @Description: 二叉树的最小深度
 */
public class LeetCode_111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) return 1;
        int node1 = minDepth(root.left);
        int node2 = minDepth(root.right);
        if (root.left == null || root.right == null) return node1 + node2 + 1;
        return Math.min(node1, node2) + 1;
    }
}
