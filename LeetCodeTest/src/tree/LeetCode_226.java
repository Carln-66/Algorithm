package tree;

/**
 * @Auther: Carl
 * @Date: 2021/09/01/22:39
 * @Description: 翻转二叉树
 */
public class LeetCode_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
