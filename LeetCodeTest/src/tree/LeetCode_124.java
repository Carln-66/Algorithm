package tree;

/**
 * @Auther: Carl
 * @Date: 2021/06/27/15:42
 * @Description: 二叉树中的最大路径和
 */
public class LeetCode_124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        //如果当前节点为null，说明这个节点对于总和的提高没有贡献，所以返回0
        if (root == null) {
            return 0;
        }
        //递归左子树的最大收益
        int leftMax = Math.max(dfs(root.left), 0);
        //递归右子树的最大收益
        int rightMax = Math.max(dfs(root.right), 0);
        //当前收益就等于左子树的最大值+右子树最大值+当前节点值
        int newSum = root.val + leftMax + rightMax;
        //当前收益和前面记录比较
        maxSum = Math.max(newSum, maxSum);
        //返回到目前节点的最大贡献值
        return root.val + Math.max(leftMax, rightMax);
    }
}
