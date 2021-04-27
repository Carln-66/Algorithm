package offer.tree;

/**
 * @Auther: Carl
 * @Date: 2021/04/27/18:01
 * @Description: #27    二叉树的镜像
 */
public class offer_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
