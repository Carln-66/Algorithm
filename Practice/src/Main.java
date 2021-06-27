public class Main {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);
        int newSum = root.val + leftMax + rightMax;
        maxSum = Math.max(newSum, maxSum);
        return root.val + Math.max(leftMax, rightMax);
    }
}
