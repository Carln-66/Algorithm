package tree;

/**
 * @Auther: Carl
 * @Date: 2021/06/22/23:37
 * @Description: 二叉树展开为链表
 */
public class LeetCode_114 {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                pre.left = null;
                root = root.right;
            }
        }
    }
}
